package com.xt.entity.generation;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowledgeTypeExample() {
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

        public Criteria andKnowledgeTypeNameIsNull() {
            addCriterion("knowledge_type_name is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameIsNotNull() {
            addCriterion("knowledge_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameEqualTo(String value) {
            addCriterion("knowledge_type_name =", value, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameNotEqualTo(String value) {
            addCriterion("knowledge_type_name <>", value, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameGreaterThan(String value) {
            addCriterion("knowledge_type_name >", value, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge_type_name >=", value, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameLessThan(String value) {
            addCriterion("knowledge_type_name <", value, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameLessThanOrEqualTo(String value) {
            addCriterion("knowledge_type_name <=", value, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameLike(String value) {
            addCriterion("knowledge_type_name like", value, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameNotLike(String value) {
            addCriterion("knowledge_type_name not like", value, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameIn(List<String> values) {
            addCriterion("knowledge_type_name in", values, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameNotIn(List<String> values) {
            addCriterion("knowledge_type_name not in", values, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameBetween(String value1, String value2) {
            addCriterion("knowledge_type_name between", value1, value2, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andKnowledgeTypeNameNotBetween(String value1, String value2) {
            addCriterion("knowledge_type_name not between", value1, value2, "knowledgeTypeName");
            return (Criteria) this;
        }

        public Criteria andSystemItemIsNull() {
            addCriterion("system_item is null");
            return (Criteria) this;
        }

        public Criteria andSystemItemIsNotNull() {
            addCriterion("system_item is not null");
            return (Criteria) this;
        }

        public Criteria andSystemItemEqualTo(Boolean value) {
            addCriterion("system_item =", value, "systemItem");
            return (Criteria) this;
        }

        public Criteria andSystemItemNotEqualTo(Boolean value) {
            addCriterion("system_item <>", value, "systemItem");
            return (Criteria) this;
        }

        public Criteria andSystemItemGreaterThan(Boolean value) {
            addCriterion("system_item >", value, "systemItem");
            return (Criteria) this;
        }

        public Criteria andSystemItemGreaterThanOrEqualTo(Boolean value) {
            addCriterion("system_item >=", value, "systemItem");
            return (Criteria) this;
        }

        public Criteria andSystemItemLessThan(Boolean value) {
            addCriterion("system_item <", value, "systemItem");
            return (Criteria) this;
        }

        public Criteria andSystemItemLessThanOrEqualTo(Boolean value) {
            addCriterion("system_item <=", value, "systemItem");
            return (Criteria) this;
        }

        public Criteria andSystemItemIn(List<Boolean> values) {
            addCriterion("system_item in", values, "systemItem");
            return (Criteria) this;
        }

        public Criteria andSystemItemNotIn(List<Boolean> values) {
            addCriterion("system_item not in", values, "systemItem");
            return (Criteria) this;
        }

        public Criteria andSystemItemBetween(Boolean value1, Boolean value2) {
            addCriterion("system_item between", value1, value2, "systemItem");
            return (Criteria) this;
        }

        public Criteria andSystemItemNotBetween(Boolean value1, Boolean value2) {
            addCriterion("system_item not between", value1, value2, "systemItem");
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