package com.xt.entity.generation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
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

        public Criteria andDeviceIdIsNull() {
            addCriterion("device_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("device_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Long value) {
            addCriterion("device_id =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Long value) {
            addCriterion("device_id <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Long value) {
            addCriterion("device_id >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("device_id >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Long value) {
            addCriterion("device_id <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Long value) {
            addCriterion("device_id <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Long> values) {
            addCriterion("device_id in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Long> values) {
            addCriterion("device_id not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Long value1, Long value2) {
            addCriterion("device_id between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Long value1, Long value2) {
            addCriterion("device_id not between", value1, value2, "deviceId");
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

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceSnIsNull() {
            addCriterion("device_sn is null");
            return (Criteria) this;
        }

        public Criteria andDeviceSnIsNotNull() {
            addCriterion("device_sn is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceSnEqualTo(String value) {
            addCriterion("device_sn =", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotEqualTo(String value) {
            addCriterion("device_sn <>", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnGreaterThan(String value) {
            addCriterion("device_sn >", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnGreaterThanOrEqualTo(String value) {
            addCriterion("device_sn >=", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnLessThan(String value) {
            addCriterion("device_sn <", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnLessThanOrEqualTo(String value) {
            addCriterion("device_sn <=", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnLike(String value) {
            addCriterion("device_sn like", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotLike(String value) {
            addCriterion("device_sn not like", value, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnIn(List<String> values) {
            addCriterion("device_sn in", values, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotIn(List<String> values) {
            addCriterion("device_sn not in", values, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnBetween(String value1, String value2) {
            addCriterion("device_sn between", value1, value2, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceSnNotBetween(String value1, String value2) {
            addCriterion("device_sn not between", value1, value2, "deviceSn");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdIsNull() {
            addCriterion("device_product_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdIsNotNull() {
            addCriterion("device_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdEqualTo(Long value) {
            addCriterion("device_product_id =", value, "deviceProductId");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdNotEqualTo(Long value) {
            addCriterion("device_product_id <>", value, "deviceProductId");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdGreaterThan(Long value) {
            addCriterion("device_product_id >", value, "deviceProductId");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("device_product_id >=", value, "deviceProductId");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdLessThan(Long value) {
            addCriterion("device_product_id <", value, "deviceProductId");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdLessThanOrEqualTo(Long value) {
            addCriterion("device_product_id <=", value, "deviceProductId");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdIn(List<Long> values) {
            addCriterion("device_product_id in", values, "deviceProductId");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdNotIn(List<Long> values) {
            addCriterion("device_product_id not in", values, "deviceProductId");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdBetween(Long value1, Long value2) {
            addCriterion("device_product_id between", value1, value2, "deviceProductId");
            return (Criteria) this;
        }

        public Criteria andDeviceProductIdNotBetween(Long value1, Long value2) {
            addCriterion("device_product_id not between", value1, value2, "deviceProductId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(Long value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(Long value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(Long value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(Long value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(Long value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<Long> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<Long> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(Long value1, Long value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(Long value1, Long value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeIsNull() {
            addCriterion("last_collect_time is null");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeIsNotNull() {
            addCriterion("last_collect_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeEqualTo(Date value) {
            addCriterion("last_collect_time =", value, "lastCollectTime");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeNotEqualTo(Date value) {
            addCriterion("last_collect_time <>", value, "lastCollectTime");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeGreaterThan(Date value) {
            addCriterion("last_collect_time >", value, "lastCollectTime");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_collect_time >=", value, "lastCollectTime");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeLessThan(Date value) {
            addCriterion("last_collect_time <", value, "lastCollectTime");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_collect_time <=", value, "lastCollectTime");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeIn(List<Date> values) {
            addCriterion("last_collect_time in", values, "lastCollectTime");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeNotIn(List<Date> values) {
            addCriterion("last_collect_time not in", values, "lastCollectTime");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeBetween(Date value1, Date value2) {
            addCriterion("last_collect_time between", value1, value2, "lastCollectTime");
            return (Criteria) this;
        }

        public Criteria andLastCollectTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_collect_time not between", value1, value2, "lastCollectTime");
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