package com.example.guaranty.api.impl;

import com.example.guaranty.api.UserApi;
import com.example.guaranty.commons.InvokerEnum;
import com.example.guaranty.commons.exception.ChaincodeInternalException;
import com.example.guaranty.commons.handler.SuccessResponse;
import com.example.guaranty.entity.User;
import com.example.guaranty.utils.ByteUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.hyperledger.fabric.shim.Chaincode;
import org.hyperledger.fabric.shim.ChaincodeStub;

import java.util.List;

/**
 * User impl
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/12/7 9:30
 **/
public class UserImpl extends BaseImpl implements UserApi {

    private static final String COLLECTIONS_PREFIX = "user";

    /**
     * Create user
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response createUser(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_CREATE.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_CREATE.getParamCount()));
        }
        String id = params.get(0);
        if (isNumber(id)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 0));
        }
        byte[] bytes = stub.getState(generateKey(id));
        if (!ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("User %s is already exists!!", id));
        }
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(params.get(1));
        user.setRealName("");
        user.setIdNo("");
        user.setRealNameAuth(Boolean.FALSE);
        user.setSex(params.get(2));
        user.setEmail(params.get(3));
        user.setTel(params.get(4));
        user.setValid(Boolean.TRUE);

        stub.putState(generateKey(user.getId().toString()), ByteUtils.objToBytes(user));
        log.info(String.format("Create user %s success!!", user.getUsername()));
        return SuccessResponse.newSuccessResponse("Create user success");
    }

    /**
     * Delete user
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response deleteUser(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_DELETE.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_DELETE.getParamCount()));
        }
        String id = params.get(0);
        byte[] bytes = stub.getState(generateKey(id));
        if (ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("User %s is not exists!!", id));
        }
        User user = ByteUtils.bytesToObj(bytes, User.class);
        log.info(String.format("Select user: %s", user.toString()));
        user.setValid(Boolean.FALSE);
        stub.putState(generateKey(id), ByteUtils.objToBytes(user));

        return SuccessResponse.newSuccessResponse("Delete User success");
    }

    /**
     * RealName Auth user
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response realNameAuth(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_REAL_NAME_AUTH.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_REAL_NAME_AUTH.getParamCount()));
        }
        String id = params.get(0);
        if (isNumber(id)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 0));
        }
        byte[] bytes = stub.getState(generateKey(id));
        if (ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("User %s is not exists!!", id));
        }
        User user = ByteUtils.bytesToObj(bytes, User.class);
        log.info(String.format("Select user: %s", user.toString()));
        user.setRealName(params.get(1));
        user.setIdNo(params.get(2));
        user.setRealNameAuth(Boolean.TRUE);
        stub.putState(generateKey(id), ByteUtils.objToBytes(user));

        return SuccessResponse.newSuccessResponse("Real name auth success");
    }

    /**
     * Update contact info
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response updateContactInfo(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_UPDATE_CONTACT_INFO.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_UPDATE_CONTACT_INFO.getParamCount()));
        }
        String id = params.get(0);
        if (isNumber(id)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 0));
        }
        byte[] bytes = stub.getState(generateKey(id));
        if (ObjectUtils.isEmpty(bytes)) {
            throw new ChaincodeInternalException(String.format("User %s is not exists!!", id));
        }
        User user = ByteUtils.bytesToObj(bytes, User.class);
        String code = params.get(1);
        if (isNumber(code)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 1));
        }
        Integer operation = Integer.parseInt(code);
        switch (operation) {
            case 1:
                user.setEmail(params.get(2));
                break;
            case 2:
                user.setTel(params.get(2));
                break;
            default:
                throw new ChaincodeInternalException(String.format("Unknown operation code %d !!", operation));
        }
        stub.putState(generateKey(id), ByteUtils.objToBytes(user));
        return SuccessResponse.newSuccessResponse("Real ContactInfo success");
    }

    /**
     * Query user
     *
     * @param stub stub
     * @return Response
     * @throws ChaincodeInternalException e
     */
    @Override
    public Chaincode.Response queryUser(ChaincodeStub stub) throws ChaincodeInternalException {
        List<String> params = stub.getParameters();
        if (!InvokerEnum.USER_QUERY.getParamCount().equals(params.size())) {
            throw new ChaincodeInternalException(String.format("Incorrect count of arguments %d!! Expecting %d", params.size(), InvokerEnum.USER_QUERY.getParamCount()));
        }
        String id = params.get(0);
        if (isNumber(id)) {
            throw new ChaincodeInternalException(String.format("Param index of %d must being number!!", 0));
        }
        // Select by id
        byte[] bytes = stub.getState(generateKey(id));
        log.info(String.format("Select user: %s", ByteUtils.bytesToObj(bytes, User.class).toString()));
        return SuccessResponse.newSuccessResponse("Query User success", bytes);
    }

    @Override
    public String generateKey(String id) {
        return COLLECTIONS_PREFIX + "-" + id;
    }

}
