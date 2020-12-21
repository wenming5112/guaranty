package com.example.guaranty.api;

import com.example.guaranty.commons.exception.ChaincodeInternalException;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

/**
 * Guaranty api
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/11/23 9:59
 **/
public interface Guaranty {

    /**
     * Init
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response init(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * Help
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response help(ChaincodeStub stub) throws ChaincodeInternalException;

}
