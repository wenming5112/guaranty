package com.example.guaranty.api.impl;

import com.example.guaranty.api.LoanApplicationApi;
import com.example.guaranty.commons.InvokerEnum;
import com.example.guaranty.commons.exception.ChaincodeInternalException;
import com.example.guaranty.commons.handler.SuccessResponse;
import com.example.guaranty.entity.LoanApplication;
import com.example.guaranty.utils.ByteUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

import java.util.List;

/**
 * @author jesus
 * @version 1.0.0
 * @date 2020/12/8 11:25
 **/
public class LoanApplicationImpl extends BaseImpl implements LoanApplicationApi {
    private static final String COLLECTIONS_PREFIX = "loan-application";

    /**
     * Create LoanApplication
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response createLoanApplication(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_CREATE_LOAN_APPLICATION.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_CREATE_LOAN_APPLICATION.getParamCount()));
        }
        String id = params.get(0);
        if (isNumber(id)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 0));
        }
        String proposer = params.get(1);
        if (isNumber(proposer)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 1));
        }
        String bankId = params.get(2);
        if (isNumber(bankId)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 2));
        }
        String loanProductId = params.get(3);
        if (isNumber(loanProductId)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 3));
        }

        String key = generateKey(id);
        byte[] bytes = stub.getState(key);
        if (!ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("LoanApplication %s is already exists!!", id));
        }
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setId(Integer.parseInt(id));
        loanApplication.setProposer(Integer.parseInt(proposer));
        loanApplication.setBankId(Integer.parseInt(bankId));
        loanApplication.setLoanProductId(Integer.parseInt(loanProductId));
        loanApplication.setStatus(params.get(4));
        loanApplication.setValid(Boolean.TRUE);

        return SuccessResponse.newSuccessResponse("Create loanApplication success");
    }

    /**
     * Delete LoanApplication
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response deleteLoanApplication(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_DELETE_LOAN_APPLICATION.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_DELETE_LOAN_APPLICATION.getParamCount()));
        }
        String id = params.get(0);
        byte[] bytes = stub.getState(generateKey(id));
        if (ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("LoanApplication %s is not exists!!", id));
        }
        LoanApplication loanApplication = ByteUtils.bytesToObj(bytes, LoanApplication.class);
        log.info(String.format("Select user loanApplication: %s", loanApplication.toString()));
        loanApplication.setValid(Boolean.FALSE);
        stub.putState(generateKey(id), ByteUtils.objToBytes(loanApplication));

        return SuccessResponse.newSuccessResponse("Delete loanApplication success");
    }

    /**
     * Update LoanApplication
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response additionalContact(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_ADDITIONAL_LOAN_APPLICATION_CONTACT.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_ADDITIONAL_LOAN_APPLICATION_CONTACT.getParamCount()));
        }
        String id = params.get(0);
        if (isNumber(id)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 0));
        }
        String key = generateKey(id);
        byte[] bytes = stub.getState(key);
        if (ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("LoanApplication %s is not exists!!", id));
        }

        LoanApplication loanApplication = ByteUtils.bytesToObj(bytes, LoanApplication.class);
        loanApplication.setMaterialHash(params.get(1));
        loanApplication.setMaterialUrl(params.get(2));
        stub.putState(key, ByteUtils.objToBytes(loanApplication));
        return SuccessResponse.newSuccessResponse("Additional LoanApplication Contact success");
    }

    /**
     * Query LoanApplication
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response queryLoanApplication(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_QUERY_LOAN_APPLICATION.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_QUERY_LOAN_APPLICATION.getParamCount()));
        }
        String id = params.get(0);
        if (isNumber(id)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 0));
        }
        byte[] bytes = stub.getState(generateKey(id));
        if (ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("LoanApplication %s is not exists!!", id));
        }
        return SuccessResponse.newSuccessResponse("Query LoanApplication success", bytes);
    }

    @Override
    public String generateKey(String id) {
        return COLLECTIONS_PREFIX + id;
    }
}
