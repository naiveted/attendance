package com.sas.pojo;

import java.util.Date;

public class Permission {
    private Integer id;

    private String name;

    private String url;

    private String httptype;

    private Boolean ismenu;

    private Boolean ispage;

    private String description;

    private Integer level;

    private Integer position;

    private String path;

    private Integer parentid;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getHttptype() {
        return httptype;
    }

    public void setHttptype(String httptype) {
        this.httptype = httptype == null ? null : httptype.trim();
    }

    public Boolean getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Boolean ismenu) {
        this.ismenu = ismenu;
    }

    public Boolean getIspage() {
        return ispage;
    }

    public void setIspage(Boolean ispage) {
        this.ispage = ispage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
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