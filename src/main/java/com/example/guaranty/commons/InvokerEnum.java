package com.example.guaranty.commons;

/**
 * Invoke method enum
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/11/23 10:04
 **/
public enum InvokerEnum {

    // Init
    INIT(0),
    HELP(0),
    // Create account
    USER_CREATE(5),
    // Delete account
    USER_DELETE(1),
    // Update account
    USER_REAL_NAME_AUTH(3),
    // Update contact info
    USER_UPDATE_CONTACT_INFO(3),
    // Query account
    USER_QUERY(1),
    // Create mortgage material
    USER_CREATE_MORTGAGE_MATERIAL(8),
    USER_UPDATE_MORTGAGE_MATERIAL(7),
    USER_DELETE_MORTGAGE_MATERIAL(1),
    USER_QUERY_MORTGAGE_MATERIAL(1),
    USER_QUERY_LOAN_APPLICATION(1),
    USER_CREATE_LOAN_APPLICATION(5),
    USER_DELETE_LOAN_APPLICATION(1),
    USER_ADDITIONAL_LOAN_APPLICATION_CONTACT(3),;

    private Integer paramCount;

    InvokerEnum(Integer paramCount) {
        this.paramCount = paramCount;
    }

    public Integer getParamCount() {
        return this.paramCount;
    }

}
