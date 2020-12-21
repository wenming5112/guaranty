package com.example.guaranty.entity;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0.0
 * @date 2020/12/8 13:55
 **/
public class ApiEntity {
    private String functionName;
    private Integer paramCount;
    /**
     * (id:int,userId:int)
     */
    private String[] params;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Integer getParamCount() {
        return paramCount;
    }

    public void setParamCount(Integer paramCount) {
        this.paramCount = paramCount;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "ApiEntity{" +
                "functionName='" + functionName + '\'' +
                ", paramCount='" + paramCount + '\'' +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}
