package com.xt.entity.generation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceVenderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceVenderExample() {
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

        public Criteria andVenderIdIsNull() {
            addCriterion("vender_id is null");
            return (Criteria) this;
        }

        public Criteria andVenderIdIsNotNull() {
            addCriterion("vender_id is not null");
            return (Criteria) this;
        }

        public Criteria andVenderIdEqualTo(Long value) {
            addCriterion("vender_id =", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdNotEqualTo(Long value) {
            addCriterion("vender_id <>", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdGreaterThan(Long value) {
            addCriterion("vender_id >", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("vender_id >=", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdLessThan(Long value) {
            addCriterion("vender_id <", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdLessThanOrEqualTo(Long value) {
            addCriterion("vender_id <=", value, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdIn(List<Long> values) {
            addCriterion("vender_id in", values, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdNotIn(List<Long> values) {
            addCriterion("vender_id not in", values, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdBetween(Long value1, Long value2) {
            addCriterion("vender_id between", value1, value2, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderIdNotBetween(Long value1, Long value2) {
            addCriterion("vender_id not between", value1, value2, "venderId");
            return (Criteria) this;
        }

        public Criteria andVenderNameIsNull() {
            addCriterion("vender_name is null");
            return (Criteria) this;
        }

        public Criteria andVenderNameIsNotNull() {
            addCriterion("vender_name is not null");
            return (Criteria) this;
        }

        public Criteria andVenderNameEqualTo(String value) {
            addCriterion("vender_name =", value, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameNotEqualTo(String value) {
            addCriterion("vender_name <>", value, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameGreaterThan(String value) {
            addCriterion("vender_name >", value, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameGreaterThanOrEqualTo(String value) {
            addCriterion("vender_name >=", value, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameLessThan(String value) {
            addCriterion("vender_name <", value, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameLessThanOrEqualTo(String value) {
            addCriterion("vender_name <=", value, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameLike(String value) {
            addCriterion("vender_name like", value, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameNotLike(String value) {
            addCriterion("vender_name not like", value, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameIn(List<String> values) {
            addCriterion("vender_name in", values, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameNotIn(List<String> values) {
            addCriterion("vender_name not in", values, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameBetween(String value1, String value2) {
            addCriterion("vender_name between", value1, value2, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderNameNotBetween(String value1, String value2) {
            addCriterion("vender_name not between", value1, value2, "venderName");
            return (Criteria) this;
        }

        public Criteria andVenderContactsIsNull() {
            addCriterion("vender_contacts is null");
            return (Criteria) this;
        }

        public Criteria andVenderContactsIsNotNull() {
            addCriterion("vender_contacts is not null");
            return (Criteria) this;
        }

        public Criteria andVenderContactsEqualTo(String value) {
            addCriterion("vender_contacts =", value, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsNotEqualTo(String value) {
            addCriterion("vender_contacts <>", value, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsGreaterThan(String value) {
            addCriterion("vender_contacts >", value, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsGreaterThanOrEqualTo(String value) {
            addCriterion("vender_contacts >=", value, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsLessThan(String value) {
            addCriterion("vender_contacts <", value, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsLessThanOrEqualTo(String value) {
            addCriterion("vender_contacts <=", value, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsLike(String value) {
            addCriterion("vender_contacts like", value, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsNotLike(String value) {
            addCriterion("vender_contacts not like", value, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsIn(List<String> values) {
            addCriterion("vender_contacts in", values, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsNotIn(List<String> values) {
            addCriterion("vender_contacts not in", values, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsBetween(String value1, String value2) {
            addCriterion("vender_contacts between", value1, value2, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsNotBetween(String value1, String value2) {
            addCriterion("vender_contacts not between", value1, value2, "venderContacts");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelIsNull() {
            addCriterion("vender_contacts_tel is null");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelIsNotNull() {
            addCriterion("vender_contacts_tel is not null");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelEqualTo(String value) {
            addCriterion("vender_contacts_tel =", value, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelNotEqualTo(String value) {
            addCriterion("vender_contacts_tel <>", value, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelGreaterThan(String value) {
            addCriterion("vender_contacts_tel >", value, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelGreaterThanOrEqualTo(String value) {
            addCriterion("vender_contacts_tel >=", value, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelLessThan(String value) {
            addCriterion("vender_contacts_tel <", value, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelLessThanOrEqualTo(String value) {
            addCriterion("vender_contacts_tel <=", value, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelLike(String value) {
            addCriterion("vender_contacts_tel like", value, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelNotLike(String value) {
            addCriterion("vender_contacts_tel not like", value, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelIn(List<String> values) {
            addCriterion("vender_contacts_tel in", values, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelNotIn(List<String> values) {
            addCriterion("vender_contacts_tel not in", values, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelBetween(String value1, String value2) {
            addCriterion("vender_contacts_tel between", value1, value2, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderContactsTelNotBetween(String value1, String value2) {
            addCriterion("vender_contacts_tel not between", value1, value2, "venderContactsTel");
            return (Criteria) this;
        }

        public Criteria andVenderAddressIsNull() {
            addCriterion("vender_address is null");
            return (Criteria) this;
        }

        public Criteria andVenderAddressIsNotNull() {
            addCriterion("vender_address is not null");
            return (Criteria) this;
        }

        public Criteria andVenderAddressEqualTo(String value) {
            addCriterion("vender_address =", value, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressNotEqualTo(String value) {
            addCriterion("vender_address <>", value, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressGreaterThan(String value) {
            addCriterion("vender_address >", value, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("vender_address >=", value, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressLessThan(String value) {
            addCriterion("vender_address <", value, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressLessThanOrEqualTo(String value) {
            addCriterion("vender_address <=", value, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressLike(String value) {
            addCriterion("vender_address like", value, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressNotLike(String value) {
            addCriterion("vender_address not like", value, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressIn(List<String> values) {
            addCriterion("vender_address in", values, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressNotIn(List<String> values) {
            addCriterion("vender_address not in", values, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressBetween(String value1, String value2) {
            addCriterion("vender_address between", value1, value2, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderAddressNotBetween(String value1, String value2) {
            addCriterion("vender_address not between", value1, value2, "venderAddress");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkIsNull() {
            addCriterion("vender_remark is null");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkIsNotNull() {
            addCriterion("vender_remark is not null");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkEqualTo(String value) {
            addCriterion("vender_remark =", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotEqualTo(String value) {
            addCriterion("vender_remark <>", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkGreaterThan(String value) {
            addCriterion("vender_remark >", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("vender_remark >=", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkLessThan(String value) {
            addCriterion("vender_remark <", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkLessThanOrEqualTo(String value) {
            addCriterion("vender_remark <=", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkLike(String value) {
            addCriterion("vender_remark like", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotLike(String value) {
            addCriterion("vender_remark not like", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkIn(List<String> values) {
            addCriterion("vender_remark in", values, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotIn(List<String> values) {
            addCriterion("vender_remark not in", values, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkBetween(String value1, String value2) {
            addCriterion("vender_remark between", value1, value2, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotBetween(String value1, String value2) {
            addCriterion("vender_remark not between", value1, value2, "venderRemark");
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