package com.xt.entity.generation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoppageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoppageExample() {
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

        public Criteria andStoppageIdIsNull() {
            addCriterion("stoppage_id is null");
            return (Criteria) this;
        }

        public Criteria andStoppageIdIsNotNull() {
            addCriterion("stoppage_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoppageIdEqualTo(String value) {
            addCriterion("stoppage_id =", value, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdNotEqualTo(String value) {
            addCriterion("stoppage_id <>", value, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdGreaterThan(String value) {
            addCriterion("stoppage_id >", value, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdGreaterThanOrEqualTo(String value) {
            addCriterion("stoppage_id >=", value, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdLessThan(String value) {
            addCriterion("stoppage_id <", value, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdLessThanOrEqualTo(String value) {
            addCriterion("stoppage_id <=", value, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdLike(String value) {
            addCriterion("stoppage_id like", value, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdNotLike(String value) {
            addCriterion("stoppage_id not like", value, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdIn(List<String> values) {
            addCriterion("stoppage_id in", values, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdNotIn(List<String> values) {
            addCriterion("stoppage_id not in", values, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdBetween(String value1, String value2) {
            addCriterion("stoppage_id between", value1, value2, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andStoppageIdNotBetween(String value1, String value2) {
            addCriterion("stoppage_id not between", value1, value2, "stoppageId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(String value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(String value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(String value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(String value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(String value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLike(String value) {
            addCriterion("operator_id like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotLike(String value) {
            addCriterion("operator_id not like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<String> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<String> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(String value1, String value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(String value1, String value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andStoppageNoIsNull() {
            addCriterion("stoppage_no is null");
            return (Criteria) this;
        }

        public Criteria andStoppageNoIsNotNull() {
            addCriterion("stoppage_no is not null");
            return (Criteria) this;
        }

        public Criteria andStoppageNoEqualTo(String value) {
            addCriterion("stoppage_no =", value, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoNotEqualTo(String value) {
            addCriterion("stoppage_no <>", value, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoGreaterThan(String value) {
            addCriterion("stoppage_no >", value, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoGreaterThanOrEqualTo(String value) {
            addCriterion("stoppage_no >=", value, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoLessThan(String value) {
            addCriterion("stoppage_no <", value, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoLessThanOrEqualTo(String value) {
            addCriterion("stoppage_no <=", value, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoLike(String value) {
            addCriterion("stoppage_no like", value, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoNotLike(String value) {
            addCriterion("stoppage_no not like", value, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoIn(List<String> values) {
            addCriterion("stoppage_no in", values, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoNotIn(List<String> values) {
            addCriterion("stoppage_no not in", values, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoBetween(String value1, String value2) {
            addCriterion("stoppage_no between", value1, value2, "stoppageNo");
            return (Criteria) this;
        }

        public Criteria andStoppageNoNotBetween(String value1, String value2) {
            addCriterion("stoppage_no not between", value1, value2, "stoppageNo");
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

        public Criteria andPumpWarnIdIsNull() {
            addCriterion("pump_warn_id is null");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdIsNotNull() {
            addCriterion("pump_warn_id is not null");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdEqualTo(String value) {
            addCriterion("pump_warn_id =", value, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdNotEqualTo(String value) {
            addCriterion("pump_warn_id <>", value, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdGreaterThan(String value) {
            addCriterion("pump_warn_id >", value, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdGreaterThanOrEqualTo(String value) {
            addCriterion("pump_warn_id >=", value, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdLessThan(String value) {
            addCriterion("pump_warn_id <", value, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdLessThanOrEqualTo(String value) {
            addCriterion("pump_warn_id <=", value, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdLike(String value) {
            addCriterion("pump_warn_id like", value, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdNotLike(String value) {
            addCriterion("pump_warn_id not like", value, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdIn(List<String> values) {
            addCriterion("pump_warn_id in", values, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdNotIn(List<String> values) {
            addCriterion("pump_warn_id not in", values, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdBetween(String value1, String value2) {
            addCriterion("pump_warn_id between", value1, value2, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andPumpWarnIdNotBetween(String value1, String value2) {
            addCriterion("pump_warn_id not between", value1, value2, "pumpWarnId");
            return (Criteria) this;
        }

        public Criteria andDescriptIsNull() {
            addCriterion("descript is null");
            return (Criteria) this;
        }

        public Criteria andDescriptIsNotNull() {
            addCriterion("descript is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptEqualTo(String value) {
            addCriterion("descript =", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotEqualTo(String value) {
            addCriterion("descript <>", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptGreaterThan(String value) {
            addCriterion("descript >", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptGreaterThanOrEqualTo(String value) {
            addCriterion("descript >=", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLessThan(String value) {
            addCriterion("descript <", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLessThanOrEqualTo(String value) {
            addCriterion("descript <=", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptLike(String value) {
            addCriterion("descript like", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotLike(String value) {
            addCriterion("descript not like", value, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptIn(List<String> values) {
            addCriterion("descript in", values, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotIn(List<String> values) {
            addCriterion("descript not in", values, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptBetween(String value1, String value2) {
            addCriterion("descript between", value1, value2, "descript");
            return (Criteria) this;
        }

        public Criteria andDescriptNotBetween(String value1, String value2) {
            addCriterion("descript not between", value1, value2, "descript");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNull() {
            addCriterion("attach_id is null");
            return (Criteria) this;
        }

        public Criteria andAttachIdIsNotNull() {
            addCriterion("attach_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttachIdEqualTo(String value) {
            addCriterion("attach_id =", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotEqualTo(String value) {
            addCriterion("attach_id <>", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThan(String value) {
            addCriterion("attach_id >", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdGreaterThanOrEqualTo(String value) {
            addCriterion("attach_id >=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThan(String value) {
            addCriterion("attach_id <", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLessThanOrEqualTo(String value) {
            addCriterion("attach_id <=", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdLike(String value) {
            addCriterion("attach_id like", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotLike(String value) {
            addCriterion("attach_id not like", value, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdIn(List<String> values) {
            addCriterion("attach_id in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotIn(List<String> values) {
            addCriterion("attach_id not in", values, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdBetween(String value1, String value2) {
            addCriterion("attach_id between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andAttachIdNotBetween(String value1, String value2) {
            addCriterion("attach_id not between", value1, value2, "attachId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdIsNull() {
            addCriterion("originator_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdIsNotNull() {
            addCriterion("originator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdEqualTo(String value) {
            addCriterion("originator_id =", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdNotEqualTo(String value) {
            addCriterion("originator_id <>", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdGreaterThan(String value) {
            addCriterion("originator_id >", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("originator_id >=", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdLessThan(String value) {
            addCriterion("originator_id <", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdLessThanOrEqualTo(String value) {
            addCriterion("originator_id <=", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdLike(String value) {
            addCriterion("originator_id like", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdNotLike(String value) {
            addCriterion("originator_id not like", value, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdIn(List<String> values) {
            addCriterion("originator_id in", values, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdNotIn(List<String> values) {
            addCriterion("originator_id not in", values, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdBetween(String value1, String value2) {
            addCriterion("originator_id between", value1, value2, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOriginatorIdNotBetween(String value1, String value2) {
            addCriterion("originator_id not between", value1, value2, "originatorId");
            return (Criteria) this;
        }

        public Criteria andOccurTimeIsNull() {
            addCriterion("occur_time is null");
            return (Criteria) this;
        }

        public Criteria andOccurTimeIsNotNull() {
            addCriterion("occur_time is not null");
            return (Criteria) this;
        }

        public Criteria andOccurTimeEqualTo(String value) {
            addCriterion("occur_time =", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeNotEqualTo(String value) {
            addCriterion("occur_time <>", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeGreaterThan(String value) {
            addCriterion("occur_time >", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeGreaterThanOrEqualTo(String value) {
            addCriterion("occur_time >=", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeLessThan(String value) {
            addCriterion("occur_time <", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeLessThanOrEqualTo(String value) {
            addCriterion("occur_time <=", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeLike(String value) {
            addCriterion("occur_time like", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeNotLike(String value) {
            addCriterion("occur_time not like", value, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeIn(List<String> values) {
            addCriterion("occur_time in", values, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeNotIn(List<String> values) {
            addCriterion("occur_time not in", values, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeBetween(String value1, String value2) {
            addCriterion("occur_time between", value1, value2, "occurTime");
            return (Criteria) this;
        }

        public Criteria andOccurTimeNotBetween(String value1, String value2) {
            addCriterion("occur_time not between", value1, value2, "occurTime");
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

        public Criteria andHandleStatusIsNull() {
            addCriterion("handle_status is null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIsNotNull() {
            addCriterion("handle_status is not null");
            return (Criteria) this;
        }

        public Criteria andHandleStatusEqualTo(String value) {
            addCriterion("handle_status =", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotEqualTo(String value) {
            addCriterion("handle_status <>", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThan(String value) {
            addCriterion("handle_status >", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("handle_status >=", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThan(String value) {
            addCriterion("handle_status <", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLessThanOrEqualTo(String value) {
            addCriterion("handle_status <=", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusLike(String value) {
            addCriterion("handle_status like", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotLike(String value) {
            addCriterion("handle_status not like", value, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusIn(List<String> values) {
            addCriterion("handle_status in", values, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotIn(List<String> values) {
            addCriterion("handle_status not in", values, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusBetween(String value1, String value2) {
            addCriterion("handle_status between", value1, value2, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleStatusNotBetween(String value1, String value2) {
            addCriterion("handle_status not between", value1, value2, "handleStatus");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeIsNull() {
            addCriterion("handle_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeIsNotNull() {
            addCriterion("handle_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeEqualTo(Date value) {
            addCriterion("handle_modify_time =", value, "handleModifyTime");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeNotEqualTo(Date value) {
            addCriterion("handle_modify_time <>", value, "handleModifyTime");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeGreaterThan(Date value) {
            addCriterion("handle_modify_time >", value, "handleModifyTime");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("handle_modify_time >=", value, "handleModifyTime");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeLessThan(Date value) {
            addCriterion("handle_modify_time <", value, "handleModifyTime");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("handle_modify_time <=", value, "handleModifyTime");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeIn(List<Date> values) {
            addCriterion("handle_modify_time in", values, "handleModifyTime");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeNotIn(List<Date> values) {
            addCriterion("handle_modify_time not in", values, "handleModifyTime");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeBetween(Date value1, Date value2) {
            addCriterion("handle_modify_time between", value1, value2, "handleModifyTime");
            return (Criteria) this;
        }

        public Criteria andHandleModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("handle_modify_time not between", value1, value2, "handleModifyTime");
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