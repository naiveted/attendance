package com.sas.pojo;

import java.util.Date;

public class DictionaryDetail {
    private Integer id;

    private Integer dictionaryid;

    private Integer itemkey;

    private Boolean isdefault;

    private Integer position;

    private String itemvalue;

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

    public Integer getDictionaryid() {
        return dictionaryid;
    }

    public void setDictionaryid(Integer dictionaryid) {
        this.dictionaryid = dictionaryid;
    }

    public Integer getItemkey() {
        return itemkey;
    }

    public void setItemkey(Integer itemkey) {
        this.itemkey = itemkey;
    }

    public Boolean getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(String itemvalue) {
        this.itemvalue = itemvalue == null ? null : itemvalue.trim();
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