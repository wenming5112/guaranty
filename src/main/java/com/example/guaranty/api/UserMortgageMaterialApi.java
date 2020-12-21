package com.example.guaranty.api;

import com.example.guaranty.commons.exception.ChaincodeInternalException;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

/**
 * MortgageMaterial api
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/12/7 11:11
 **/
public interface UserMortgageMaterialApi {
    /**
     * Create MortgageMaterial
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response createUserMortgageMaterial(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * Delete MortgageMaterial
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response deleteUserMortgageMaterial(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * Update MortgageMaterial
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response updateUserMortgageMaterial(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * Query MortgageMaterial
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response queryUserMortgageMaterial(ChaincodeStub stub) throws ChaincodeInternalException;
}
