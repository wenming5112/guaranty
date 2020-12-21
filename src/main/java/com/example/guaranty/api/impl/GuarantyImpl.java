package com.example.guaranty.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.guaranty.api.Guaranty;
import com.example.guaranty.commons.InvokerEnum;
import com.example.guaranty.commons.exception.ChaincodeInternalException;
import com.example.guaranty.commons.handler.SuccessResponse;
import com.example.guaranty.entity.ApiEntity;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

import java.util.List;

/**
 * Guaranty impl
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/11/23 10:01
 **/
public class GuarantyImpl extends BaseImpl implements Guaranty {

    /**
     * Init
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response init(ChaincodeStub stub) throws ChaincodeInternalException {
        log.info("Executing init method!!");
        List<String> params = stub.getParameters();
        if (!InvokerEnum.INIT.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.INIT.getParamCount()));
        }
        return SuccessResponse.newSuccessResponse("Init success");
    }

    /**
     * Help
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response help(ChaincodeStub stub) throws ChaincodeInternalException {
        // userCreate
        ApiEntity userCreate = new ApiEntity();
        userCreate.setFunctionName(InvokerEnum.USER_CREATE.name());
        userCreate.setParamCount(InvokerEnum.USER_CREATE.getParamCount());
        String[] userCreateParams = {"id:int", "username:string", "sex:string", "email:string", "tel:string"};
        userCreate.setParams(userCreateParams);
        // deleteUser
        ApiEntity deleteUser = new ApiEntity();
        deleteUser.setFunctionName(InvokerEnum.USER_DELETE.name());
        deleteUser.setParamCount(InvokerEnum.USER_DELETE.getParamCount());
        String[] deleteUserParams = {"id:int"};
        deleteUser.setParams(deleteUserParams);
        // realNameAuth
        ApiEntity realNameAuth = new ApiEntity();
        realNameAuth.setFunctionName(InvokerEnum.USER_REAL_NAME_AUTH.name());
        realNameAuth.setParamCount(InvokerEnum.USER_REAL_NAME_AUTH.getParamCount());
        String[] realNameAuthParams = {"id:int", "realName:string", "idNo:string"};
        realNameAuth.setParams(realNameAuthParams);
        // updateContactInfo
        ApiEntity updateContactInfo = new ApiEntity();
        updateContactInfo.setFunctionName(InvokerEnum.USER_UPDATE_CONTACT_INFO.name());
        updateContactInfo.setParamCount(InvokerEnum.USER_UPDATE_CONTACT_INFO.getParamCount());
        String[] updateContactInfoParams = {"id:int", "code<1-email,2-tel>:int", "contactInfo:string"};
        updateContactInfo.setParams(updateContactInfoParams);
        // queryUser
        ApiEntity queryUser = new ApiEntity();
        queryUser.setFunctionName(InvokerEnum.USER_QUERY.name());
        queryUser.setParamCount(InvokerEnum.USER_QUERY.getParamCount());
        String[] queryUserParams = {"id:int"};
        queryUser.setParams(queryUserParams);
        // createUserMortgageMaterial
        ApiEntity createUserMortgageMaterial = new ApiEntity();
        createUserMortgageMaterial.setFunctionName(InvokerEnum.USER_CREATE_MORTGAGE_MATERIAL.name());
        createUserMortgageMaterial.setParamCount(InvokerEnum.USER_CREATE_MORTGAGE_MATERIAL.getParamCount());
        String[] createUserMortgageMaterialParams = {"id:int", "userId:int",
                "houseMaterialHash:string", "houseMaterialUrl:string",
                "propertyMaterialHash:string", "propertyMaterialUrl:string",
                "carMaterialHash:string", "carMaterialUrl:string"};
        createUserMortgageMaterial.setParams(createUserMortgageMaterialParams);
        // deleteUserMortgageMaterial
        ApiEntity deleteUserMortgageMaterial = new ApiEntity();
        deleteUserMortgageMaterial.setFunctionName(InvokerEnum.USER_DELETE_MORTGAGE_MATERIAL.name());
        deleteUserMortgageMaterial.setParamCount(InvokerEnum.USER_DELETE_MORTGAGE_MATERIAL.getParamCount());
        String[] deleteUserMortgageMaterialParams = {"id:int"};
        deleteUserMortgageMaterial.setParams(deleteUserMortgageMaterialParams);
        // updateUserMortgageMaterial
        ApiEntity updateUserMortgageMaterial = new ApiEntity();
        updateUserMortgageMaterial.setFunctionName(InvokerEnum.USER_UPDATE_MORTGAGE_MATERIAL.name());
        updateUserMortgageMaterial.setParamCount(InvokerEnum.USER_UPDATE_MORTGAGE_MATERIAL.getParamCount());
        String[] updateUserMortgageMaterialParams = {"id:int",
                "houseMaterialHash:string", "houseMaterialUrl:string",
                "propertyMaterialHash:string", "propertyMaterialUrl:string",
                "carMaterialHash:string", "carMaterialUrl:string"};
        updateUserMortgageMaterial.setParams(updateUserMortgageMaterialParams);
        // queryUserMortgageMaterial
        ApiEntity queryUserMortgageMaterial = new ApiEntity();
        queryUserMortgageMaterial.setFunctionName(InvokerEnum.USER_QUERY_MORTGAGE_MATERIAL.name());
        queryUserMortgageMaterial.setParamCount(InvokerEnum.USER_QUERY_MORTGAGE_MATERIAL.getParamCount());
        String[] queryUserMortgageMaterialParams = {"id:int"};
        queryUserMortgageMaterial.setParams(queryUserMortgageMaterialParams);
        // createLoanApplication
        ApiEntity createLoanApplication = new ApiEntity();
        createLoanApplication.setFunctionName(InvokerEnum.USER_CREATE_LOAN_APPLICATION.name());
        createLoanApplication.setParamCount(InvokerEnum.USER_CREATE_LOAN_APPLICATION.getParamCount());
        String[] createLoanApplicationParams = {"id:int",
                "proposer:int", "bankId:int",
                "loanProductId:int", "propertyMaterialUrl:string",
                "status:string"};
        createLoanApplication.setParams(createLoanApplicationParams);
        // deleteLoanApplication
        ApiEntity deleteLoanApplication = new ApiEntity();
        deleteLoanApplication.setFunctionName(InvokerEnum.USER_DELETE_LOAN_APPLICATION.name());
        deleteLoanApplication.setParamCount(InvokerEnum.USER_DELETE_LOAN_APPLICATION.getParamCount());
        String[] deleteLoanApplicationParams = {"id:int"};
        deleteLoanApplication.setParams(deleteLoanApplicationParams);
        // additionalContact
        ApiEntity additionalContact = new ApiEntity();
        additionalContact.setFunctionName(InvokerEnum.USER_ADDITIONAL_LOAN_APPLICATION_CONTACT.name());
        additionalContact.setParamCount(InvokerEnum.USER_ADDITIONAL_LOAN_APPLICATION_CONTACT.getParamCount());
        String[] additionalContactParams = {"id:int", "materialHash:string", "materialUrl:string"};
        additionalContact.setParams(additionalContactParams);
        // queryLoanApplication
        ApiEntity queryLoanApplication = new ApiEntity();
        queryLoanApplication.setFunctionName(InvokerEnum.USER_QUERY_LOAN_APPLICATION.name());
        queryLoanApplication.setParamCount(InvokerEnum.USER_QUERY_LOAN_APPLICATION.getParamCount());
        String[] queryLoanApplicationParams = {"id:int"};
        queryLoanApplication.setParams(queryLoanApplicationParams);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put(InvokerEnum.USER_CREATE.name().toLowerCase(), userCreate);
        jsonObject.put(InvokerEnum.USER_DELETE.name().toLowerCase(), deleteUser);
        jsonObject.put(InvokerEnum.USER_REAL_NAME_AUTH.name().toLowerCase(), realNameAuth);
        jsonObject.put(InvokerEnum.USER_UPDATE_CONTACT_INFO.name().toLowerCase(), updateContactInfo);
        jsonObject.put(InvokerEnum.USER_QUERY.name().toLowerCase(), queryUser);
        jsonObject.put(InvokerEnum.USER_CREATE_MORTGAGE_MATERIAL.name().toLowerCase(), createUserMortgageMaterial);
        jsonObject.put(InvokerEnum.USER_DELETE_MORTGAGE_MATERIAL.name().toLowerCase(), deleteUserMortgageMaterial);
        jsonObject.put(InvokerEnum.USER_UPDATE_MORTGAGE_MATERIAL.name().toLowerCase(), updateUserMortgageMaterial);
        jsonObject.put(InvokerEnum.USER_QUERY_MORTGAGE_MATERIAL.name().toLowerCase(), queryUserMortgageMaterial);
        jsonObject.put(InvokerEnum.USER_CREATE_LOAN_APPLICATION.name().toLowerCase(), createLoanApplication);
        jsonObject.put(InvokerEnum.USER_DELETE_LOAN_APPLICATION.name().toLowerCase(), deleteLoanApplication);
        jsonObject.put(InvokerEnum.USER_ADDITIONAL_LOAN_APPLICATION_CONTACT.name().toLowerCase(), additionalContact);
        jsonObject.put(InvokerEnum.USER_QUERY_LOAN_APPLICATION.name().toLowerCase(), queryLoanApplication);

        byte[] bytes = JSON.toJSONString(jsonObject).getBytes();
        return SuccessResponse.newSuccessResponse(bytes);
    }

    @Override
    public String generateKey(String id) {
        return null;
    }
}
