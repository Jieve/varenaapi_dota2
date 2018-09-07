package com.jieve.openapi.varena.entries;

import com.alibaba.fastjson.JSONObject;
import com.jieve.openapi.varena.commons.Constant;

import java.io.Serializable;

/**
 * @ClassName Dota2Item
 * @Description DOTA2道具
 * @Author Jieve
 * @Date 2018/9/7 16:18
 * @Version 1.0
 **/
public class Dota2Item implements Serializable {

    private static final long serialVersionUID = -4690047101671445665L;

    /**
     * 构造器，生成实体
     * @param itemJson
     */
    public Dota2Item(JSONObject itemJson) {
        if (null == itemJson) {
            return;
        }
        this.id = itemJson.getIntValue(Constant.API_RESULT_ITEMFIELD_ID);
        this.name = itemJson.getString(Constant.API_RESULT_ITEMFIELD_NAME);
        this.cost = itemJson.getIntValue(Constant.API_RESULT_ITEMFIELD_COST);
        this.cnName = itemJson.getString(Constant.API_RESULT_ITEMFIELD_CNNAME);
        this.enName = itemJson.getString(Constant.API_RESULT_ITEMFIELD_ENNAME);
        this.isRecipe = itemJson.getBooleanValue(Constant.API_RESULT_ITEMFIELD_RECIPE);
        this.isSecretShop = itemJson.getBooleanValue(Constant.API_RESULT_ITEMFIELD_SECRETSHOP);
        this.isSideShop = itemJson.getBooleanValue(Constant.API_RESULT_ITEMFIELD_SIDESHOP);
    }

    /**
     * 默认构造器
     */
    public Dota2Item() {
    }

    /**
     * 物品ID
     */
    private int id;

    /**
     * 物品名称
     */
    private String name;

    /**
     * 花费金币
     */
    private int cost;

    /**
     * 英文名称
     */
    private String enName;

    /**
     * 中文名称
     */
    private String cnName;

    /**
     * 是否为卷轴
     */
    private boolean isRecipe;

    /**
     * 是否神秘商店购买
     */
    private boolean isSecretShop;

    /**
     * 是否路边商店购买
     */
    private boolean isSideShop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public boolean isRecipe() {
        return isRecipe;
    }

    public void setRecipe(boolean recipe) {
        isRecipe = recipe;
    }

    public boolean isSecretShop() {
        return isSecretShop;
    }

    public void setSecretShop(boolean secretShop) {
        isSecretShop = secretShop;
    }

    public boolean isSideShop() {
        return isSideShop;
    }

    public void setSideShop(boolean sideShop) {
        isSideShop = sideShop;
    }
}
