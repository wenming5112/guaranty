package com.example.guaranty;

import com.example.guaranty.api.Guaranty;
import com.example.guaranty.api.LoanApplicationApi;
import com.example.guaranty.api.UserApi;
import com.example.guaranty.api.UserMortgageMaterialApi;
import com.example.guaranty.api.impl.GuarantyImpl;
import com.example.guaranty.api.impl.LoanApplicationImpl;
import com.example.guaranty.api.impl.UserImpl;
import com.example.guaranty.api.impl.UserMortgageMaterialImpl;
import com.example.guaranty.commons.InvokerEnum;
import com.example.guaranty.commons.exception.ChaincodeInternalException;
import com.example.guaranty.commons.handler.ErrorResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.fabric.shim.ChaincodeBase;
import org.hyperledger.fabric.shim.ChaincodeStub;

/**
 * Guaranty chaincode main entry
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/11/23 9:46
 **/
public class GuarantyChaincodeEntry extends ChaincodeBase {
    private static Log log = LogFactory.getLog(GuarantyChaincodeEntry.class);

    private Guaranty api = new GuarantyImpl();
    private UserApi userApi = new UserImpl();
    private UserMortgageMaterialApi mortgageMaterialApi = new UserMortgageMaterialImpl();
    private LoanApplicationApi loanApplicationApi = new LoanApplicationImpl();

    /**
     * Default method init
     *
     * @param stub stub
     * @return Response
     */
    @Override
    public Response init(ChaincodeStub stub) {
        try {
            return api.init(stub);
        } catch (ChaincodeInternalException e) {
            return ErrorResponse.newErrorResponse(String.format("Internal error happened : %s !!", e.getMessage()));
        }
    }

    /**
     * Default method invoke
     *
     * @param stub stub
     * @return Response
     */
    @Override
    public Response invoke(ChaincodeStub stub) {
        try {
            String function = stub.getFunction();
            log.info(String.format("Executing invoke method : %s !!", function));
            switch (InvokerEnum.valueOf(function)) {
                case HELP:
                    return api.help(stub);
                // User contract
                case USER_CREATE:
                    return userApi.createUser(stub);
                case USER_DELETE:
                    return userApi.deleteUser(stub);
                case USER_REAL_NAME_AUTH:
                    return userApi.realNameAuth(stub);
                case USER_UPDATE_CONTACT_INFO:
                    return userApi.updateContactInfo(stub);
                case USER_QUERY:
                    return userApi.queryUser(stub);
                // User mortgage material
                case USER_CREATE_MORTGAGE_MATERIAL:
                    return mortgageMaterialApi.createUserMortgageMaterial(stub);
                case USER_DELETE_MORTGAGE_MATERIAL:
                    return mortgageMaterialApi.deleteUserMortgageMaterial(stub);
                case USER_UPDATE_MORTGAGE_MATERIAL:
                    return mortgageMaterialApi.updateUserMortgageMaterial(stub);
                case USER_QUERY_MORTGAGE_MATERIAL:
                    return mortgageMaterialApi.queryUserMortgageMaterial(stub);
                // User loan application
                case USER_CREATE_LOAN_APPLICATION:
                    return loanApplicationApi.createLoanApplication(stub);
                case USER_ADDITIONAL_LOAN_APPLICATION_CONTACT:
                    return loanApplicationApi.additionalContact(stub);
                case USER_QUERY_LOAN_APPLICATION:
                    return loanApplicationApi.queryLoanApplication(stub);
                case USER_DELETE_LOAN_APPLICATION:
                    return loanApplicationApi.deleteLoanApplication(stub);
                default:
                    return ErrorResponse.newErrorResponse(String.format("Unknown invoke method : %s !!", function));
            }
        } catch (ChaincodeInternalException e) {
            return ErrorResponse.newErrorResponse(String.format("Internal error happened : %s !!", e.getMessage()));
        }
    }

    public static void main(String[] args) {
        new GuarantyChaincodeEntry().start(args);
    }
}
