package com.example.guaranty.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.regex.Pattern;

/**
 * Base impl
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/12/8 10:44
 **/
public abstract class BaseImpl {
    Log log = LogFactory.getLog(this.getClass());
    private static final String IS_NUMBER = "^[-+]?[\\d]*$";

    public abstract String generateKey(String id);

    Boolean isNumber(String str) {
        Pattern pattern = Pattern.compile(IS_NUMBER);
        return !pattern.matcher(str).matches();
    }
}
