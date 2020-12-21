package com.example.guaranty.entity;

/**
 * User entity
 *
 * @author jesus
 * @version 1.0.0
 * @date 2020/11/30 16:24
 **/
public class User extends BaseEntity {

    /**
     * user name
     */
    private String username;
    /**
     * id card No
     */
    private String idNo;
    /**
     * real name
     */
    private String realName;
    /**
     * sex
     */
    private String sex;
    /**
     * email
     */
    private String email;
    /**
     * tel
     */
    private String tel;
    /**
     * is real name auth
     */
    private Boolean realNameAuth;

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Boolean getRealNameAuth() {
        return realNameAuth;
    }

    public void setRealNameAuth(Boolean realNameAuth) {
        this.realNameAuth = realNameAuth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + getId() + '\'' +
                ",valid='" + getValid() + '\'' +
                ",username='" + username + '\'' +
                ", idNo='" + idNo + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", realNameAuth=" + realNameAuth +
                '}';
    }

}
