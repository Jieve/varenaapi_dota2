package com.jieve.openapi.varena.commons;

import java.util.Properties;

/**
 * @ClassName Constant
 * @Description 全局常量类
 * @Author Jieve
 * @Date 2018/9/5 21:08
 * @Version 1.0
 **/
public class Constant {

    /**
     * API验签连接符
     */
    public static final String APISIGN_CONNECTOR_VERTICAL = "|";

    /**
     * API参数连接符
     */
    public static final String URL_PARAM_CONNECTOR_EQUAL = "=";

    /**
     * API参数间连接符
     */
    public static final String URL_PARAM_CONNECTOR_AND = "&";

    /**
     * API参数与URI连接符
     */
    public static final String URL_CONNECTOR_QUESTION = "?";

    /**
     * API请求域名
     */
    public static final String API_DOMAIN_NAME = "http://api.varena.com";

    /**
     * 外部配置文件
     */
    public static Properties properties = null;

    /**
     * 配置文件配置项API-KEY，用于验签
     */
    public static final String PROPERTIES_KEY_APIKEY = "API-KEY";

    /**
     * 配置文件配置项API-Secret，用于验签
     */
    public static final String PROPERTIES_KEY_APISECRET = "API-Secret";

    /**
     * 返回码键
     */
    public static final String API_RESULT_RETURNCODE_KEY = "retcode";

    /**
     * 正确返回
     */
    public static final int API_RESULT_RETURNCODE_OK = 200;

    /**
     *返回数据
     */
    public static final String API_RESULT_DATA_KEY = "data";

    /**
     *DOTA2英雄
     */
    public static final String API_RESULT_HEROFIELD_HEROID = "hero_id";
    public static final String API_RESULT_HEROFIELD_HERONAME = "hero_name";
    public static final String API_RESULT_HEROFIELD_CNNAME = "cn_name";
    public static final String API_RESULT_HEROFIELD_ENNAME = "en_name";
    public static final String API_RESULT_HEROFIELD_ATTACKTYPE = "attack_type";
    public static final String API_RESULT_HEROFIELD_LEGS = "legs";
    public static final String API_RESULT_HEROFIELD_PRIMARYATTR = "primary_attr";
    public static final String API_RESULT_HEROFIELD_CNROLES = "cn_roles";
    public static final String API_RESULT_HEROFIELD_ENROLES = "en_roles";


    /**
     * DOTA2物品
     */
    public static final String API_RESULT_ITEMFIELD_ID = "id";
    public static final String API_RESULT_ITEMFIELD_NAME = "name";
    public static final String API_RESULT_ITEMFIELD_COST = "cost";
    public static final String API_RESULT_ITEMFIELD_CNNAME = "cn_name";
    public static final String API_RESULT_ITEMFIELD_ENNAME = "en_name";
    public static final String API_RESULT_ITEMFIELD_RECIPE = "recipe";
    public static final String API_RESULT_ITEMFIELD_SECRETSHOP = "secret_shop";
    public static final String API_RESULT_ITEMFIELD_SIDESHOP = "side_shop";






}
