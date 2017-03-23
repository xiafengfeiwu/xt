package com.xt.entity.generation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PumpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PumpExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(String value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(String value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(String value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(String value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLike(String value) {
            addCriterion("owner_id like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotLike(String value) {
            addCriterion("owner_id not like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<String> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<String> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(String value1, String value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(String value1, String value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andPumpNameIsNull() {
            addCriterion("pump_name is null");
            return (Criteria) this;
        }

        public Criteria andPumpNameIsNotNull() {
            addCriterion("pump_name is not null");
            return (Criteria) this;
        }

        public Criteria andPumpNameEqualTo(String value) {
            addCriterion("pump_name =", value, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameNotEqualTo(String value) {
            addCriterion("pump_name <>", value, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameGreaterThan(String value) {
            addCriterion("pump_name >", value, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameGreaterThanOrEqualTo(String value) {
            addCriterion("pump_name >=", value, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameLessThan(String value) {
            addCriterion("pump_name <", value, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameLessThanOrEqualTo(String value) {
            addCriterion("pump_name <=", value, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameLike(String value) {
            addCriterion("pump_name like", value, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameNotLike(String value) {
            addCriterion("pump_name not like", value, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameIn(List<String> values) {
            addCriterion("pump_name in", values, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameNotIn(List<String> values) {
            addCriterion("pump_name not in", values, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameBetween(String value1, String value2) {
            addCriterion("pump_name between", value1, value2, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpNameNotBetween(String value1, String value2) {
            addCriterion("pump_name not between", value1, value2, "pumpName");
            return (Criteria) this;
        }

        public Criteria andPumpCodeIsNull() {
            addCriterion("pump_code is null");
            return (Criteria) this;
        }

        public Criteria andPumpCodeIsNotNull() {
            addCriterion("pump_code is not null");
            return (Criteria) this;
        }

        public Criteria andPumpCodeEqualTo(String value) {
            addCriterion("pump_code =", value, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeNotEqualTo(String value) {
            addCriterion("pump_code <>", value, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeGreaterThan(String value) {
            addCriterion("pump_code >", value, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("pump_code >=", value, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeLessThan(String value) {
            addCriterion("pump_code <", value, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeLessThanOrEqualTo(String value) {
            addCriterion("pump_code <=", value, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeLike(String value) {
            addCriterion("pump_code like", value, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeNotLike(String value) {
            addCriterion("pump_code not like", value, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeIn(List<String> values) {
            addCriterion("pump_code in", values, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeNotIn(List<String> values) {
            addCriterion("pump_code not in", values, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeBetween(String value1, String value2) {
            addCriterion("pump_code between", value1, value2, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andPumpCodeNotBetween(String value1, String value2) {
            addCriterion("pump_code not between", value1, value2, "pumpCode");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andPumpSnIsNull() {
            addCriterion("pump_sn is null");
            return (Criteria) this;
        }

        public Criteria andPumpSnIsNotNull() {
            addCriterion("pump_sn is not null");
            return (Criteria) this;
        }

        public Criteria andPumpSnEqualTo(String value) {
            addCriterion("pump_sn =", value, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnNotEqualTo(String value) {
            addCriterion("pump_sn <>", value, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnGreaterThan(String value) {
            addCriterion("pump_sn >", value, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnGreaterThanOrEqualTo(String value) {
            addCriterion("pump_sn >=", value, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnLessThan(String value) {
            addCriterion("pump_sn <", value, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnLessThanOrEqualTo(String value) {
            addCriterion("pump_sn <=", value, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnLike(String value) {
            addCriterion("pump_sn like", value, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnNotLike(String value) {
            addCriterion("pump_sn not like", value, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnIn(List<String> values) {
            addCriterion("pump_sn in", values, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnNotIn(List<String> values) {
            addCriterion("pump_sn not in", values, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnBetween(String value1, String value2) {
            addCriterion("pump_sn between", value1, value2, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andPumpSnNotBetween(String value1, String value2) {
            addCriterion("pump_sn not between", value1, value2, "pumpSn");
            return (Criteria) this;
        }

        public Criteria andInstallDateIsNull() {
            addCriterion("install_date is null");
            return (Criteria) this;
        }

        public Criteria andInstallDateIsNotNull() {
            addCriterion("install_date is not null");
            return (Criteria) this;
        }

        public Criteria andInstallDateEqualTo(Date value) {
            addCriterionForJDBCDate("install_date =", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("install_date <>", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateGreaterThan(Date value) {
            addCriterionForJDBCDate("install_date >", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("install_date >=", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateLessThan(Date value) {
            addCriterionForJDBCDate("install_date <", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("install_date <=", value, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateIn(List<Date> values) {
            addCriterionForJDBCDate("install_date in", values, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("install_date not in", values, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("install_date between", value1, value2, "installDate");
            return (Criteria) this;
        }

        public Criteria andInstallDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("install_date not between", value1, value2, "installDate");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeIsNull() {
            addCriterion("area_longitude is null");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeIsNotNull() {
            addCriterion("area_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeEqualTo(String value) {
            addCriterion("area_longitude =", value, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeNotEqualTo(String value) {
            addCriterion("area_longitude <>", value, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeGreaterThan(String value) {
            addCriterion("area_longitude >", value, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("area_longitude >=", value, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeLessThan(String value) {
            addCriterion("area_longitude <", value, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeLessThanOrEqualTo(String value) {
            addCriterion("area_longitude <=", value, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeLike(String value) {
            addCriterion("area_longitude like", value, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeNotLike(String value) {
            addCriterion("area_longitude not like", value, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeIn(List<String> values) {
            addCriterion("area_longitude in", values, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeNotIn(List<String> values) {
            addCriterion("area_longitude not in", values, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeBetween(String value1, String value2) {
            addCriterion("area_longitude between", value1, value2, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLongitudeNotBetween(String value1, String value2) {
            addCriterion("area_longitude not between", value1, value2, "areaLongitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeIsNull() {
            addCriterion("area_latitude is null");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeIsNotNull() {
            addCriterion("area_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeEqualTo(String value) {
            addCriterion("area_latitude =", value, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeNotEqualTo(String value) {
            addCriterion("area_latitude <>", value, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeGreaterThan(String value) {
            addCriterion("area_latitude >", value, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("area_latitude >=", value, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeLessThan(String value) {
            addCriterion("area_latitude <", value, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeLessThanOrEqualTo(String value) {
            addCriterion("area_latitude <=", value, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeLike(String value) {
            addCriterion("area_latitude like", value, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeNotLike(String value) {
            addCriterion("area_latitude not like", value, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeIn(List<String> values) {
            addCriterion("area_latitude in", values, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeNotIn(List<String> values) {
            addCriterion("area_latitude not in", values, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeBetween(String value1, String value2) {
            addCriterion("area_latitude between", value1, value2, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andAreaLatitudeNotBetween(String value1, String value2) {
            addCriterion("area_latitude not between", value1, value2, "areaLatitude");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andPumpPictureIsNull() {
            addCriterion("pump_picture is null");
            return (Criteria) this;
        }

        public Criteria andPumpPictureIsNotNull() {
            addCriterion("pump_picture is not null");
            return (Criteria) this;
        }

        public Criteria andPumpPictureEqualTo(String value) {
            addCriterion("pump_picture =", value, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureNotEqualTo(String value) {
            addCriterion("pump_picture <>", value, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureGreaterThan(String value) {
            addCriterion("pump_picture >", value, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureGreaterThanOrEqualTo(String value) {
            addCriterion("pump_picture >=", value, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureLessThan(String value) {
            addCriterion("pump_picture <", value, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureLessThanOrEqualTo(String value) {
            addCriterion("pump_picture <=", value, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureLike(String value) {
            addCriterion("pump_picture like", value, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureNotLike(String value) {
            addCriterion("pump_picture not like", value, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureIn(List<String> values) {
            addCriterion("pump_picture in", values, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureNotIn(List<String> values) {
            addCriterion("pump_picture not in", values, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureBetween(String value1, String value2) {
            addCriterion("pump_picture between", value1, value2, "pumpPicture");
            return (Criteria) this;
        }

        public Criteria andPumpPictureNotBetween(String value1, String value2) {
            addCriterion("pump_picture not between", value1, value2, "pumpPicture");
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