package com.example.guaranty.commons.handler;

import org.hyperledger.fabric.shim.Chaincode;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * Global error response
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/11/23 10:01
 **/

public class ErrorResponse {

    private static Chaincode.Response newErrorResponse(String message, byte[] payload) {
        return new Chaincode.Response(Chaincode.Response.Status.INTERNAL_SERVER_ERROR, message, payload);
    }

    public static Chaincode.Response newErrorResponse(String message) {
        return newErrorResponse(message, null);
    }

    public static Chaincode.Response newErrorResponse(byte[] payload) {
        return newErrorResponse(null, payload);
    }

    public static Chaincode.Response newErrorResponse(Throwable throwable) {
        return newErrorResponse(throwable.getMessage(), printStackTrace(throwable));
    }

    private static byte[] printStackTrace(Throwable throwable) {
        if (throwable == null) {
            return null;
        } else {
            StringWriter buffer = new StringWriter();
            throwable.printStackTrace(new PrintWriter(buffer));
            return buffer.toString().getBytes(StandardCharsets.UTF_8);
        }
    }

}
