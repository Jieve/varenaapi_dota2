package com.jieve.openapi.varena.exceptions;

/**
 * @ClassName ValidateException
 * @Description 数据验证异常
 * @Author Jieve
 * @Date 2018/9/6 15:24
 * @Version 1.0
 **/
public class ValidateException extends Exception {

    private static final long serialVersionUID = 4599366419839194529L;

    public ValidateException(String message) {
        super(message);
    }
}
