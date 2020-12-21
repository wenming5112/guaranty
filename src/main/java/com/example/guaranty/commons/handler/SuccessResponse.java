package com.example.guaranty.commons.handler;

import org.hyperledger.fabric.shim.Chaincode;

/**
 * Global success response
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/11/23 10:01
 **/

public class SuccessResponse {

    public static Chaincode.Response newSuccessResponse(String message, byte[] payload) {
        return new Chaincode.Response(Chaincode.Response.Status.SUCCESS, message, payload);
    }

    public static Chaincode.Response newSuccessResponse() {
        return newSuccessResponse(null,  null);
    }

    public static Chaincode.Response newSuccessResponse(String message) {
        return newSuccessResponse(message, null);
    }

    public static Chaincode.Response newSuccessResponse(byte[] payload) {
        return newSuccessResponse( null, payload);
    }
}
