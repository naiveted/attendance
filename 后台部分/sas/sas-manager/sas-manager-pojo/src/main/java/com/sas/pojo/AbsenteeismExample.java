package com.sas.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AbsenteeismExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AbsenteeismExample() {
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
            addCriterion("AId is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("AId is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("AId =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("AId <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("AId >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("AId >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("AId <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("AId <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("AId in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("AId not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("AId between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("AId not between", value1, value2, "aid");
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

        public Criteria andAtteancenumIsNull() {
            addCriterion("AtteanceNum is null");
            return (Criteria) this;
        }

        public Criteria andAtteancenumIsNotNull() {
            addCriterion("AtteanceNum is not null");
            return (Criteria) this;
        }

        public Criteria andAtteancenumEqualTo(Integer value) {
            addCriterion("AtteanceNum =", value, "atteancenum");
            return (Criteria) this;
        }

        public Criteria andAtteancenumNotEqualTo(Integer value) {
            addCriterion("AtteanceNum <>", value, "atteancenum");
            return (Criteria) this;
        }

        public Criteria andAtteancenumGreaterThan(Integer value) {
            addCriterion("AtteanceNum >", value, "atteancenum");
            return (Criteria) this;
        }

        public Criteria andAtteancenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("AtteanceNum >=", value, "atteancenum");
            return (Criteria) this;
        }

        public Criteria andAtteancenumLessThan(Integer value) {
            addCriterion("AtteanceNum <", value, "atteancenum");
            return (Criteria) this;
        }

        public Criteria andAtteancenumLessThanOrEqualTo(Integer value) {
            addCriterion("AtteanceNum <=", value, "atteancenum");
            return (Criteria) this;
        }

        public Criteria andAtteancenumIn(List<Integer> values) {
            addCriterion("AtteanceNum in", values, "atteancenum");
            return (Criteria) this;
        }

        public Criteria andAtteancenumNotIn(List<Integer> values) {
            addCriterion("AtteanceNum not in", values, "atteancenum");
            return (Criteria) this;
        }

        public Criteria andAtteancenumBetween(Integer value1, Integer value2) {
            addCriterion("AtteanceNum between", value1, value2, "atteancenum");
            return (Criteria) this;
        }

        public Criteria andAtteancenumNotBetween(Integer value1, Integer value2) {
            addCriterion("AtteanceNum not between", value1, value2, "atteancenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumIsNull() {
            addCriterion("LeaveNum is null");
            return (Criteria) this;
        }

        public Criteria andLeavenumIsNotNull() {
            addCriterion("LeaveNum is not null");
            return (Criteria) this;
        }

        public Criteria andLeavenumEqualTo(Integer value) {
            addCriterion("LeaveNum =", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumNotEqualTo(Integer value) {
            addCriterion("LeaveNum <>", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumGreaterThan(Integer value) {
            addCriterion("LeaveNum >", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("LeaveNum >=", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumLessThan(Integer value) {
            addCriterion("LeaveNum <", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumLessThanOrEqualTo(Integer value) {
            addCriterion("LeaveNum <=", value, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumIn(List<Integer> values) {
            addCriterion("LeaveNum in", values, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumNotIn(List<Integer> values) {
            addCriterion("LeaveNum not in", values, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumBetween(Integer value1, Integer value2) {
            addCriterion("LeaveNum between", value1, value2, "leavenum");
            return (Criteria) this;
        }

        public Criteria andLeavenumNotBetween(Integer value1, Integer value2) {
            addCriterion("LeaveNum not between", value1, value2, "leavenum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumIsNull() {
            addCriterion("AbsenteeismNum is null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumIsNotNull() {
            addCriterion("AbsenteeismNum is not null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumEqualTo(Integer value) {
            addCriterion("AbsenteeismNum =", value, "absenteeismnum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumNotEqualTo(Integer value) {
            addCriterion("AbsenteeismNum <>", value, "absenteeismnum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumGreaterThan(Integer value) {
            addCriterion("AbsenteeismNum >", value, "absenteeismnum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("AbsenteeismNum >=", value, "absenteeismnum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumLessThan(Integer value) {
            addCriterion("AbsenteeismNum <", value, "absenteeismnum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumLessThanOrEqualTo(Integer value) {
            addCriterion("AbsenteeismNum <=", value, "absenteeismnum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumIn(List<Integer> values) {
            addCriterion("AbsenteeismNum in", values, "absenteeismnum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumNotIn(List<Integer> values) {
            addCriterion("AbsenteeismNum not in", values, "absenteeismnum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumBetween(Integer value1, Integer value2) {
            addCriterion("AbsenteeismNum between", value1, value2, "absenteeismnum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismnumNotBetween(Integer value1, Integer value2) {
            addCriterion("AbsenteeismNum not between", value1, value2, "absenteeismnum");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistIsNull() {
            addCriterion("AbsenteeismList is null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistIsNotNull() {
            addCriterion("AbsenteeismList is not null");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistEqualTo(String value) {
            addCriterion("AbsenteeismList =", value, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistNotEqualTo(String value) {
            addCriterion("AbsenteeismList <>", value, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistGreaterThan(String value) {
            addCriterion("AbsenteeismList >", value, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistGreaterThanOrEqualTo(String value) {
            addCriterion("AbsenteeismList >=", value, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistLessThan(String value) {
            addCriterion("AbsenteeismList <", value, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistLessThanOrEqualTo(String value) {
            addCriterion("AbsenteeismList <=", value, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistLike(String value) {
            addCriterion("AbsenteeismList like", value, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistNotLike(String value) {
            addCriterion("AbsenteeismList not like", value, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistIn(List<String> values) {
            addCriterion("AbsenteeismList in", values, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistNotIn(List<String> values) {
            addCriterion("AbsenteeismList not in", values, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistBetween(String value1, String value2) {
            addCriterion("AbsenteeismList between", value1, value2, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andAbsenteeismlistNotBetween(String value1, String value2) {
            addCriterion("AbsenteeismList not between", value1, value2, "absenteeismlist");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CreateTime not between", value1, value2, "createtime");
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