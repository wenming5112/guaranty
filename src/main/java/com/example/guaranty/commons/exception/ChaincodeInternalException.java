package com.example.guaranty.commons.exception;

/**
 * @author jesus
 * @version 1.0.0
 * @date 2020/11/23 11:46
 **/
public class ChaincodeInternalException extends Exception {
    private static final long serialVersionUID = 1782066458001959902L;

    public ChaincodeInternalException(String message) {
        super(message);
    }

}
