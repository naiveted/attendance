package com.sas.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ClassRoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassRoomExample() {
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

        public Criteria andClassroomaddressIsNull() {
            addCriterion("ClassRoomAddress is null");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressIsNotNull() {
            addCriterion("ClassRoomAddress is not null");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressEqualTo(String value) {
            addCriterion("ClassRoomAddress =", value, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressNotEqualTo(String value) {
            addCriterion("ClassRoomAddress <>", value, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressGreaterThan(String value) {
            addCriterion("ClassRoomAddress >", value, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressGreaterThanOrEqualTo(String value) {
            addCriterion("ClassRoomAddress >=", value, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressLessThan(String value) {
            addCriterion("ClassRoomAddress <", value, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressLessThanOrEqualTo(String value) {
            addCriterion("ClassRoomAddress <=", value, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressLike(String value) {
            addCriterion("ClassRoomAddress like", value, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressNotLike(String value) {
            addCriterion("ClassRoomAddress not like", value, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressIn(List<String> values) {
            addCriterion("ClassRoomAddress in", values, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressNotIn(List<String> values) {
            addCriterion("ClassRoomAddress not in", values, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressBetween(String value1, String value2) {
            addCriterion("ClassRoomAddress between", value1, value2, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andClassroomaddressNotBetween(String value1, String value2) {
            addCriterion("ClassRoomAddress not between", value1, value2, "classroomaddress");
            return (Criteria) this;
        }

        public Criteria andGalleryfulIsNull() {
            addCriterion("Galleryful is null");
            return (Criteria) this;
        }

        public Criteria andGalleryfulIsNotNull() {
            addCriterion("Galleryful is not null");
            return (Criteria) this;
        }

        public Criteria andGalleryfulEqualTo(Integer value) {
            addCriterion("Galleryful =", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulNotEqualTo(Integer value) {
            addCriterion("Galleryful <>", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulGreaterThan(Integer value) {
            addCriterion("Galleryful >", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulGreaterThanOrEqualTo(Integer value) {
            addCriterion("Galleryful >=", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulLessThan(Integer value) {
            addCriterion("Galleryful <", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulLessThanOrEqualTo(Integer value) {
            addCriterion("Galleryful <=", value, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulIn(List<Integer> values) {
            addCriterion("Galleryful in", values, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulNotIn(List<Integer> values) {
            addCriterion("Galleryful not in", values, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulBetween(Integer value1, Integer value2) {
            addCriterion("Galleryful between", value1, value2, "galleryful");
            return (Criteria) this;
        }

        public Criteria andGalleryfulNotBetween(Integer value1, Integer value2) {
            addCriterion("Galleryful not between", value1, value2, "galleryful");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNull() {
            addCriterion("IsUse is null");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNotNull() {
            addCriterion("IsUse is not null");
            return (Criteria) this;
        }

        public Criteria andIsuseEqualTo(Integer value) {
            addCriterion("IsUse =", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotEqualTo(Integer value) {
            addCriterion("IsUse <>", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThan(Integer value) {
            addCriterion("IsUse >", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsUse >=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThan(Integer value) {
            addCriterion("IsUse <", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThanOrEqualTo(Integer value) {
            addCriterion("IsUse <=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseIn(List<Integer> values) {
            addCriterion("IsUse in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotIn(List<Integer> values) {
            addCriterion("IsUse not in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseBetween(Integer value1, Integer value2) {
            addCriterion("IsUse between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotBetween(Integer value1, Integer value2) {
            addCriterion("IsUse not between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeIsNull() {
            addCriterion("UseStratTime is null");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeIsNotNull() {
            addCriterion("UseStratTime is not null");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeEqualTo(Date value) {
            addCriterionForJDBCDate("UseStratTime =", value, "usestrattime");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UseStratTime <>", value, "usestrattime");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UseStratTime >", value, "usestrattime");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UseStratTime >=", value, "usestrattime");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeLessThan(Date value) {
            addCriterionForJDBCDate("UseStratTime <", value, "usestrattime");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UseStratTime <=", value, "usestrattime");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeIn(List<Date> values) {
            addCriterionForJDBCDate("UseStratTime in", values, "usestrattime");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UseStratTime not in", values, "usestrattime");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UseStratTime between", value1, value2, "usestrattime");
            return (Criteria) this;
        }

        public Criteria andUsestrattimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UseStratTime not between", value1, value2, "usestrattime");
            return (Criteria) this;
        }

        public Criteria andUseendtimeIsNull() {
            addCriterion("UseEndTime is null");
            return (Criteria) this;
        }

        public Criteria andUseendtimeIsNotNull() {
            addCriterion("UseEndTime is not null");
            return (Criteria) this;
        }

        public Criteria andUseendtimeEqualTo(Date value) {
            addCriterionForJDBCDate("UseEndTime =", value, "useendtime");
            return (Criteria) this;
        }

        public Criteria andUseendtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UseEndTime <>", value, "useendtime");
            return (Criteria) this;
        }

        public Criteria andUseendtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UseEndTime >", value, "useendtime");
            return (Criteria) this;
        }

        public Criteria andUseendtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UseEndTime >=", value, "useendtime");
            return (Criteria) this;
        }

        public Criteria andUseendtimeLessThan(Date value) {
            addCriterionForJDBCDate("UseEndTime <", value, "useendtime");
            return (Criteria) this;
        }

        public Criteria andUseendtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UseEndTime <=", value, "useendtime");
            return (Criteria) this;
        }

        public Criteria andUseendtimeIn(List<Date> values) {
            addCriterionForJDBCDate("UseEndTime in", values, "useendtime");
            return (Criteria) this;
        }

        public Criteria andUseendtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UseEndTime not in", values, "useendtime");
            return (Criteria) this;
        }

        public Criteria andUseendtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UseEndTime between", value1, value2, "useendtime");
            return (Criteria) this;
        }

        public Criteria andUseendtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UseEndTime not between", value1, value2, "useendtime");
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

        public Criteria andLongitudeIsNull() {
            addCriterion("Longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("Longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("Longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("Longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("Longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("Longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("Longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("Longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("Longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("Longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("Longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("Longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("Longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("Longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("Latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("Latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("Latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("Latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("Latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("Latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("Latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("Latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("Latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("Latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("Latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("Latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("Latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("Latitude not between", value1, value2, "latitude");
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