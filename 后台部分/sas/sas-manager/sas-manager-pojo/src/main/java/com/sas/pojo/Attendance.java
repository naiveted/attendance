package com.sas.pojo;

import java.util.Date;

public class Attendance {
    private Integer aid;

    private String coursename;

    private Integer courseid;

    private String studentname;

    private Integer studentid;

    private Integer state;

    private Date signdesktime;

    private String signdeskaddress;

    private Integer seatnumber;

    private String createby;

    private Date createdate;

    private Date modifydate;

    private String modifyby;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getSigndesktime() {
        return signdesktime;
    }

    public void setSigndesktime(Date signdesktime) {
        this.signdesktime = signdesktime;
    }

    public String getSigndeskaddress() {
        return signdeskaddress;
    }

    public void setSigndeskaddress(String signdeskaddress) {
        this.signdeskaddress = signdeskaddress == null ? null : signdeskaddress.trim();
    }

    public Integer getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(Integer seatnumber) {
        this.seatnumber = seatnumber;
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