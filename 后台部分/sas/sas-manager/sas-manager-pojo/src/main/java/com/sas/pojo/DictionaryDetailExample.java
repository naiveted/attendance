package com.sas.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DictionaryDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictionaryDetailExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDictionaryidIsNull() {
            addCriterion("DictionaryId is null");
            return (Criteria) this;
        }

        public Criteria andDictionaryidIsNotNull() {
            addCriterion("DictionaryId is not null");
            return (Criteria) this;
        }

        public Criteria andDictionaryidEqualTo(Integer value) {
            addCriterion("DictionaryId =", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotEqualTo(Integer value) {
            addCriterion("DictionaryId <>", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidGreaterThan(Integer value) {
            addCriterion("DictionaryId >", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("DictionaryId >=", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidLessThan(Integer value) {
            addCriterion("DictionaryId <", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidLessThanOrEqualTo(Integer value) {
            addCriterion("DictionaryId <=", value, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidIn(List<Integer> values) {
            addCriterion("DictionaryId in", values, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotIn(List<Integer> values) {
            addCriterion("DictionaryId not in", values, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidBetween(Integer value1, Integer value2) {
            addCriterion("DictionaryId between", value1, value2, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andDictionaryidNotBetween(Integer value1, Integer value2) {
            addCriterion("DictionaryId not between", value1, value2, "dictionaryid");
            return (Criteria) this;
        }

        public Criteria andItemkeyIsNull() {
            addCriterion("ItemKey is null");
            return (Criteria) this;
        }

        public Criteria andItemkeyIsNotNull() {
            addCriterion("ItemKey is not null");
            return (Criteria) this;
        }

        public Criteria andItemkeyEqualTo(Integer value) {
            addCriterion("ItemKey =", value, "itemkey");
            return (Criteria) this;
        }

        public Criteria andItemkeyNotEqualTo(Integer value) {
            addCriterion("ItemKey <>", value, "itemkey");
            return (Criteria) this;
        }

        public Criteria andItemkeyGreaterThan(Integer value) {
            addCriterion("ItemKey >", value, "itemkey");
            return (Criteria) this;
        }

        public Criteria andItemkeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("ItemKey >=", value, "itemkey");
            return (Criteria) this;
        }

        public Criteria andItemkeyLessThan(Integer value) {
            addCriterion("ItemKey <", value, "itemkey");
            return (Criteria) this;
        }

        public Criteria andItemkeyLessThanOrEqualTo(Integer value) {
            addCriterion("ItemKey <=", value, "itemkey");
            return (Criteria) this;
        }

        public Criteria andItemkeyIn(List<Integer> values) {
            addCriterion("ItemKey in", values, "itemkey");
            return (Criteria) this;
        }

        public Criteria andItemkeyNotIn(List<Integer> values) {
            addCriterion("ItemKey not in", values, "itemkey");
            return (Criteria) this;
        }

        public Criteria andItemkeyBetween(Integer value1, Integer value2) {
            addCriterion("ItemKey between", value1, value2, "itemkey");
            return (Criteria) this;
        }

        public Criteria andItemkeyNotBetween(Integer value1, Integer value2) {
            addCriterion("ItemKey not between", value1, value2, "itemkey");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIsNull() {
            addCriterion("IsDefault is null");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIsNotNull() {
            addCriterion("IsDefault is not null");
            return (Criteria) this;
        }

        public Criteria andIsdefaultEqualTo(Boolean value) {
            addCriterion("IsDefault =", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotEqualTo(Boolean value) {
            addCriterion("IsDefault <>", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultGreaterThan(Boolean value) {
            addCriterion("IsDefault >", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsDefault >=", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultLessThan(Boolean value) {
            addCriterion("IsDefault <", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("IsDefault <=", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIn(List<Boolean> values) {
            addCriterion("IsDefault in", values, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotIn(List<Boolean> values) {
            addCriterion("IsDefault not in", values, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDefault between", value1, value2, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsDefault not between", value1, value2, "isdefault");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("Position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("Position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(Integer value) {
            addCriterion("Position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(Integer value) {
            addCriterion("Position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(Integer value) {
            addCriterion("Position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("Position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(Integer value) {
            addCriterion("Position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(Integer value) {
            addCriterion("Position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<Integer> values) {
            addCriterion("Position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<Integer> values) {
            addCriterion("Position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(Integer value1, Integer value2) {
            addCriterion("Position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(Integer value1, Integer value2) {
            addCriterion("Position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andItemvalueIsNull() {
            addCriterion("ItemValue is null");
            return (Criteria) this;
        }

        public Criteria andItemvalueIsNotNull() {
            addCriterion("ItemValue is not null");
            return (Criteria) this;
        }

        public Criteria andItemvalueEqualTo(String value) {
            addCriterion("ItemValue =", value, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueNotEqualTo(String value) {
            addCriterion("ItemValue <>", value, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueGreaterThan(String value) {
            addCriterion("ItemValue >", value, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueGreaterThanOrEqualTo(String value) {
            addCriterion("ItemValue >=", value, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueLessThan(String value) {
            addCriterion("ItemValue <", value, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueLessThanOrEqualTo(String value) {
            addCriterion("ItemValue <=", value, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueLike(String value) {
            addCriterion("ItemValue like", value, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueNotLike(String value) {
            addCriterion("ItemValue not like", value, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueIn(List<String> values) {
            addCriterion("ItemValue in", values, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueNotIn(List<String> values) {
            addCriterion("ItemValue not in", values, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueBetween(String value1, String value2) {
            addCriterion("ItemValue between", value1, value2, "itemvalue");
            return (Criteria) this;
        }

        public Criteria andItemvalueNotBetween(String value1, String value2) {
            addCriterion("ItemValue not between", value1, value2, "itemvalue");
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