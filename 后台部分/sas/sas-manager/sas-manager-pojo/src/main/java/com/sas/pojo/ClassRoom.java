package com.sas.pojo;

import java.util.Date;

public class ClassRoom {
    private Integer classroomid;

    private Integer organizationid;

    private String classroomname;

    private String classroomaddress;

    private Integer galleryful;

    private Integer isuse;

    private Date usestrattime;

    private Date useendtime;

    private String createby;

    private Date createdate;

    private Date modifydate;

    private String modifyby;

    private String longitude;

    private String latitude;

    public Integer getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Integer classroomid) {
        this.classroomid = classroomid;
    }

    public Integer getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    public String getClassroomname() {
        return classroomname;
    }

    public void setClassroomname(String classroomname) {
        this.classroomname = classroomname == null ? null : classroomname.trim();
    }

    public String getClassroomaddress() {
        return classroomaddress;
    }

    public void setClassroomaddress(String classroomaddress) {
        this.classroomaddress = classroomaddress == null ? null : classroomaddress.trim();
    }

    public Integer getGalleryful() {
        return galleryful;
    }

    public void setGalleryful(Integer galleryful) {
        this.galleryful = galleryful;
    }

    public Integer getIsuse() {
        return isuse;
    }

    public void setIsuse(Integer isuse) {
        this.isuse = isuse;
    }

    public Date getUsestrattime() {
        return usestrattime;
    }

    public void setUsestrattime(Date usestrattime) {
        this.usestrattime = usestrattime;
    }

    public Date getUseendtime() {
        return useendtime;
    }

    public void setUseendtime(Date useendtime) {
        this.useendtime = useendtime;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }
}