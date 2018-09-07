package com.jieve.openapi.varena.enums;

/**
 * @ClassName HttpHelper
 * @Description 支持的api方法枚举类
 * @Author Jieve
 * @Date 2018/9/5 14:41
 * @Version 1.0
 **/
public enum Dota2ApiMethodEnums {

    /*
    * 获取所有DOTA2英雄
    */
    METHOD_GETALLHEROS(1, "/data-service/dota2/public/raw/heroes", new String[0]),

    METHOD_GETALLITEMS(2, "/data-service/dota2/public/raw/items", new String[0]);

    Dota2ApiMethodEnums(int id, String uri, String[] paramKeys) {
        this.id = id;
        this.uri = uri;
        this.paramKeys = paramKeys;
    }

    private int id;

    private String uri;

    private String[] paramKeys;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String[] getParamKeys() {
        return paramKeys;
    }

    public void setParamKeys(String[] paramKeys) {
        this.paramKeys = paramKeys;
    }
}
