package com.xt.entity.generation;

import java.util.ArrayList;
import java.util.List;

public class UserAuthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAuthExample() {
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

        public Criteria andRootIdIsNull() {
            addCriterion("root_id is null");
            return (Criteria) this;
        }

        public Criteria andRootIdIsNotNull() {
            addCriterion("root_id is not null");
            return (Criteria) this;
        }

        public Criteria andRootIdEqualTo(Long value) {
            addCriterion("root_id =", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdNotEqualTo(Long value) {
            addCriterion("root_id <>", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdGreaterThan(Long value) {
            addCriterion("root_id >", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdGreaterThanOrEqualTo(Long value) {
            addCriterion("root_id >=", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdLessThan(Long value) {
            addCriterion("root_id <", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdLessThanOrEqualTo(Long value) {
            addCriterion("root_id <=", value, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdIn(List<Long> values) {
            addCriterion("root_id in", values, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdNotIn(List<Long> values) {
            addCriterion("root_id not in", values, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdBetween(Long value1, Long value2) {
            addCriterion("root_id between", value1, value2, "rootId");
            return (Criteria) this;
        }

        public Criteria andRootIdNotBetween(Long value1, Long value2) {
            addCriterion("root_id not between", value1, value2, "rootId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIsNull() {
            addCriterion("auth_code is null");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIsNotNull() {
            addCriterion("auth_code is not null");
            return (Criteria) this;
        }

        public Criteria andAuthCodeEqualTo(String value) {
            addCriterion("auth_code =", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotEqualTo(String value) {
            addCriterion("auth_code <>", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeGreaterThan(String value) {
            addCriterion("auth_code >", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeGreaterThanOrEqualTo(String value) {
            addCriterion("auth_code >=", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLessThan(String value) {
            addCriterion("auth_code <", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLessThanOrEqualTo(String value) {
            addCriterion("auth_code <=", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLike(String value) {
            addCriterion("auth_code like", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotLike(String value) {
            addCriterion("auth_code not like", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIn(List<String> values) {
            addCriterion("auth_code in", values, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotIn(List<String> values) {
            addCriterion("auth_code not in", values, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeBetween(String value1, String value2) {
            addCriterion("auth_code between", value1, value2, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotBetween(String value1, String value2) {
            addCriterion("auth_code not between", value1, value2, "authCode");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdIsNull() {
            addCriterion("project_area_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdIsNotNull() {
            addCriterion("project_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdEqualTo(Long value) {
            addCriterion("project_area_id =", value, "projectAreaId");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdNotEqualTo(Long value) {
            addCriterion("project_area_id <>", value, "projectAreaId");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdGreaterThan(Long value) {
            addCriterion("project_area_id >", value, "projectAreaId");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_area_id >=", value, "projectAreaId");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdLessThan(Long value) {
            addCriterion("project_area_id <", value, "projectAreaId");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("project_area_id <=", value, "projectAreaId");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdIn(List<Long> values) {
            addCriterion("project_area_id in", values, "projectAreaId");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdNotIn(List<Long> values) {
            addCriterion("project_area_id not in", values, "projectAreaId");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdBetween(Long value1, Long value2) {
            addCriterion("project_area_id between", value1, value2, "projectAreaId");
            return (Criteria) this;
        }

        public Criteria andProjectAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("project_area_id not between", value1, value2, "projectAreaId");
            return (Criteria) this;
        }

        public Criteria andPumpIdIsNull() {
            addCriterion("pump_id is null");
            return (Criteria) this;
        }

        public Criteria andPumpIdIsNotNull() {
            addCriterion("pump_id is not null");
            return (Criteria) this;
        }

        public Criteria andPumpIdEqualTo(Long value) {
            addCriterion("pump_id =", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdNotEqualTo(Long value) {
            addCriterion("pump_id <>", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdGreaterThan(Long value) {
            addCriterion("pump_id >", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pump_id >=", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdLessThan(Long value) {
            addCriterion("pump_id <", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdLessThanOrEqualTo(Long value) {
            addCriterion("pump_id <=", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdIn(List<Long> values) {
            addCriterion("pump_id in", values, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdNotIn(List<Long> values) {
            addCriterion("pump_id not in", values, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdBetween(Long value1, Long value2) {
            addCriterion("pump_id between", value1, value2, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdNotBetween(Long value1, Long value2) {
            addCriterion("pump_id not between", value1, value2, "pumpId");
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