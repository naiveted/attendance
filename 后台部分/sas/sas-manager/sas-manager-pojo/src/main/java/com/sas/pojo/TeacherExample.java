package com.sas.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTeachersexIsNull() {
            addCriterion("TeacherSex is null");
            return (Criteria) this;
        }

        public Criteria andTeachersexIsNotNull() {
            addCriterion("TeacherSex is not null");
            return (Criteria) this;
        }

        public Criteria andTeachersexEqualTo(Integer value) {
            addCriterion("TeacherSex =", value, "teachersex");
            return (Criteria) this;
        }

        public Criteria andTeachersexNotEqualTo(Integer value) {
            addCriterion("TeacherSex <>", value, "teachersex");
            return (Criteria) this;
        }

        public Criteria andTeachersexGreaterThan(Integer value) {
            addCriterion("TeacherSex >", value, "teachersex");
            return (Criteria) this;
        }

        public Criteria andTeachersexGreaterThanOrEqualTo(Integer value) {
            addCriterion("TeacherSex >=", value, "teachersex");
            return (Criteria) this;
        }

        public Criteria andTeachersexLessThan(Integer value) {
            addCriterion("TeacherSex <", value, "teachersex");
            return (Criteria) this;
        }

        public Criteria andTeachersexLessThanOrEqualTo(Integer value) {
            addCriterion("TeacherSex <=", value, "teachersex");
            return (Criteria) this;
        }

        public Criteria andTeachersexIn(List<Integer> values) {
            addCriterion("TeacherSex in", values, "teachersex");
            return (Criteria) this;
        }

        public Criteria andTeachersexNotIn(List<Integer> values) {
            addCriterion("TeacherSex not in", values, "teachersex");
            return (Criteria) this;
        }

        public Criteria andTeachersexBetween(Integer value1, Integer value2) {
            addCriterion("TeacherSex between", value1, value2, "teachersex");
            return (Criteria) this;
        }

        public Criteria andTeachersexNotBetween(Integer value1, Integer value2) {
            addCriterion("TeacherSex not between", value1, value2, "teachersex");
            return (Criteria) this;
        }

        public Criteria andTeacherageIsNull() {
            addCriterion("TeacherAge is null");
            return (Criteria) this;
        }

        public Criteria andTeacherageIsNotNull() {
            addCriterion("TeacherAge is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherageEqualTo(Integer value) {
            addCriterion("TeacherAge =", value, "teacherage");
            return (Criteria) this;
        }

        public Criteria andTeacherageNotEqualTo(Integer value) {
            addCriterion("TeacherAge <>", value, "teacherage");
            return (Criteria) this;
        }

        public Criteria andTeacherageGreaterThan(Integer value) {
            addCriterion("TeacherAge >", value, "teacherage");
            return (Criteria) this;
        }

        public Criteria andTeacherageGreaterThanOrEqualTo(Integer value) {
            addCriterion("TeacherAge >=", value, "teacherage");
            return (Criteria) this;
        }

        public Criteria andTeacherageLessThan(Integer value) {
            addCriterion("TeacherAge <", value, "teacherage");
            return (Criteria) this;
        }

        public Criteria andTeacherageLessThanOrEqualTo(Integer value) {
            addCriterion("TeacherAge <=", value, "teacherage");
            return (Criteria) this;
        }

        public Criteria andTeacherageIn(List<Integer> values) {
            addCriterion("TeacherAge in", values, "teacherage");
            return (Criteria) this;
        }

        public Criteria andTeacherageNotIn(List<Integer> values) {
            addCriterion("TeacherAge not in", values, "teacherage");
            return (Criteria) this;
        }

        public Criteria andTeacherageBetween(Integer value1, Integer value2) {
            addCriterion("TeacherAge between", value1, value2, "teacherage");
            return (Criteria) this;
        }

        public Criteria andTeacherageNotBetween(Integer value1, Integer value2) {
            addCriterion("TeacherAge not between", value1, value2, "teacherage");
            return (Criteria) this;
        }

        public Criteria andJobnumIsNull() {
            addCriterion("JobNum is null");
            return (Criteria) this;
        }

        public Criteria andJobnumIsNotNull() {
            addCriterion("JobNum is not null");
            return (Criteria) this;
        }

        public Criteria andJobnumEqualTo(Integer value) {
            addCriterion("JobNum =", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumNotEqualTo(Integer value) {
            addCriterion("JobNum <>", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumGreaterThan(Integer value) {
            addCriterion("JobNum >", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("JobNum >=", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumLessThan(Integer value) {
            addCriterion("JobNum <", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumLessThanOrEqualTo(Integer value) {
            addCriterion("JobNum <=", value, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumIn(List<Integer> values) {
            addCriterion("JobNum in", values, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumNotIn(List<Integer> values) {
            addCriterion("JobNum not in", values, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumBetween(Integer value1, Integer value2) {
            addCriterion("JobNum between", value1, value2, "jobnum");
            return (Criteria) this;
        }

        public Criteria andJobnumNotBetween(Integer value1, Integer value2) {
            addCriterion("JobNum not between", value1, value2, "jobnum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumIsNull() {
            addCriterion("PeopleNum is null");
            return (Criteria) this;
        }

        public Criteria andPeoplenumIsNotNull() {
            addCriterion("PeopleNum is not null");
            return (Criteria) this;
        }

        public Criteria andPeoplenumEqualTo(String value) {
            addCriterion("PeopleNum =", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumNotEqualTo(String value) {
            addCriterion("PeopleNum <>", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumGreaterThan(String value) {
            addCriterion("PeopleNum >", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumGreaterThanOrEqualTo(String value) {
            addCriterion("PeopleNum >=", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumLessThan(String value) {
            addCriterion("PeopleNum <", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumLessThanOrEqualTo(String value) {
            addCriterion("PeopleNum <=", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumLike(String value) {
            addCriterion("PeopleNum like", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumNotLike(String value) {
            addCriterion("PeopleNum not like", value, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumIn(List<String> values) {
            addCriterion("PeopleNum in", values, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumNotIn(List<String> values) {
            addCriterion("PeopleNum not in", values, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumBetween(String value1, String value2) {
            addCriterion("PeopleNum between", value1, value2, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andPeoplenumNotBetween(String value1, String value2) {
            addCriterion("PeopleNum not between", value1, value2, "peoplenum");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIsNull() {
            addCriterion("EntryTime is null");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIsNotNull() {
            addCriterion("EntryTime is not null");
            return (Criteria) this;
        }

        public Criteria andEntrytimeEqualTo(Date value) {
            addCriterionForJDBCDate("EntryTime =", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("EntryTime <>", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("EntryTime >", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EntryTime >=", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeLessThan(Date value) {
            addCriterionForJDBCDate("EntryTime <", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("EntryTime <=", value, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeIn(List<Date> values) {
            addCriterionForJDBCDate("EntryTime in", values, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("EntryTime not in", values, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EntryTime between", value1, value2, "entrytime");
            return (Criteria) this;
        }

        public Criteria andEntrytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("EntryTime not between", value1, value2, "entrytime");
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
            addCriterion("CreateDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("CreateDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("CreateDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("CreateDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("CreateDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("CreateDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("CreateDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("CreateDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("CreateDate not between", value1, value2, "createdate");
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

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("Image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("Image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("Image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("Image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("Image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("Image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("Image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("Image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("Image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("Image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("Image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("Image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("Image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("Image not between", value1, value2, "image");
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