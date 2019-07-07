package com.sas.pojo;

import java.util.Date;

public class Dictionarys {
    private Integer id;

    private String code;

    private String description;

    private String createby;

    private Date createdate;

    private Date modifydate;

    private String modifyby;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public String getModifyby() {
        return modifyby;
    }

    public void setModifyby(String modifyby) {
        this.modifyby = modifyby == null ? null : modifyby.trim();
    }
}