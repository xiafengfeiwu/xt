package com.xt.entity.generation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PumpWarnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PumpWarnExample() {
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

        public Criteria andWarnIdIsNull() {
            addCriterion("warn_id is null");
            return (Criteria) this;
        }

        public Criteria andWarnIdIsNotNull() {
            addCriterion("warn_id is not null");
            return (Criteria) this;
        }

        public Criteria andWarnIdEqualTo(String value) {
            addCriterion("warn_id =", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotEqualTo(String value) {
            addCriterion("warn_id <>", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdGreaterThan(String value) {
            addCriterion("warn_id >", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdGreaterThanOrEqualTo(String value) {
            addCriterion("warn_id >=", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLessThan(String value) {
            addCriterion("warn_id <", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLessThanOrEqualTo(String value) {
            addCriterion("warn_id <=", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdLike(String value) {
            addCriterion("warn_id like", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotLike(String value) {
            addCriterion("warn_id not like", value, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdIn(List<String> values) {
            addCriterion("warn_id in", values, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotIn(List<String> values) {
            addCriterion("warn_id not in", values, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdBetween(String value1, String value2) {
            addCriterion("warn_id between", value1, value2, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnIdNotBetween(String value1, String value2) {
            addCriterion("warn_id not between", value1, value2, "warnId");
            return (Criteria) this;
        }

        public Criteria andWarnNoIsNull() {
            addCriterion("warn_no is null");
            return (Criteria) this;
        }

        public Criteria andWarnNoIsNotNull() {
            addCriterion("warn_no is not null");
            return (Criteria) this;
        }

        public Criteria andWarnNoEqualTo(String value) {
            addCriterion("warn_no =", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotEqualTo(String value) {
            addCriterion("warn_no <>", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoGreaterThan(String value) {
            addCriterion("warn_no >", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoGreaterThanOrEqualTo(String value) {
            addCriterion("warn_no >=", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoLessThan(String value) {
            addCriterion("warn_no <", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoLessThanOrEqualTo(String value) {
            addCriterion("warn_no <=", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoLike(String value) {
            addCriterion("warn_no like", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotLike(String value) {
            addCriterion("warn_no not like", value, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoIn(List<String> values) {
            addCriterion("warn_no in", values, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotIn(List<String> values) {
            addCriterion("warn_no not in", values, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoBetween(String value1, String value2) {
            addCriterion("warn_no between", value1, value2, "warnNo");
            return (Criteria) this;
        }

        public Criteria andWarnNoNotBetween(String value1, String value2) {
            addCriterion("warn_no not between", value1, value2, "warnNo");
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

        public Criteria andPumpIdEqualTo(String value) {
            addCriterion("pump_id =", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdNotEqualTo(String value) {
            addCriterion("pump_id <>", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdGreaterThan(String value) {
            addCriterion("pump_id >", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdGreaterThanOrEqualTo(String value) {
            addCriterion("pump_id >=", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdLessThan(String value) {
            addCriterion("pump_id <", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdLessThanOrEqualTo(String value) {
            addCriterion("pump_id <=", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdLike(String value) {
            addCriterion("pump_id like", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdNotLike(String value) {
            addCriterion("pump_id not like", value, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdIn(List<String> values) {
            addCriterion("pump_id in", values, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdNotIn(List<String> values) {
            addCriterion("pump_id not in", values, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdBetween(String value1, String value2) {
            addCriterion("pump_id between", value1, value2, "pumpId");
            return (Criteria) this;
        }

        public Criteria andPumpIdNotBetween(String value1, String value2) {
            addCriterion("pump_id not between", value1, value2, "pumpId");
            return (Criteria) this;
        }

        public Criteria andWarnCodeIsNull() {
            addCriterion("warn_code is null");
            return (Criteria) this;
        }

        public Criteria andWarnCodeIsNotNull() {
            addCriterion("warn_code is not null");
            return (Criteria) this;
        }

        public Criteria andWarnCodeEqualTo(String value) {
            addCriterion("warn_code =", value, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeNotEqualTo(String value) {
            addCriterion("warn_code <>", value, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeGreaterThan(String value) {
            addCriterion("warn_code >", value, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("warn_code >=", value, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeLessThan(String value) {
            addCriterion("warn_code <", value, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeLessThanOrEqualTo(String value) {
            addCriterion("warn_code <=", value, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeLike(String value) {
            addCriterion("warn_code like", value, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeNotLike(String value) {
            addCriterion("warn_code not like", value, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeIn(List<String> values) {
            addCriterion("warn_code in", values, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeNotIn(List<String> values) {
            addCriterion("warn_code not in", values, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeBetween(String value1, String value2) {
            addCriterion("warn_code between", value1, value2, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnCodeNotBetween(String value1, String value2) {
            addCriterion("warn_code not between", value1, value2, "warnCode");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIsNull() {
            addCriterion("warn_level is null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIsNotNull() {
            addCriterion("warn_level is not null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelEqualTo(String value) {
            addCriterion("warn_level =", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotEqualTo(String value) {
            addCriterion("warn_level <>", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelGreaterThan(String value) {
            addCriterion("warn_level >", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelGreaterThanOrEqualTo(String value) {
            addCriterion("warn_level >=", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLessThan(String value) {
            addCriterion("warn_level <", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLessThanOrEqualTo(String value) {
            addCriterion("warn_level <=", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLike(String value) {
            addCriterion("warn_level like", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotLike(String value) {
            addCriterion("warn_level not like", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIn(List<String> values) {
            addCriterion("warn_level in", values, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotIn(List<String> values) {
            addCriterion("warn_level not in", values, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelBetween(String value1, String value2) {
            addCriterion("warn_level between", value1, value2, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotBetween(String value1, String value2) {
            addCriterion("warn_level not between", value1, value2, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptIsNull() {
            addCriterion("warn_descript is null");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptIsNotNull() {
            addCriterion("warn_descript is not null");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptEqualTo(String value) {
            addCriterion("warn_descript =", value, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptNotEqualTo(String value) {
            addCriterion("warn_descript <>", value, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptGreaterThan(String value) {
            addCriterion("warn_descript >", value, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptGreaterThanOrEqualTo(String value) {
            addCriterion("warn_descript >=", value, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptLessThan(String value) {
            addCriterion("warn_descript <", value, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptLessThanOrEqualTo(String value) {
            addCriterion("warn_descript <=", value, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptLike(String value) {
            addCriterion("warn_descript like", value, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptNotLike(String value) {
            addCriterion("warn_descript not like", value, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptIn(List<String> values) {
            addCriterion("warn_descript in", values, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptNotIn(List<String> values) {
            addCriterion("warn_descript not in", values, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptBetween(String value1, String value2) {
            addCriterion("warn_descript between", value1, value2, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnDescriptNotBetween(String value1, String value2) {
            addCriterion("warn_descript not between", value1, value2, "warnDescript");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeIsNull() {
            addCriterion("warn_happen_time is null");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeIsNotNull() {
            addCriterion("warn_happen_time is not null");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeEqualTo(Date value) {
            addCriterion("warn_happen_time =", value, "warnHappenTime");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeNotEqualTo(Date value) {
            addCriterion("warn_happen_time <>", value, "warnHappenTime");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeGreaterThan(Date value) {
            addCriterion("warn_happen_time >", value, "warnHappenTime");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("warn_happen_time >=", value, "warnHappenTime");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeLessThan(Date value) {
            addCriterion("warn_happen_time <", value, "warnHappenTime");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeLessThanOrEqualTo(Date value) {
            addCriterion("warn_happen_time <=", value, "warnHappenTime");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeIn(List<Date> values) {
            addCriterion("warn_happen_time in", values, "warnHappenTime");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeNotIn(List<Date> values) {
            addCriterion("warn_happen_time not in", values, "warnHappenTime");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeBetween(Date value1, Date value2) {
            addCriterion("warn_happen_time between", value1, value2, "warnHappenTime");
            return (Criteria) this;
        }

        public Criteria andWarnHappenTimeNotBetween(Date value1, Date value2) {
            addCriterion("warn_happen_time not between", value1, value2, "warnHappenTime");
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