package com.example.guaranty.entity;

/**
 * @author jesus
 * @version 1.0.0
 * @date 2020/12/3 9:54
 **/
public class UserMortgageMaterial extends BaseEntity {
    /**
     * user ID
     */
    private Integer userId;
    /**
     * house material url
     */
    private String houseMaterialUrl;
    /**
     * house material hash
     */
    private String houseMaterialHash;
    /**
     * property material url
     */
    private String propertyMaterialUrl;
    /**
     * property material hash
     */
    private String propertyMaterialHash;
    /**
     * car material url
     */
    private String carMaterialUrl;
    /**
     * car material hash
     */
    private String carMaterialHash;

    public UserMortgageMaterial() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getHouseMaterialUrl() {
        return houseMaterialUrl;
    }

    public void setHouseMaterialUrl(String houseMaterialUrl) {
        this.houseMaterialUrl = houseMaterialUrl;
    }

    public String getHouseMaterialHash() {
        return houseMaterialHash;
    }

    public void setHouseMaterialHash(String houseMaterialHash) {
        this.houseMaterialHash = houseMaterialHash;
    }

    public String getPropertyMaterialUrl() {
        return propertyMaterialUrl;
    }

    public void setPropertyMaterialUrl(String propertyMaterialUrl) {
        this.propertyMaterialUrl = propertyMaterialUrl;
    }

    public String getPropertyMaterialHash() {
        return propertyMaterialHash;
    }

    public void setPropertyMaterialHash(String propertyMaterialHash) {
        this.propertyMaterialHash = propertyMaterialHash;
    }

    public String getCarMaterialUrl() {
        return carMaterialUrl;
    }

    public void setCarMaterialUrl(String carMaterialUrl) {
        this.carMaterialUrl = carMaterialUrl;
    }

    public String getCarMaterialHash() {
        return carMaterialHash;
    }

    public void setCarMaterialHash(String carMaterialHash) {
        this.carMaterialHash = carMaterialHash;
    }

    @Override
    public String toString() {
        return "UserMortgageMaterial{" +
                "id='" + getId() + '\'' +
                ",valid='" + getValid() + '\'' +
                ",userId=" + userId +
                ", houseMaterialUrl='" + houseMaterialUrl + '\'' +
                ", houseMaterialHash='" + houseMaterialHash + '\'' +
                ", propertyMaterialUrl='" + propertyMaterialUrl + '\'' +
                ", propertyMaterialHash='" + propertyMaterialHash + '\'' +
                ", carMaterialUrl='" + carMaterialUrl + '\'' +
                ", carMaterialHash='" + carMaterialHash + '\'' +
                '}';
    }
}
