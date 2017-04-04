package com.xt.entity.generation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PumpEleStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PumpEleStatisticsExample() {
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

        public Criteria andDataIdIsNull() {
            addCriterion("data_id is null");
            return (Criteria) this;
        }

        public Criteria andDataIdIsNotNull() {
            addCriterion("data_id is not null");
            return (Criteria) this;
        }

        public Criteria andDataIdEqualTo(String value) {
            addCriterion("data_id =", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotEqualTo(String value) {
            addCriterion("data_id <>", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThan(String value) {
            addCriterion("data_id >", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdGreaterThanOrEqualTo(String value) {
            addCriterion("data_id >=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThan(String value) {
            addCriterion("data_id <", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLessThanOrEqualTo(String value) {
            addCriterion("data_id <=", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdLike(String value) {
            addCriterion("data_id like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotLike(String value) {
            addCriterion("data_id not like", value, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdIn(List<String> values) {
            addCriterion("data_id in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotIn(List<String> values) {
            addCriterion("data_id not in", values, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdBetween(String value1, String value2) {
            addCriterion("data_id between", value1, value2, "dataId");
            return (Criteria) this;
        }

        public Criteria andDataIdNotBetween(String value1, String value2) {
            addCriterion("data_id not between", value1, value2, "dataId");
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

        public Criteria andIntervalYearIsNull() {
            addCriterion("interval_year is null");
            return (Criteria) this;
        }

        public Criteria andIntervalYearIsNotNull() {
            addCriterion("interval_year is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalYearEqualTo(Short value) {
            addCriterion("interval_year =", value, "intervalYear");
            return (Criteria) this;
        }

        public Criteria andIntervalYearNotEqualTo(Short value) {
            addCriterion("interval_year <>", value, "intervalYear");
            return (Criteria) this;
        }

        public Criteria andIntervalYearGreaterThan(Short value) {
            addCriterion("interval_year >", value, "intervalYear");
            return (Criteria) this;
        }

        public Criteria andIntervalYearGreaterThanOrEqualTo(Short value) {
            addCriterion("interval_year >=", value, "intervalYear");
            return (Criteria) this;
        }

        public Criteria andIntervalYearLessThan(Short value) {
            addCriterion("interval_year <", value, "intervalYear");
            return (Criteria) this;
        }

        public Criteria andIntervalYearLessThanOrEqualTo(Short value) {
            addCriterion("interval_year <=", value, "intervalYear");
            return (Criteria) this;
        }

        public Criteria andIntervalYearIn(List<Short> values) {
            addCriterion("interval_year in", values, "intervalYear");
            return (Criteria) this;
        }

        public Criteria andIntervalYearNotIn(List<Short> values) {
            addCriterion("interval_year not in", values, "intervalYear");
            return (Criteria) this;
        }

        public Criteria andIntervalYearBetween(Short value1, Short value2) {
            addCriterion("interval_year between", value1, value2, "intervalYear");
            return (Criteria) this;
        }

        public Criteria andIntervalYearNotBetween(Short value1, Short value2) {
            addCriterion("interval_year not between", value1, value2, "intervalYear");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthIsNull() {
            addCriterion("interval_month is null");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthIsNotNull() {
            addCriterion("interval_month is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthEqualTo(Short value) {
            addCriterion("interval_month =", value, "intervalMonth");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthNotEqualTo(Short value) {
            addCriterion("interval_month <>", value, "intervalMonth");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthGreaterThan(Short value) {
            addCriterion("interval_month >", value, "intervalMonth");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthGreaterThanOrEqualTo(Short value) {
            addCriterion("interval_month >=", value, "intervalMonth");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthLessThan(Short value) {
            addCriterion("interval_month <", value, "intervalMonth");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthLessThanOrEqualTo(Short value) {
            addCriterion("interval_month <=", value, "intervalMonth");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthIn(List<Short> values) {
            addCriterion("interval_month in", values, "intervalMonth");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthNotIn(List<Short> values) {
            addCriterion("interval_month not in", values, "intervalMonth");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthBetween(Short value1, Short value2) {
            addCriterion("interval_month between", value1, value2, "intervalMonth");
            return (Criteria) this;
        }

        public Criteria andIntervalMonthNotBetween(Short value1, Short value2) {
            addCriterion("interval_month not between", value1, value2, "intervalMonth");
            return (Criteria) this;
        }

        public Criteria andIntervalDayIsNull() {
            addCriterion("interval_day is null");
            return (Criteria) this;
        }

        public Criteria andIntervalDayIsNotNull() {
            addCriterion("interval_day is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalDayEqualTo(Short value) {
            addCriterion("interval_day =", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayNotEqualTo(Short value) {
            addCriterion("interval_day <>", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayGreaterThan(Short value) {
            addCriterion("interval_day >", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayGreaterThanOrEqualTo(Short value) {
            addCriterion("interval_day >=", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayLessThan(Short value) {
            addCriterion("interval_day <", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayLessThanOrEqualTo(Short value) {
            addCriterion("interval_day <=", value, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayIn(List<Short> values) {
            addCriterion("interval_day in", values, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayNotIn(List<Short> values) {
            addCriterion("interval_day not in", values, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayBetween(Short value1, Short value2) {
            addCriterion("interval_day between", value1, value2, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalDayNotBetween(Short value1, Short value2) {
            addCriterion("interval_day not between", value1, value2, "intervalDay");
            return (Criteria) this;
        }

        public Criteria andIntervalHourIsNull() {
            addCriterion("interval_hour is null");
            return (Criteria) this;
        }

        public Criteria andIntervalHourIsNotNull() {
            addCriterion("interval_hour is not null");
            return (Criteria) this;
        }

        public Criteria andIntervalHourEqualTo(Short value) {
            addCriterion("interval_hour =", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourNotEqualTo(Short value) {
            addCriterion("interval_hour <>", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourGreaterThan(Short value) {
            addCriterion("interval_hour >", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourGreaterThanOrEqualTo(Short value) {
            addCriterion("interval_hour >=", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourLessThan(Short value) {
            addCriterion("interval_hour <", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourLessThanOrEqualTo(Short value) {
            addCriterion("interval_hour <=", value, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourIn(List<Short> values) {
            addCriterion("interval_hour in", values, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourNotIn(List<Short> values) {
            addCriterion("interval_hour not in", values, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourBetween(Short value1, Short value2) {
            addCriterion("interval_hour between", value1, value2, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andIntervalHourNotBetween(Short value1, Short value2) {
            addCriterion("interval_hour not between", value1, value2, "intervalHour");
            return (Criteria) this;
        }

        public Criteria andEleIntervalIsNull() {
            addCriterion("ele_interval is null");
            return (Criteria) this;
        }

        public Criteria andEleIntervalIsNotNull() {
            addCriterion("ele_interval is not null");
            return (Criteria) this;
        }

        public Criteria andEleIntervalEqualTo(BigDecimal value) {
            addCriterion("ele_interval =", value, "eleInterval");
            return (Criteria) this;
        }

        public Criteria andEleIntervalNotEqualTo(BigDecimal value) {
            addCriterion("ele_interval <>", value, "eleInterval");
            return (Criteria) this;
        }

        public Criteria andEleIntervalGreaterThan(BigDecimal value) {
            addCriterion("ele_interval >", value, "eleInterval");
            return (Criteria) this;
        }

        public Criteria andEleIntervalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ele_interval >=", value, "eleInterval");
            return (Criteria) this;
        }

        public Criteria andEleIntervalLessThan(BigDecimal value) {
            addCriterion("ele_interval <", value, "eleInterval");
            return (Criteria) this;
        }

        public Criteria andEleIntervalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ele_interval <=", value, "eleInterval");
            return (Criteria) this;
        }

        public Criteria andEleIntervalIn(List<BigDecimal> values) {
            addCriterion("ele_interval in", values, "eleInterval");
            return (Criteria) this;
        }

        public Criteria andEleIntervalNotIn(List<BigDecimal> values) {
            addCriterion("ele_interval not in", values, "eleInterval");
            return (Criteria) this;
        }

        public Criteria andEleIntervalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ele_interval between", value1, value2, "eleInterval");
            return (Criteria) this;
        }

        public Criteria andEleIntervalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ele_interval not between", value1, value2, "eleInterval");
            return (Criteria) this;
        }

        public Criteria andEleTotalIsNull() {
            addCriterion("ele_total is null");
            return (Criteria) this;
        }

        public Criteria andEleTotalIsNotNull() {
            addCriterion("ele_total is not null");
            return (Criteria) this;
        }

        public Criteria andEleTotalEqualTo(BigDecimal value) {
            addCriterion("ele_total =", value, "eleTotal");
            return (Criteria) this;
        }

        public Criteria andEleTotalNotEqualTo(BigDecimal value) {
            addCriterion("ele_total <>", value, "eleTotal");
            return (Criteria) this;
        }

        public Criteria andEleTotalGreaterThan(BigDecimal value) {
            addCriterion("ele_total >", value, "eleTotal");
            return (Criteria) this;
        }

        public Criteria andEleTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ele_total >=", value, "eleTotal");
            return (Criteria) this;
        }

        public Criteria andEleTotalLessThan(BigDecimal value) {
            addCriterion("ele_total <", value, "eleTotal");
            return (Criteria) this;
        }

        public Criteria andEleTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ele_total <=", value, "eleTotal");
            return (Criteria) this;
        }

        public Criteria andEleTotalIn(List<BigDecimal> values) {
            addCriterion("ele_total in", values, "eleTotal");
            return (Criteria) this;
        }

        public Criteria andEleTotalNotIn(List<BigDecimal> values) {
            addCriterion("ele_total not in", values, "eleTotal");
            return (Criteria) this;
        }

        public Criteria andEleTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ele_total between", value1, value2, "eleTotal");
            return (Criteria) this;
        }

        public Criteria andEleTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ele_total not between", value1, value2, "eleTotal");
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