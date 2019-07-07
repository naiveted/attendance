package com.sas.pojo;

public class UserLoginInfo {
    private Integer id;

    private Integer userid;

    private String loginname;

    private String loginpassword;

    private Integer logintype;

    private Integer organizationid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword == null ? null : loginpassword.trim();
    }

    public Integer getLogintype() {
        return logintype;
    }

    public void setLogintype(Integer logintype) {
        this.logintype = logintype;
    }

    public Integer getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }
}