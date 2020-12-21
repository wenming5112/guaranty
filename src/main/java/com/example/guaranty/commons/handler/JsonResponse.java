package com.example.guaranty.commons.handler;


import org.hyperledger.fabric.shim.Chaincode;

import java.io.Serializable;

/**
 * Json response
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/11/23 11:40
 **/
public class JsonResponse extends Chaincode.Response implements Serializable {
    public JsonResponse(Status status, String message, byte[] payload) {
        super(status, message, payload);
    }
}
