package com.example.guaranty.api.impl;

import com.example.guaranty.api.UserMortgageMaterialApi;
import com.example.guaranty.commons.InvokerEnum;
import com.example.guaranty.commons.exception.ChaincodeInternalException;
import com.example.guaranty.commons.handler.SuccessResponse;
import com.example.guaranty.entity.UserMortgageMaterial;
import com.example.guaranty.utils.ByteUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

import java.util.List;

/**
 * User MortgageMaterial Impl
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/12/8 10:36
 **/
public class UserMortgageMaterialImpl extends BaseImpl implements UserMortgageMaterialApi {
    private static final String COLLECTIONS_PREFIX = "user-mortgage-material";

    /**
     * Create MortgageMaterial
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response createUserMortgageMaterial(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_CREATE_MORTGAGE_MATERIAL.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_CREATE_MORTGAGE_MATERIAL.getParamCount()));
        }
        String id = params.get(0);
        if (isNumber(id)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 0));
        }
        String userId = params.get(1);
        if (isNumber(userId)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 1));
        }
        String key = generateKey(id);
        byte[] bytes = stub.getState(key);
        if (!ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("UserMortgageMaterial %s is already exists!!", id));
        }
        UserMortgageMaterial mortgageMaterial = new UserMortgageMaterial();
        mortgageMaterial.setId(Integer.parseInt(id));
        mortgageMaterial.setUserId(Integer.parseInt(userId));
        mortgageMaterial.setHouseMaterialHash(params.get(2));
        mortgageMaterial.setHouseMaterialUrl(params.get(3));
        mortgageMaterial.setPropertyMaterialHash(params.get(4));
        mortgageMaterial.setPropertyMaterialUrl(params.get(5));
        mortgageMaterial.setCarMaterialHash(params.get(6));
        mortgageMaterial.setCarMaterialUrl(params.get(7));
        mortgageMaterial.setValid(Boolean.TRUE);
        stub.putState(key, ByteUtils.objToBytes(mortgageMaterial));

        return SuccessResponse.newSuccessResponse("Create UserMortgageMaterial success");
    }

    /**
     * Delete MortgageMaterial
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response deleteUserMortgageMaterial(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_DELETE.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_DELETE.getParamCount()));
        }
        String id = params.get(0);
        String key = generateKey(id);
        byte[] bytes = stub.getState(key);
        if (ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("User %s is not exists!!", id));
        }
        UserMortgageMaterial mortgageMaterial = ByteUtils.bytesToObj(bytes, UserMortgageMaterial.class);
        log.info(String.format("Select user mortgageMaterial: %s", mortgageMaterial.toString()));
        mortgageMaterial.setValid(Boolean.FALSE);
        stub.putState(key, ByteUtils.objToBytes(mortgageMaterial));

        return SuccessResponse.newSuccessResponse("Delete UserMortgageMaterial success");
    }

    /**
     * Update MortgageMaterial
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response updateUserMortgageMaterial(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_UPDATE_MORTGAGE_MATERIAL.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_UPDATE_MORTGAGE_MATERIAL.getParamCount()));
        }
        String id = params.get(0);
        if (isNumber(id)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 0));
        }
        String key = generateKey(id);
        byte[] bytes = stub.getState(key);
        if (ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("UserMortgageMaterial %s is not exists!!", id));
        }
        UserMortgageMaterial mortgageMaterial = ByteUtils.bytesToObj(bytes, UserMortgageMaterial.class);
        mortgageMaterial.setHouseMaterialHash(params.get(1));
        mortgageMaterial.setHouseMaterialUrl(params.get(2));
        mortgageMaterial.setPropertyMaterialHash(params.get(3));
        mortgageMaterial.setPropertyMaterialUrl(params.get(4));
        mortgageMaterial.setCarMaterialHash(params.get(5));
        mortgageMaterial.setCarMaterialUrl(params.get(6));
        stub.putState(key, ByteUtils.objToBytes(mortgageMaterial));

        return SuccessResponse.newSuccessResponse("Update UserMortgageMaterial success");
    }

    /**
     * Query MortgageMaterial
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response queryUserMortgageMaterial(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_QUERY_MORTGAGE_MATERIAL.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_QUERY_MORTGAGE_MATERIAL.getParamCount()));
        }
        String id = params.get(0);
        if (isNumber(id)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 0));
        }
        byte[] bytes = stub.getState(generateKey(id));
        if (ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("UserMortgageMaterial %s is not exists!!", id));
        }
        return SuccessResponse.newSuccessResponse("Query UserMortgageMaterial success", bytes);
    }

    @Override
    public String generateKey(String id) {
        return COLLECTIONS_PREFIX + id;
    }
}
