package com.sas.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andOrganizationidIsNull() {
            addCriterion("OrganizationId is null");
            return (Criteria) this;
        }

        public Criteria andOrganizationidIsNotNull() {
            addCriterion("OrganizationId is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizationidEqualTo(Integer value) {
            addCriterion("OrganizationId =", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotEqualTo(Integer value) {
            addCriterion("OrganizationId <>", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidGreaterThan(Integer value) {
            addCriterion("OrganizationId >", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OrganizationId >=", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidLessThan(Integer value) {
            addCriterion("OrganizationId <", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidLessThanOrEqualTo(Integer value) {
            addCriterion("OrganizationId <=", value, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidIn(List<Integer> values) {
            addCriterion("OrganizationId in", values, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotIn(List<Integer> values) {
            addCriterion("OrganizationId not in", values, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidBetween(Integer value1, Integer value2) {
            addCriterion("OrganizationId between", value1, value2, "organizationid");
            return (Criteria) this;
        }

        public Criteria andOrganizationidNotBetween(Integer value1, Integer value2) {
            addCriterion("OrganizationId not between", value1, value2, "organizationid");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeIsNull() {
            addCriterion("ClassRoomSize is null");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeIsNotNull() {
            addCriterion("ClassRoomSize is not null");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeEqualTo(Integer value) {
            addCriterion("ClassRoomSize =", value, "classroomsize");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeNotEqualTo(Integer value) {
            addCriterion("ClassRoomSize <>", value, "classroomsize");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeGreaterThan(Integer value) {
            addCriterion("ClassRoomSize >", value, "classroomsize");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ClassRoomSize >=", value, "classroomsize");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeLessThan(Integer value) {
            addCriterion("ClassRoomSize <", value, "classroomsize");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeLessThanOrEqualTo(Integer value) {
            addCriterion("ClassRoomSize <=", value, "classroomsize");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeIn(List<Integer> values) {
            addCriterion("ClassRoomSize in", values, "classroomsize");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeNotIn(List<Integer> values) {
            addCriterion("ClassRoomSize not in", values, "classroomsize");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeBetween(Integer value1, Integer value2) {
            addCriterion("ClassRoomSize between", value1, value2, "classroomsize");
            return (Criteria) this;
        }

        public Criteria andClassroomsizeNotBetween(Integer value1, Integer value2) {
            addCriterion("ClassRoomSize not between", value1, value2, "classroomsize");
            return (Criteria) this;
        }

        public Criteria andClassroomnameIsNull() {
            addCriterion("ClassRoomName is null");
            return (Criteria) this;
        }

        public Criteria andClassroomnameIsNotNull() {
            addCriterion("ClassRoomName is not null");
            return (Criteria) this;
        }

        public Criteria andClassroomnameEqualTo(String value) {
            addCriterion("ClassRoomName =", value, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameNotEqualTo(String value) {
            addCriterion("ClassRoomName <>", value, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameGreaterThan(String value) {
            addCriterion("ClassRoomName >", value, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameGreaterThanOrEqualTo(String value) {
            addCriterion("ClassRoomName >=", value, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameLessThan(String value) {
            addCriterion("ClassRoomName <", value, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameLessThanOrEqualTo(String value) {
            addCriterion("ClassRoomName <=", value, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameLike(String value) {
            addCriterion("ClassRoomName like", value, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameNotLike(String value) {
            addCriterion("ClassRoomName not like", value, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameIn(List<String> values) {
            addCriterion("ClassRoomName in", values, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameNotIn(List<String> values) {
            addCriterion("ClassRoomName not in", values, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameBetween(String value1, String value2) {
            addCriterion("ClassRoomName between", value1, value2, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomnameNotBetween(String value1, String value2) {
            addCriterion("ClassRoomName not between", value1, value2, "classroomname");
            return (Criteria) this;
        }

        public Criteria andClassroomidIsNull() {
            addCriterion("ClassRoomId is null");
            return (Criteria) this;
        }

        public Criteria andClassroomidIsNotNull() {
            addCriterion("ClassRoomId is not null");
            return (Criteria) this;
        }

        public Criteria andClassroomidEqualTo(Integer value) {
            addCriterion("ClassRoomId =", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidNotEqualTo(Integer value) {
            addCriterion("ClassRoomId <>", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidGreaterThan(Integer value) {
            addCriterion("ClassRoomId >", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ClassRoomId >=", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidLessThan(Integer value) {
            addCriterion("ClassRoomId <", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidLessThanOrEqualTo(Integer value) {
            addCriterion("ClassRoomId <=", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidIn(List<Integer> values) {
            addCriterion("ClassRoomId in", values, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidNotIn(List<Integer> values) {
            addCriterion("ClassRoomId not in", values, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidBetween(Integer value1, Integer value2) {
            addCriterion("ClassRoomId between", value1, value2, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidNotBetween(Integer value1, Integer value2) {
            addCriterion("ClassRoomId not between", value1, value2, "classroomid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNull() {
            addCriterion("TeacherId is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("TeacherId is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Integer value) {
            addCriterion("TeacherId =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Integer value) {
            addCriterion("TeacherId <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Integer value) {
            addCriterion("TeacherId >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("TeacherId >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Integer value) {
            addCriterion("TeacherId <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Integer value) {
            addCriterion("TeacherId <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Integer> values) {
            addCriterion("TeacherId in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Integer> values) {
            addCriterion("TeacherId not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Integer value1, Integer value2) {
            addCriterion("TeacherId between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("TeacherId not between", value1, value2, "teacherid");
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

        public Criteria andSchooltimeIsNull() {
            addCriterion("SchoolTime is null");
            return (Criteria) this;
        }

        public Criteria andSchooltimeIsNotNull() {
            addCriterion("SchoolTime is not null");
            return (Criteria) this;
        }

        public Criteria andSchooltimeEqualTo(String value) {
            addCriterion("SchoolTime =", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeNotEqualTo(String value) {
            addCriterion("SchoolTime <>", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeGreaterThan(String value) {
            addCriterion("SchoolTime >", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeGreaterThanOrEqualTo(String value) {
            addCriterion("SchoolTime >=", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeLessThan(String value) {
            addCriterion("SchoolTime <", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeLessThanOrEqualTo(String value) {
            addCriterion("SchoolTime <=", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeLike(String value) {
            addCriterion("SchoolTime like", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeNotLike(String value) {
            addCriterion("SchoolTime not like", value, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeIn(List<String> values) {
            addCriterion("SchoolTime in", values, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeNotIn(List<String> values) {
            addCriterion("SchoolTime not in", values, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeBetween(String value1, String value2) {
            addCriterion("SchoolTime between", value1, value2, "schooltime");
            return (Criteria) this;
        }

        public Criteria andSchooltimeNotBetween(String value1, String value2) {
            addCriterion("SchoolTime not between", value1, value2, "schooltime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("StartTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("StartTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("StartTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("StartTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("StartTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StartTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("StartTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("StartTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("StartTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("StartTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StartTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("StartTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("EndTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("EndTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("EndTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("EndTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("EndTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EndTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("EndTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EndTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("EndTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("EndTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EndTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EndTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andStudentnumIsNull() {
            addCriterion("StudentNum is null");
            return (Criteria) this;
        }

        public Criteria andStudentnumIsNotNull() {
            addCriterion("StudentNum is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnumEqualTo(Integer value) {
            addCriterion("StudentNum =", value, "studentnum");
            return (Criteria) this;
        }

        public Criteria andStudentnumNotEqualTo(Integer value) {
            addCriterion("StudentNum <>", value, "studentnum");
            return (Criteria) this;
        }

        public Criteria andStudentnumGreaterThan(Integer value) {
            addCriterion("StudentNum >", value, "studentnum");
            return (Criteria) this;
        }

        public Criteria andStudentnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("StudentNum >=", value, "studentnum");
            return (Criteria) this;
        }

        public Criteria andStudentnumLessThan(Integer value) {
            addCriterion("StudentNum <", value, "studentnum");
            return (Criteria) this;
        }

        public Criteria andStudentnumLessThanOrEqualTo(Integer value) {
            addCriterion("StudentNum <=", value, "studentnum");
            return (Criteria) this;
        }

        public Criteria andStudentnumIn(List<Integer> values) {
            addCriterion("StudentNum in", values, "studentnum");
            return (Criteria) this;
        }

        public Criteria andStudentnumNotIn(List<Integer> values) {
            addCriterion("StudentNum not in", values, "studentnum");
            return (Criteria) this;
        }

        public Criteria andStudentnumBetween(Integer value1, Integer value2) {
            addCriterion("StudentNum between", value1, value2, "studentnum");
            return (Criteria) this;
        }

        public Criteria andStudentnumNotBetween(Integer value1, Integer value2) {
            addCriterion("StudentNum not between", value1, value2, "studentnum");
            return (Criteria) this;
        }

        public Criteria andTeachernameIsNull() {
            addCriterion("TeacherName is null");
            return (Criteria) this;
        }

        public Criteria andTeachernameIsNotNull() {
            addCriterion("TeacherName is not null");
            return (Criteria) this;
        }

        public Criteria andTeachernameEqualTo(String value) {
            addCriterion("TeacherName =", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotEqualTo(String value) {
            addCriterion("TeacherName <>", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameGreaterThan(String value) {
            addCriterion("TeacherName >", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameGreaterThanOrEqualTo(String value) {
            addCriterion("TeacherName >=", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameLessThan(String value) {
            addCriterion("TeacherName <", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameLessThanOrEqualTo(String value) {
            addCriterion("TeacherName <=", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameLike(String value) {
            addCriterion("TeacherName like", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotLike(String value) {
            addCriterion("TeacherName not like", value, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameIn(List<String> values) {
            addCriterion("TeacherName in", values, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotIn(List<String> values) {
            addCriterion("TeacherName not in", values, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameBetween(String value1, String value2) {
            addCriterion("TeacherName between", value1, value2, "teachername");
            return (Criteria) this;
        }

        public Criteria andTeachernameNotBetween(String value1, String value2) {
            addCriterion("TeacherName not between", value1, value2, "teachername");
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

        public Criteria andCourseadminidIsNull() {
            addCriterion("CourseAdminId is null");
            return (Criteria) this;
        }

        public Criteria andCourseadminidIsNotNull() {
            addCriterion("CourseAdminId is not null");
            return (Criteria) this;
        }

        public Criteria andCourseadminidEqualTo(Integer value) {
            addCriterion("CourseAdminId =", value, "courseadminid");
            return (Criteria) this;
        }

        public Criteria andCourseadminidNotEqualTo(Integer value) {
            addCriterion("CourseAdminId <>", value, "courseadminid");
            return (Criteria) this;
        }

        public Criteria andCourseadminidGreaterThan(Integer value) {
            addCriterion("CourseAdminId >", value, "courseadminid");
            return (Criteria) this;
        }

        public Criteria andCourseadminidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CourseAdminId >=", value, "courseadminid");
            return (Criteria) this;
        }

        public Criteria andCourseadminidLessThan(Integer value) {
            addCriterion("CourseAdminId <", value, "courseadminid");
            return (Criteria) this;
        }

        public Criteria andCourseadminidLessThanOrEqualTo(Integer value) {
            addCriterion("CourseAdminId <=", value, "courseadminid");
            return (Criteria) this;
        }

        public Criteria andCourseadminidIn(List<Integer> values) {
            addCriterion("CourseAdminId in", values, "courseadminid");
            return (Criteria) this;
        }

        public Criteria andCourseadminidNotIn(List<Integer> values) {
            addCriterion("CourseAdminId not in", values, "courseadminid");
            return (Criteria) this;
        }

        public Criteria andCourseadminidBetween(Integer value1, Integer value2) {
            addCriterion("CourseAdminId between", value1, value2, "courseadminid");
            return (Criteria) this;
        }

        public Criteria andCourseadminidNotBetween(Integer value1, Integer value2) {
            addCriterion("CourseAdminId not between", value1, value2, "courseadminid");
            return (Criteria) this;
        }

        public Criteria andStudentidlistIsNull() {
            addCriterion("StudentIdList is null");
            return (Criteria) this;
        }

        public Criteria andStudentidlistIsNotNull() {
            addCriterion("StudentIdList is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidlistEqualTo(String value) {
            addCriterion("StudentIdList =", value, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistNotEqualTo(String value) {
            addCriterion("StudentIdList <>", value, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistGreaterThan(String value) {
            addCriterion("StudentIdList >", value, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistGreaterThanOrEqualTo(String value) {
            addCriterion("StudentIdList >=", value, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistLessThan(String value) {
            addCriterion("StudentIdList <", value, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistLessThanOrEqualTo(String value) {
            addCriterion("StudentIdList <=", value, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistLike(String value) {
            addCriterion("StudentIdList like", value, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistNotLike(String value) {
            addCriterion("StudentIdList not like", value, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistIn(List<String> values) {
            addCriterion("StudentIdList in", values, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistNotIn(List<String> values) {
            addCriterion("StudentIdList not in", values, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistBetween(String value1, String value2) {
            addCriterion("StudentIdList between", value1, value2, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andStudentidlistNotBetween(String value1, String value2) {
            addCriterion("StudentIdList not between", value1, value2, "studentidlist");
            return (Criteria) this;
        }

        public Criteria andDayofweekIsNull() {
            addCriterion("DayOfWeek is null");
            return (Criteria) this;
        }

        public Criteria andDayofweekIsNotNull() {
            addCriterion("DayOfWeek is not null");
            return (Criteria) this;
        }

        public Criteria andDayofweekEqualTo(String value) {
            addCriterion("DayOfWeek =", value, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekNotEqualTo(String value) {
            addCriterion("DayOfWeek <>", value, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekGreaterThan(String value) {
            addCriterion("DayOfWeek >", value, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekGreaterThanOrEqualTo(String value) {
            addCriterion("DayOfWeek >=", value, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekLessThan(String value) {
            addCriterion("DayOfWeek <", value, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekLessThanOrEqualTo(String value) {
            addCriterion("DayOfWeek <=", value, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekLike(String value) {
            addCriterion("DayOfWeek like", value, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekNotLike(String value) {
            addCriterion("DayOfWeek not like", value, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekIn(List<String> values) {
            addCriterion("DayOfWeek in", values, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekNotIn(List<String> values) {
            addCriterion("DayOfWeek not in", values, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekBetween(String value1, String value2) {
            addCriterion("DayOfWeek between", value1, value2, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andDayofweekNotBetween(String value1, String value2) {
            addCriterion("DayOfWeek not between", value1, value2, "dayofweek");
            return (Criteria) this;
        }

        public Criteria andIsattendanceIsNull() {
            addCriterion("IsAttendance is null");
            return (Criteria) this;
        }

        public Criteria andIsattendanceIsNotNull() {
            addCriterion("IsAttendance is not null");
            return (Criteria) this;
        }

        public Criteria andIsattendanceEqualTo(Integer value) {
            addCriterion("IsAttendance =", value, "isattendance");
            return (Criteria) this;
        }

        public Criteria andIsattendanceNotEqualTo(Integer value) {
            addCriterion("IsAttendance <>", value, "isattendance");
            return (Criteria) this;
        }

        public Criteria andIsattendanceGreaterThan(Integer value) {
            addCriterion("IsAttendance >", value, "isattendance");
            return (Criteria) this;
        }

        public Criteria andIsattendanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsAttendance >=", value, "isattendance");
            return (Criteria) this;
        }

        public Criteria andIsattendanceLessThan(Integer value) {
            addCriterion("IsAttendance <", value, "isattendance");
            return (Criteria) this;
        }

        public Criteria andIsattendanceLessThanOrEqualTo(Integer value) {
            addCriterion("IsAttendance <=", value, "isattendance");
            return (Criteria) this;
        }

        public Criteria andIsattendanceIn(List<Integer> values) {
            addCriterion("IsAttendance in", values, "isattendance");
            return (Criteria) this;
        }

        public Criteria andIsattendanceNotIn(List<Integer> values) {
            addCriterion("IsAttendance not in", values, "isattendance");
            return (Criteria) this;
        }

        public Criteria andIsattendanceBetween(Integer value1, Integer value2) {
            addCriterion("IsAttendance between", value1, value2, "isattendance");
            return (Criteria) this;
        }

        public Criteria andIsattendanceNotBetween(Integer value1, Integer value2) {
            addCriterion("IsAttendance not between", value1, value2, "isattendance");
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