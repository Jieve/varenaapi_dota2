package com.jieve.openapi.varena.enums;

/**
 * @ClassName AttackTypeEnums
 * @Description 攻击类型枚举
 * @Author Jieve
 * @Date 2018/9/6 17:38
 * @Version 1.0
 **/
public enum AttackTypeEnums {

    /**
     * 近战
     */
    ATTACK_MELLEE(1, "Melee", "近战"),
    /**
     * 远程
     */
    ATTACK_RANGED(2, "Ranged", "远程");

    AttackTypeEnums(int id, String key, String name) {
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
     * 通过key获取对应枚举
     * @param key
     * @return
     */
    public static AttackTypeEnums getByKey(String key){
        for (AttackTypeEnums attackTypeEnums : AttackTypeEnums.values()) {
            if (attackTypeEnums.getKey().equalsIgnoreCase(key)){
                return attackTypeEnums;
            }
        }
        return null;
    }
}
