package com.jieve.openapi.varena.utils;

import com.jieve.openapi.varena.commons.Constant;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @ClassName HttpHelper
 * @Description HTTP工具类
 * @Author Jieve
 * @Date 2018/9/5 14:41
 * @Version 1.0
 **/
public class HttpHelper {

    static class OkHttpClientHolder{
        private static volatile OkHttpClient client = null;
    }

    private static OkHttpClient getOkHttpClient(){
        if (null == OkHttpClientHolder.client){
            synchronized (OkHttpClientHolder.class){
                if (null == OkHttpClientHolder.client){
                    OkHttpClientHolder.client = new OkHttpClient();
                }
            }
        }
        return OkHttpClientHolder.client;
    }

    /**
     * get方法请求API
     * @param url
     * @param uri
     * @param params
     * @return
     * @throws IOException
     */
    public static String get(String url,String uri,String params) throws IOException {

        String apiKey = Constant.properties.getProperty(Constant.PROPERTIES_KEY_APIKEY);
        String apiSecret = Constant.properties.getProperty(Constant.PROPERTIES_KEY_APISECRET);
        String apiNonce = StringUtil.getFixLenthString(8);
        String time = System.currentTimeMillis()/1000 + "";

        StringBuilder data = new StringBuilder();
                data.append(apiNonce)
                    .append(Constant.APISIGN_CONNECTOR_VERTICAL)
                    .append(apiSecret)
                    .append(Constant.APISIGN_CONNECTOR_VERTICAL)
                    .append(time)
                    .append(Constant.APISIGN_CONNECTOR_VERTICAL)
                    .append(uri)
                    .append(Constant.APISIGN_CONNECTOR_VERTICAL)
                    .append(StringUtils.isEmpty(params)?"":params);
        String apiSign = DigestUtils.md5Hex(data.toString());

        StringBuilder requestUrl = new StringBuilder();
                requestUrl.append(url)
                          .append(uri)
                          .append(StringUtils.isEmpty(params)?"":Constant.URL_CONNECTOR_QUESTION.concat(params));

        Request request = new Request.Builder()
                .url(requestUrl.toString())
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Accept-ApiKey", apiKey)
                .addHeader("Accept-ApiNonce", apiNonce)
                .addHeader("Accept-ApiTime", time)
                .addHeader("Accept-ApiSign", apiSign)
                .build();

        final Call call = getOkHttpClient().newCall(request);
        Response response = call.execute();
        if (response != null && response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

}
