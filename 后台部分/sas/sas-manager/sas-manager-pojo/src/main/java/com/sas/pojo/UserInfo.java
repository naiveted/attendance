package com.sas.pojo;

import java.util.Date;

public class UserInfo {
    private Integer id;

    private String accountname;

    private Date registertime;

    private Date lastlogintime;

    private String image;

    private Integer level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}