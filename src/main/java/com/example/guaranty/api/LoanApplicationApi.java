package com.example.guaranty.api;

import com.example.guaranty.commons.exception.ChaincodeInternalException;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

/**
 * Loan Application api
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/12/7 11:13
 **/
public interface LoanApplicationApi {
    /**
     * Create LoanApplication
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response createLoanApplication(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * Delete LoanApplication
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response deleteLoanApplication(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * Update LoanApplication
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response additionalContact(ChaincodeStub stub) throws ChaincodeInternalException;

    /**
     * Query LoanApplication
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    Chaincode.Response queryLoanApplication(ChaincodeStub stub) throws ChaincodeInternalException;
}
