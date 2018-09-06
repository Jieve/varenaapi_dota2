package com.jieve.openapi.varena.enums;

/**
 * @ClassName PrimaryAttributeEnums
 * @Description TODO
 * @Author Jieve
 * @Date 2018/9/6 17:54
 * @Version 1.0
 **/
public enum PrimaryAttributeEnums {

    /**
     * 敏捷
     */
    ATTRIBUTE_AGI(1, "agi", "敏捷"),

    /**
     * 力量
     */
    ATTRIBUTE_STR(2, "str", "力量"),

    /**
     * 智力
     */
    ATTRIBUTE_INT(3, "int", "智力");

    PrimaryAttributeEnums(int id, String key, String name) {
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
    public static PrimaryAttributeEnums getByKey(String key){
        for (PrimaryAttributeEnums primaryAttributeEnums : PrimaryAttributeEnums.values()) {
            if (primaryAttributeEnums.getKey().equalsIgnoreCase(key)){
                return primaryAttributeEnums;
            }
        }
        return null;
    }
}
