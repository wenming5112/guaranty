package com.example.guaranty.entity;

/**
 * @author jesus
 * @version 1.0.0
 * @date 2020/12/3 10:37
 **/
public class LoanApplication extends BaseEntity {
    /**
     * Bank ID
     */
    private Integer bankId;
    /**
     * LoanProduct ID
     */
    private Integer loanProductId;
    /**
     * Proposer
     */
    private Integer proposer;
    /**
     * Status (-1:Pending access, 1-access, 0-refuse)
     */
    private String status;
    /**
     * Contract url
     */
    private String materialUrl;
    /**
     * Contract hash
     */
    private String materialHash;

    public LoanApplication() {
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getLoanProductId() {
        return loanProductId;
    }

    public void setLoanProductId(Integer loanProductId) {
        this.loanProductId = loanProductId;
    }

    public Integer getProposer() {
        return proposer;
    }

    public void setProposer(Integer proposer) {
        this.proposer = proposer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaterialUrl() {
        return materialUrl;
    }

    public void setMaterialUrl(String materialUrl) {
        this.materialUrl = materialUrl;
    }

    public String getMaterialHash() {
        return materialHash;
    }

    public void setMaterialHash(String materialHash) {
        this.materialHash = materialHash;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "id='" + getId() + '\'' +
                ",valid='" + getValid() + '\'' +
                ",bankId=" + bankId +
                ", loanProductId=" + loanProductId +
                ", proposer='" + proposer + '\'' +
                ", status=" + status +
                ", materialUrl='" + materialUrl + '\'' +
                ", materialHash='" + materialHash + '\'' +
                '}';
    }
}
