package com.sas.pojo;

import java.util.Date;

public class Absenteeism {
    private Integer aid;

    private String coursename;

    private Integer courseid;

    private Integer atteancenum;

    private Integer leavenum;

    private Integer absenteeismnum;

    private String absenteeismlist;

    private Date createtime;

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

    public Integer getAtteancenum() {
        return atteancenum;
    }

    public void setAtteancenum(Integer atteancenum) {
        this.atteancenum = atteancenum;
    }

    public Integer getLeavenum() {
        return leavenum;
    }

    public void setLeavenum(Integer leavenum) {
        this.leavenum = leavenum;
    }

    public Integer getAbsenteeismnum() {
        return absenteeismnum;
    }

    public void setAbsenteeismnum(Integer absenteeismnum) {
        this.absenteeismnum = absenteeismnum;
    }

    public String getAbsenteeismlist() {
        return absenteeismlist;
    }

    public void setAbsenteeismlist(String absenteeismlist) {
        this.absenteeismlist = absenteeismlist == null ? null : absenteeismlist.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}