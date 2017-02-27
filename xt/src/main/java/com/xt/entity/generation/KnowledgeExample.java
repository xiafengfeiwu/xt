package com.xt.entity.generation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KnowledgeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowledgeExample() {
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

        public Criteria andKnowledgeIdIsNull() {
            addCriterion("knowledge_id is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIsNotNull() {
            addCriterion("knowledge_id is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdEqualTo(Long value) {
            addCriterion("knowledge_id =", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotEqualTo(Long value) {
            addCriterion("knowledge_id <>", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdGreaterThan(Long value) {
            addCriterion("knowledge_id >", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("knowledge_id >=", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLessThan(Long value) {
            addCriterion("knowledge_id <", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdLessThanOrEqualTo(Long value) {
            addCriterion("knowledge_id <=", value, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdIn(List<Long> values) {
            addCriterion("knowledge_id in", values, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotIn(List<Long> values) {
            addCriterion("knowledge_id not in", values, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdBetween(Long value1, Long value2) {
            addCriterion("knowledge_id between", value1, value2, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIdNotBetween(Long value1, Long value2) {
            addCriterion("knowledge_id not between", value1, value2, "knowledgeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdIsNull() {
            addCriterion("knowledge_type_id is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdIsNotNull() {
            addCriterion("knowledge_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdEqualTo(Long value) {
            addCriterion("knowledge_type_id =", value, "knowledgeTypeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdNotEqualTo(Long value) {
            addCriterion("knowledge_type_id <>", value, "knowledgeTypeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdGreaterThan(Long value) {
            addCriterion("knowledge_type_id >", value, "knowledgeTypeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("knowledge_type_id >=", value, "knowledgeTypeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdLessThan(Long value) {
            addCriterion("knowledge_type_id <", value, "knowledgeTypeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("knowledge_type_id <=", value, "knowledgeTypeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdIn(List<Long> values) {
            addCriterion("knowledge_type_id in", values, "knowledgeTypeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdNotIn(List<Long> values) {
            addCriterion("knowledge_type_id not in", values, "knowledgeTypeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdBetween(Long value1, Long value2) {
            addCriterion("knowledge_type_id between", value1, value2, "knowledgeTypeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("knowledge_type_id not between", value1, value2, "knowledgeTypeId");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleIsNull() {
            addCriterion("knowledge_title is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleIsNotNull() {
            addCriterion("knowledge_title is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleEqualTo(String value) {
            addCriterion("knowledge_title =", value, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleNotEqualTo(String value) {
            addCriterion("knowledge_title <>", value, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleGreaterThan(String value) {
            addCriterion("knowledge_title >", value, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge_title >=", value, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleLessThan(String value) {
            addCriterion("knowledge_title <", value, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleLessThanOrEqualTo(String value) {
            addCriterion("knowledge_title <=", value, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleLike(String value) {
            addCriterion("knowledge_title like", value, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleNotLike(String value) {
            addCriterion("knowledge_title not like", value, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleIn(List<String> values) {
            addCriterion("knowledge_title in", values, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleNotIn(List<String> values) {
            addCriterion("knowledge_title not in", values, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleBetween(String value1, String value2) {
            addCriterion("knowledge_title between", value1, value2, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTitleNotBetween(String value1, String value2) {
            addCriterion("knowledge_title not between", value1, value2, "knowledgeTitle");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentIsNull() {
            addCriterion("knowledge_content is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentIsNotNull() {
            addCriterion("knowledge_content is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentEqualTo(String value) {
            addCriterion("knowledge_content =", value, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentNotEqualTo(String value) {
            addCriterion("knowledge_content <>", value, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentGreaterThan(String value) {
            addCriterion("knowledge_content >", value, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge_content >=", value, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentLessThan(String value) {
            addCriterion("knowledge_content <", value, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentLessThanOrEqualTo(String value) {
            addCriterion("knowledge_content <=", value, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentLike(String value) {
            addCriterion("knowledge_content like", value, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentNotLike(String value) {
            addCriterion("knowledge_content not like", value, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentIn(List<String> values) {
            addCriterion("knowledge_content in", values, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentNotIn(List<String> values) {
            addCriterion("knowledge_content not in", values, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentBetween(String value1, String value2) {
            addCriterion("knowledge_content between", value1, value2, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andKnowledgeContentNotBetween(String value1, String value2) {
            addCriterion("knowledge_content not between", value1, value2, "knowledgeContent");
            return (Criteria) this;
        }

        public Criteria andUsefulCountIsNull() {
            addCriterion("useful_count is null");
            return (Criteria) this;
        }

        public Criteria andUsefulCountIsNotNull() {
            addCriterion("useful_count is not null");
            return (Criteria) this;
        }

        public Criteria andUsefulCountEqualTo(Integer value) {
            addCriterion("useful_count =", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountNotEqualTo(Integer value) {
            addCriterion("useful_count <>", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountGreaterThan(Integer value) {
            addCriterion("useful_count >", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("useful_count >=", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountLessThan(Integer value) {
            addCriterion("useful_count <", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountLessThanOrEqualTo(Integer value) {
            addCriterion("useful_count <=", value, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountIn(List<Integer> values) {
            addCriterion("useful_count in", values, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountNotIn(List<Integer> values) {
            addCriterion("useful_count not in", values, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountBetween(Integer value1, Integer value2) {
            addCriterion("useful_count between", value1, value2, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUsefulCountNotBetween(Integer value1, Integer value2) {
            addCriterion("useful_count not between", value1, value2, "usefulCount");
            return (Criteria) this;
        }

        public Criteria andUselessCountIsNull() {
            addCriterion("useless_count is null");
            return (Criteria) this;
        }

        public Criteria andUselessCountIsNotNull() {
            addCriterion("useless_count is not null");
            return (Criteria) this;
        }

        public Criteria andUselessCountEqualTo(Integer value) {
            addCriterion("useless_count =", value, "uselessCount");
            return (Criteria) this;
        }

        public Criteria andUselessCountNotEqualTo(Integer value) {
            addCriterion("useless_count <>", value, "uselessCount");
            return (Criteria) this;
        }

        public Criteria andUselessCountGreaterThan(Integer value) {
            addCriterion("useless_count >", value, "uselessCount");
            return (Criteria) this;
        }

        public Criteria andUselessCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("useless_count >=", value, "uselessCount");
            return (Criteria) this;
        }

        public Criteria andUselessCountLessThan(Integer value) {
            addCriterion("useless_count <", value, "uselessCount");
            return (Criteria) this;
        }

        public Criteria andUselessCountLessThanOrEqualTo(Integer value) {
            addCriterion("useless_count <=", value, "uselessCount");
            return (Criteria) this;
        }

        public Criteria andUselessCountIn(List<Integer> values) {
            addCriterion("useless_count in", values, "uselessCount");
            return (Criteria) this;
        }

        public Criteria andUselessCountNotIn(List<Integer> values) {
            addCriterion("useless_count not in", values, "uselessCount");
            return (Criteria) this;
        }

        public Criteria andUselessCountBetween(Integer value1, Integer value2) {
            addCriterion("useless_count between", value1, value2, "uselessCount");
            return (Criteria) this;
        }

        public Criteria andUselessCountNotBetween(Integer value1, Integer value2) {
            addCriterion("useless_count not between", value1, value2, "uselessCount");
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