package com.sas.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttendanceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAidIsNull() {
            addCriterion("Aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("Aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("Aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("Aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("Aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("Aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("Aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("Aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("Aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("Aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("Aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andCoursenameIsNull() {
            addCriterion("CourseName is null");
            return (Criteria) this;
        }

        public Criteria andCoursenameIsNotNull() {
            addCriterion("CourseName is not null");
            return (Criteria) this;
        }

        public Criteria andCoursenameEqualTo(String value) {
            addCriterion("CourseName =", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotEqualTo(String value) {
            addCriterion("CourseName <>", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameGreaterThan(String value) {
            addCriterion("CourseName >", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameGreaterThanOrEqualTo(String value) {
            addCriterion("CourseName >=", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLessThan(String value) {
            addCriterion("CourseName <", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLessThanOrEqualTo(String value) {
            addCriterion("CourseName <=", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLike(String value) {
            addCriterion("CourseName like", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotLike(String value) {
            addCriterion("CourseName not like", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameIn(List<String> values) {
            addCriterion("CourseName in", values, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotIn(List<String> values) {
            addCriterion("CourseName not in", values, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameBetween(String value1, String value2) {
            addCriterion("CourseName between", value1, value2, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotBetween(String value1, String value2) {
            addCriterion("CourseName not between", value1, value2, "coursename");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNull() {
            addCriterion("CourseId is null");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNotNull() {
            addCriterion("CourseId is not null");
            return (Criteria) this;
        }

        public Criteria andCourseidEqualTo(Integer value) {
            addCriterion("CourseId =", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotEqualTo(Integer value) {
            addCriterion("CourseId <>", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThan(Integer value) {
            addCriterion("CourseId >", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CourseId >=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThan(Integer value) {
            addCriterion("CourseId <", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThanOrEqualTo(Integer value) {
            addCriterion("CourseId <=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidIn(List<Integer> values) {
            addCriterion("CourseId in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotIn(List<Integer> values) {
            addCriterion("CourseId not in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidBetween(Integer value1, Integer value2) {
            addCriterion("CourseId between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotBetween(Integer value1, Integer value2) {
            addCriterion("CourseId not between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNull() {
            addCriterion("StudentName is null");
            return (Criteria) this;
        }

        public Criteria andStudentnameIsNotNull() {
            addCriterion("StudentName is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnameEqualTo(String value) {
            addCriterion("StudentName =", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotEqualTo(String value) {
            addCriterion("StudentName <>", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThan(String value) {
            addCriterion("StudentName >", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameGreaterThanOrEqualTo(String value) {
            addCriterion("StudentName >=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThan(String value) {
            addCriterion("StudentName <", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLessThanOrEqualTo(String value) {
            addCriterion("StudentName <=", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameLike(String value) {
            addCriterion("StudentName like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotLike(String value) {
            addCriterion("StudentName not like", value, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameIn(List<String> values) {
            addCriterion("StudentName in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotIn(List<String> values) {
            addCriterion("StudentName not in", values, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameBetween(String value1, String value2) {
            addCriterion("StudentName between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentnameNotBetween(String value1, String value2) {
            addCriterion("StudentName not between", value1, value2, "studentname");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNull() {
            addCriterion("StudentId is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("StudentId is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Integer value) {
            addCriterion("StudentId =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Integer value) {
            addCriterion("StudentId <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Integer value) {
            addCriterion("StudentId >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("StudentId >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Integer value) {
            addCriterion("StudentId <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("StudentId <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Integer> values) {
            addCriterion("StudentId in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Integer> values) {
            addCriterion("StudentId not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Integer value1, Integer value2) {
            addCriterion("StudentId between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("StudentId not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("State is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("State is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("State =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("State <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("State >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("State >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("State <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("State <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("State in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("State not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("State between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("State not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeIsNull() {
            addCriterion("SignDeskTime is null");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeIsNotNull() {
            addCriterion("SignDeskTime is not null");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeEqualTo(Date value) {
            addCriterion("SignDeskTime =", value, "signdesktime");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeNotEqualTo(Date value) {
            addCriterion("SignDeskTime <>", value, "signdesktime");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeGreaterThan(Date value) {
            addCriterion("SignDeskTime >", value, "signdesktime");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SignDeskTime >=", value, "signdesktime");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeLessThan(Date value) {
            addCriterion("SignDeskTime <", value, "signdesktime");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeLessThanOrEqualTo(Date value) {
            addCriterion("SignDeskTime <=", value, "signdesktime");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeIn(List<Date> values) {
            addCriterion("SignDeskTime in", values, "signdesktime");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeNotIn(List<Date> values) {
            addCriterion("SignDeskTime not in", values, "signdesktime");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeBetween(Date value1, Date value2) {
            addCriterion("SignDeskTime between", value1, value2, "signdesktime");
            return (Criteria) this;
        }

        public Criteria andSigndesktimeNotBetween(Date value1, Date value2) {
            addCriterion("SignDeskTime not between", value1, value2, "signdesktime");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressIsNull() {
            addCriterion("SignDeskAddress is null");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressIsNotNull() {
            addCriterion("SignDeskAddress is not null");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressEqualTo(String value) {
            addCriterion("SignDeskAddress =", value, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressNotEqualTo(String value) {
            addCriterion("SignDeskAddress <>", value, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressGreaterThan(String value) {
            addCriterion("SignDeskAddress >", value, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressGreaterThanOrEqualTo(String value) {
            addCriterion("SignDeskAddress >=", value, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressLessThan(String value) {
            addCriterion("SignDeskAddress <", value, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressLessThanOrEqualTo(String value) {
            addCriterion("SignDeskAddress <=", value, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressLike(String value) {
            addCriterion("SignDeskAddress like", value, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressNotLike(String value) {
            addCriterion("SignDeskAddress not like", value, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressIn(List<String> values) {
            addCriterion("SignDeskAddress in", values, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressNotIn(List<String> values) {
            addCriterion("SignDeskAddress not in", values, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressBetween(String value1, String value2) {
            addCriterion("SignDeskAddress between", value1, value2, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSigndeskaddressNotBetween(String value1, String value2) {
            addCriterion("SignDeskAddress not between", value1, value2, "signdeskaddress");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIsNull() {
            addCriterion("SeatNumber is null");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIsNotNull() {
            addCriterion("SeatNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSeatnumberEqualTo(Integer value) {
            addCriterion("SeatNumber =", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotEqualTo(Integer value) {
            addCriterion("SeatNumber <>", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberGreaterThan(Integer value) {
            addCriterion("SeatNumber >", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("SeatNumber >=", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberLessThan(Integer value) {
            addCriterion("SeatNumber <", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberLessThanOrEqualTo(Integer value) {
            addCriterion("SeatNumber <=", value, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberIn(List<Integer> values) {
            addCriterion("SeatNumber in", values, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotIn(List<Integer> values) {
            addCriterion("SeatNumber not in", values, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberBetween(Integer value1, Integer value2) {
            addCriterion("SeatNumber between", value1, value2, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andSeatnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("SeatNumber not between", value1, value2, "seatnumber");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNull() {
            addCriterion("CreateBy is null");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNotNull() {
            addCriterion("CreateBy is not null");
            return (Criteria) this;
        }

        public Criteria andCreatebyEqualTo(String value) {
            addCriterion("CreateBy =", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotEqualTo(String value) {
            addCriterion("CreateBy <>", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThan(String value) {
            addCriterion("CreateBy >", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThanOrEqualTo(String value) {
            addCriterion("CreateBy >=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThan(String value) {
            addCriterion("CreateBy <", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThanOrEqualTo(String value) {
            addCriterion("CreateBy <=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLike(String value) {
            addCriterion("CreateBy like", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotLike(String value) {
            addCriterion("CreateBy not like", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyIn(List<String> values) {
            addCriterion("CreateBy in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotIn(List<String> values) {
            addCriterion("CreateBy not in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyBetween(String value1, String value2) {
            addCriterion("CreateBy between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotBetween(String value1, String value2) {
            addCriterion("CreateBy not between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterionForJDBCDate("CreateDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterionForJDBCDate("CreateDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterionForJDBCDate("CreateDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CreateDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNull() {
            addCriterion("ModifyDate is null");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNotNull() {
            addCriterion("ModifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andModifydateEqualTo(Date value) {
            addCriterion("ModifyDate =", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotEqualTo(Date value) {
            addCriterion("ModifyDate <>", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThan(Date value) {
            addCriterion("ModifyDate >", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThanOrEqualTo(Date value) {
            addCriterion("ModifyDate >=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThan(Date value) {
            addCriterion("ModifyDate <", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThanOrEqualTo(Date value) {
            addCriterion("ModifyDate <=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateIn(List<Date> values) {
            addCriterion("ModifyDate in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotIn(List<Date> values) {
            addCriterion("ModifyDate not in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateBetween(Date value1, Date value2) {
            addCriterion("ModifyDate between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotBetween(Date value1, Date value2) {
            addCriterion("ModifyDate not between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifybyIsNull() {
            addCriterion("ModifyBy is null");
            return (Criteria) this;
        }

        public Criteria andModifybyIsNotNull() {
            addCriterion("ModifyBy is not null");
            return (Criteria) this;
        }

        public Criteria andModifybyEqualTo(String value) {
            addCriterion("ModifyBy =", value, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyNotEqualTo(String value) {
            addCriterion("ModifyBy <>", value, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyGreaterThan(String value) {
            addCriterion("ModifyBy >", value, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyGreaterThanOrEqualTo(String value) {
            addCriterion("ModifyBy >=", value, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyLessThan(String value) {
            addCriterion("ModifyBy <", value, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyLessThanOrEqualTo(String value) {
            addCriterion("ModifyBy <=", value, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyLike(String value) {
            addCriterion("ModifyBy like", value, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyNotLike(String value) {
            addCriterion("ModifyBy not like", value, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyIn(List<String> values) {
            addCriterion("ModifyBy in", values, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyNotIn(List<String> values) {
            addCriterion("ModifyBy not in", values, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyBetween(String value1, String value2) {
            addCriterion("ModifyBy between", value1, value2, "modifyby");
            return (Criteria) this;
        }

        public Criteria andModifybyNotBetween(String value1, String value2) {
            addCriterion("ModifyBy not between", value1, value2, "modifyby");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}