package com.xt.entity.generation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceProductExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Long value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Long value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Long value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Long value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Long value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Long> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Long> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Long value1, Long value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Long value1, Long value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(String value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(String value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(String value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(String value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(String value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(String value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLike(String value) {
            addCriterion("product_type like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotLike(String value) {
            addCriterion("product_type not like", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<String> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<String> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(String value1, String value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(String value1, String value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdIsNull() {
            addCriterion("product_vender_id is null");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdIsNotNull() {
            addCriterion("product_vender_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdEqualTo(Long value) {
            addCriterion("product_vender_id =", value, "productVenderId");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdNotEqualTo(Long value) {
            addCriterion("product_vender_id <>", value, "productVenderId");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdGreaterThan(Long value) {
            addCriterion("product_vender_id >", value, "productVenderId");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("product_vender_id >=", value, "productVenderId");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdLessThan(Long value) {
            addCriterion("product_vender_id <", value, "productVenderId");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdLessThanOrEqualTo(Long value) {
            addCriterion("product_vender_id <=", value, "productVenderId");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdIn(List<Long> values) {
            addCriterion("product_vender_id in", values, "productVenderId");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdNotIn(List<Long> values) {
            addCriterion("product_vender_id not in", values, "productVenderId");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdBetween(Long value1, Long value2) {
            addCriterion("product_vender_id between", value1, value2, "productVenderId");
            return (Criteria) this;
        }

        public Criteria andProductVenderIdNotBetween(Long value1, Long value2) {
            addCriterion("product_vender_id not between", value1, value2, "productVenderId");
            return (Criteria) this;
        }

        public Criteria andProductSpecIsNull() {
            addCriterion("product_spec is null");
            return (Criteria) this;
        }

        public Criteria andProductSpecIsNotNull() {
            addCriterion("product_spec is not null");
            return (Criteria) this;
        }

        public Criteria andProductSpecEqualTo(String value) {
            addCriterion("product_spec =", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotEqualTo(String value) {
            addCriterion("product_spec <>", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecGreaterThan(String value) {
            addCriterion("product_spec >", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecGreaterThanOrEqualTo(String value) {
            addCriterion("product_spec >=", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecLessThan(String value) {
            addCriterion("product_spec <", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecLessThanOrEqualTo(String value) {
            addCriterion("product_spec <=", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecLike(String value) {
            addCriterion("product_spec like", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotLike(String value) {
            addCriterion("product_spec not like", value, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecIn(List<String> values) {
            addCriterion("product_spec in", values, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotIn(List<String> values) {
            addCriterion("product_spec not in", values, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecBetween(String value1, String value2) {
            addCriterion("product_spec between", value1, value2, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductSpecNotBetween(String value1, String value2) {
            addCriterion("product_spec not between", value1, value2, "productSpec");
            return (Criteria) this;
        }

        public Criteria andProductPiIsNull() {
            addCriterion("product_pi is null");
            return (Criteria) this;
        }

        public Criteria andProductPiIsNotNull() {
            addCriterion("product_pi is not null");
            return (Criteria) this;
        }

        public Criteria andProductPiEqualTo(String value) {
            addCriterion("product_pi =", value, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiNotEqualTo(String value) {
            addCriterion("product_pi <>", value, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiGreaterThan(String value) {
            addCriterion("product_pi >", value, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiGreaterThanOrEqualTo(String value) {
            addCriterion("product_pi >=", value, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiLessThan(String value) {
            addCriterion("product_pi <", value, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiLessThanOrEqualTo(String value) {
            addCriterion("product_pi <=", value, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiLike(String value) {
            addCriterion("product_pi like", value, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiNotLike(String value) {
            addCriterion("product_pi not like", value, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiIn(List<String> values) {
            addCriterion("product_pi in", values, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiNotIn(List<String> values) {
            addCriterion("product_pi not in", values, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiBetween(String value1, String value2) {
            addCriterion("product_pi between", value1, value2, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPiNotBetween(String value1, String value2) {
            addCriterion("product_pi not between", value1, value2, "productPi");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecIsNull() {
            addCriterion("product_power_spec is null");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecIsNotNull() {
            addCriterion("product_power_spec is not null");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecEqualTo(String value) {
            addCriterion("product_power_spec =", value, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecNotEqualTo(String value) {
            addCriterion("product_power_spec <>", value, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecGreaterThan(String value) {
            addCriterion("product_power_spec >", value, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecGreaterThanOrEqualTo(String value) {
            addCriterion("product_power_spec >=", value, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecLessThan(String value) {
            addCriterion("product_power_spec <", value, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecLessThanOrEqualTo(String value) {
            addCriterion("product_power_spec <=", value, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecLike(String value) {
            addCriterion("product_power_spec like", value, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecNotLike(String value) {
            addCriterion("product_power_spec not like", value, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecIn(List<String> values) {
            addCriterion("product_power_spec in", values, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecNotIn(List<String> values) {
            addCriterion("product_power_spec not in", values, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecBetween(String value1, String value2) {
            addCriterion("product_power_spec between", value1, value2, "productPowerSpec");
            return (Criteria) this;
        }

        public Criteria andProductPowerSpecNotBetween(String value1, String value2) {
            addCriterion("product_power_spec not between", value1, value2, "productPowerSpec");
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