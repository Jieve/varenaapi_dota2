package com.jieve.openapi.varena.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.jieve.openapi.varena.commons.Constant;
import com.jieve.openapi.varena.entries.Dota2Hero;
import com.jieve.openapi.varena.entries.Dota2Item;
import com.jieve.openapi.varena.enums.Dota2ApiMethodEnums;
import com.jieve.openapi.varena.exceptions.ValidateException;
import com.jieve.openapi.varena.utils.HttpHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @ClassName VarenaApi
 * @Description DOTA2接口
 * @Author Jieve
 * @Date 2018/9/5 21:38
 * @Version 1.0
 **/
public class VarenaApi {

    /**
     * 私有构造器，不允许实例化哦
     */
    private VarenaApi() {
    }

    /**
     * 获取所有DOTA2已发布英雄信息
     * @return
     */
    public static List<Dota2Hero> getAllHeros(){
        List<Dota2Hero> list = null;
        String result = process(Dota2ApiMethodEnums.METHOD_GETALLHEROS, null);
        if (StringUtils.isNotEmpty(result)){
            list = parseHeros(result);
        }
        return list;
    }

    /**
     * 获取所有DOTA2已发布物品信息
     * @return
     */
    public static List<Dota2Item> getAllItems(){
        List<Dota2Item> list = null;
        String result = process(Dota2ApiMethodEnums.METHOD_GETALLITEMS, null);
        if (StringUtils.isNotEmpty(result)){
            list = parseItems(result);
        }
        return list;
    }

    /**
     * 将API返回数据处理成英雄实体的集合
     * @param resource
     * @return
     */
    private static List<Dota2Hero> parseHeros(String resource){
        List<Dota2Hero> list = null;
        JSONObject resultJson = JSON.parseObject(resource);
        if (Constant.API_RESULT_RETURNCODE_OK == resultJson.getIntValue(Constant.API_RESULT_RETURNCODE_KEY)){
            List<String> data = JSON.parseArray(resultJson.getString(Constant.API_RESULT_DATA_KEY), String.class);
            if (CollectionUtils.isNotEmpty(data)) {
                list = Lists.newArrayList();
                for (String each : data) {
                    JSONObject eachJson = JSON.parseObject(each);
                    if (null != eachJson){
                        list.add(new Dota2Hero(eachJson));
                    }
                }
            }
        }
        return list;
    }

    /**
     * 将API返回数据处理成物品实体的集合
     * @param resource
     * @return
     */
    private static List<Dota2Item> parseItems(String resource){
        List<Dota2Item> list = null;
        JSONObject resultJson = JSON.parseObject(resource);
        if (Constant.API_RESULT_RETURNCODE_OK == resultJson.getIntValue(Constant.API_RESULT_RETURNCODE_KEY)){
            List<String> data = JSON.parseArray(resultJson.getString(Constant.API_RESULT_DATA_KEY), String.class);
            if (CollectionUtils.isNotEmpty(data)) {
                list = Lists.newArrayList();
                for (String each : data) {
                    JSONObject eachJson = JSON.parseObject(each);
                    if (null != eachJson){
                        list.add(new Dota2Item(eachJson));
                    }
                }
            }
        }
        return list;
    }

    /**
     * 请求API获取数据
     * @param dota2ApiMethodEnums
     * @param params
     * @return
     */
    private static String process(Dota2ApiMethodEnums dota2ApiMethodEnums, Map<String, String> params){
        String result = null;
        if (null != dota2ApiMethodEnums){
            try {
                result = HttpHelper.get(Constant.API_DOMAIN_NAME, dota2ApiMethodEnums.getUri(), getParams(dota2ApiMethodEnums.getParamKeys(), params));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ValidateException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 处理接口传参
     * @param paramKeys
     * @param params
     * @return
     * @throws ValidateException
     */
    private static String getParams(String[] paramKeys, Map<String, String> params) throws ValidateException{
        StringBuilder result = new StringBuilder();
        List<String> tempList = Lists.newArrayList();
        if (null != paramKeys && paramKeys.length >= 0){
            for (String paramKey : paramKeys) {
                if (null != paramKey) {
                    String paramValue = params.get(paramKey);
                    tempList.add(paramKey.concat(Constant.URL_PARAM_CONNECTOR_EQUAL).concat(paramValue));
                }
            }
            if (CollectionUtils.isEmpty(tempList)){
                return result.toString();
            }
            //排序
            Collections.sort(tempList);

            for (int i = 0; i < tempList.size(); i++) {
                result.append(tempList.get(i))
                      .append(Constant.URL_PARAM_CONNECTOR_AND);
            }
            return result.substring(0, result.length() - 1);
        } else {
            throw new ValidateException("参数验证异常");
        }
    }

}
