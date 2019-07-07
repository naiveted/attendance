package com.sas.pojo;

import java.util.Date;

public class Course {
    private Integer courseid;

    private Integer organizationid;

    private Integer classroomsize;

    private String classroomname;

    private Integer classroomid;

    private Integer teacherid;

    private String coursename;

    private String schooltime;

    private Date starttime;

    private Date endtime;

    private Integer studentnum;

    private String teachername;

    private String createby;

    private Date createdate;

    private Date modifydate;

    private String modifyby;

    private Integer courseadminid;

    private String studentidlist;

    private String dayofweek;

    private Integer isattendance;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    public Integer getClassroomsize() {
        return classroomsize;
    }

    public void setClassroomsize(Integer classroomsize) {
        this.classroomsize = classroomsize;
    }

    public String getClassroomname() {
        return classroomname;
    }

    public void setClassroomname(String classroomname) {
        this.classroomname = classroomname == null ? null : classroomname.trim();
    }

    public Integer getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(Integer classroomid) {
        this.classroomid = classroomid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getSchooltime() {
        return schooltime;
    }

    public void setSchooltime(String schooltime) {
        this.schooltime = schooltime == null ? null : schooltime.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getStudentnum() {
        return studentnum;
    }

    public void setStudentnum(Integer studentnum) {
        this.studentnum = studentnum;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
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

    public Integer getCourseadminid() {
        return courseadminid;
    }

    public void setCourseadminid(Integer courseadminid) {
        this.courseadminid = courseadminid;
    }

    public String getStudentidlist() {
        return studentidlist;
    }

    public void setStudentidlist(String studentidlist) {
        this.studentidlist = studentidlist == null ? null : studentidlist.trim();
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek == null ? null : dayofweek.trim();
    }

    public Integer getIsattendance() {
        return isattendance;
    }

    public void setIsattendance(Integer isattendance) {
        this.isattendance = isattendance;
    }
}