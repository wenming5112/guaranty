package com.example.guaranty.entity;

import java.io.Serializable;

/**
 * @author jesus
 * @version 1.0.0
 * @date 2020/12/3 9:59
 **/
public class BaseEntity implements Serializable {
    private Integer id;
    private Boolean valid;

    BaseEntity() {

    }

    BaseEntity(Integer id, Boolean valid) {
        this.id = id;
        this.valid = valid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
