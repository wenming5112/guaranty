package com.example.guaranty.api;

import com.example.guaranty.commons.exception.ChaincodeInternalException;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

/**
 * User Api
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/12/7 9:31
 **/
public interface UserApi {
    /**
     * Create user
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response createUser(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * Delete user
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response deleteUser(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * RealName Auth
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response realNameAuth(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * Update contact info
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response updateContactInfo(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * Query user
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response queryUser(ChaincodeStub stub) throws ChaincodeInternalException;
}
