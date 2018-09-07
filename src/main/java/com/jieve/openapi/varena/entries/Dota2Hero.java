package com.jieve.openapi.varena.entries;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.jieve.openapi.varena.commons.Constant;
import com.jieve.openapi.varena.enums.AttackTypeEnums;
import com.jieve.openapi.varena.enums.PrimaryAttributeEnums;
import com.jieve.openapi.varena.enums.RoleEnums;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Dota2Hero
 * @Description DOTA2英雄实体
 * @Author Jieve
 * @Date 2018/9/5 23:29
 * @Version 1.0
 **/
public class Dota2Hero implements Serializable {

    private static final long serialVersionUID = -1024013124435799293L;

    /**
     * 构造器，生成实体
     * @param heroJson
     */
    public Dota2Hero(JSONObject heroJson) {
        if (null == heroJson) {
            return;
        }
        this.id = heroJson.getIntValue(Constant.API_RESULT_HEROFIELD_HEROID);
        this.attackType = AttackTypeEnums.getByKey(heroJson.getString(Constant.API_RESULT_HEROFIELD_ATTACKTYPE));
        this.cnName = heroJson.getString(Constant.API_RESULT_HEROFIELD_CNNAME);
        this.enName = heroJson.getString(Constant.API_RESULT_HEROFIELD_ENNAME);
        this.name = heroJson.getString(Constant.API_RESULT_HEROFIELD_HERONAME);
        this.legs = heroJson.getIntValue(Constant.API_RESULT_HEROFIELD_LEGS);
        this.primaryAttribute = PrimaryAttributeEnums.getByKey(heroJson.getString(Constant.API_RESULT_HEROFIELD_PRIMARYATTR));
        List<String> cnRoles = JSON.parseArray(heroJson.getString(Constant.API_RESULT_HEROFIELD_CNROLES), String.class);
        List<String> enRoles = JSON.parseArray(heroJson.getString(Constant.API_RESULT_HEROFIELD_ENROLES), String.class);

        List<RoleEnums> list = Lists.newArrayList();
        if (cnRoles.size() > enRoles.size()){
            for (String cnRole : cnRoles) {
                list.add(RoleEnums.getByName(cnRole));
            }
        }else{
            for (String enRole : enRoles) {
                list.add(RoleEnums.getByKey(enRole));
            }
        }
        this.roles = list;
    }

    /**
     * 默认构造器
     */
    public Dota2Hero() {
    }

    /**
     * 英雄ID
     */
    private int id;

    /**
     * 英雄全名
     */
    private String name;

    /**
     * 英雄英文名称
     */
    private String enName;

    /**
     * 英雄中文名称
     */
    private String cnName;

    /**
     * 腿的个数
     */
    private int legs;

    /**
     * 英雄主属性
     */
    private PrimaryAttributeEnums primaryAttribute;

    /**
     * 攻击类型枚举
     */
    private AttackTypeEnums attackType;

    /**
     * 英雄定位
     */
    private List<RoleEnums> roles;

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

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public PrimaryAttributeEnums getPrimaryAttribute() {
        return primaryAttribute;
    }

    public void setPrimaryAttribute(PrimaryAttributeEnums primaryAttribute) {
        this.primaryAttribute = primaryAttribute;
    }

    public AttackTypeEnums getAttackType() {
        return attackType;
    }

    public void setAttackType(AttackTypeEnums attackType) {
        this.attackType = attackType;
    }

    public List<RoleEnums> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnums> roles) {
        this.roles = roles;
    }
}
