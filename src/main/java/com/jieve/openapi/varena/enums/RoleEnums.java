package com.jieve.openapi.varena.enums;

/**
 * @ClassName RoleEnums
 * @Description 英雄定位
 * @Author Jieve
 * @Date 2018/9/6 18:05
 * @Version 1.0
 **/
public enum RoleEnums {

    /**
     * 辅助
     */
    ROLE_SUPPORT(1,"Support", "辅助"),

    /**
     * 控制
     */
    ROLE_DISABLER(2,"Disabler", "控制"),

    /**
     * 爆发
     */
    ROLE_NUKER(3,"Nuker", "爆发"),

    /**
     * 耐久
     */
    ROLE_DURABLE(4,"Durable", "耐久"),

    /**
     * 先手
     */
    ROLE_INITIATOR(5,"Initiator", "先手"),

    /**
     * 打野
     */
    ROLE_JUNGLER(6,"Jungler", "打野"),

    /**
     * 核心
     */
    ROLE_CARRY(7,"Carry", "核心"),

    /**
     * 逃生
     */
    ROLE_ESCAPE(8,"Escape", "逃生"),

    /**
     * 推进
     */
    ROLE_PUSHER(9,"Pusher", "推进");

    RoleEnums(int id, String key, String name) {
        this.id = id;
        this.key = key;
        this.name = name;
    }

    private int id;

    private String key;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 通过key获取枚举
     * @param key
     * @return
     */
    public static RoleEnums getByKey(String key){
        for (RoleEnums role : RoleEnums.values()) {
            if (role.getKey().equalsIgnoreCase(key)){
                return role;
            }
        }
        return null;
    }

    /**
     * 通过name获取枚举
     * @param name
     * @return
     */
    public static RoleEnums getByName(String name){
        for (RoleEnums role : RoleEnums.values()) {
            if (role.getName().equalsIgnoreCase(name)){
                return role;
            }
        }
        return null;
    }
}
