package com.oscar.bean;


import com.oscar.bean.page.Page;

import java.util.ArrayList;
import java.util.List;

public class AssignCustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public AssignCustomerExample() {
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

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
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

        public Criteria andAssignIdIsNull() {
            addCriterion("assignId is null");
            return (Criteria) this;
        }

        public Criteria andAssignIdIsNotNull() {
            addCriterion("assignId is not null");
            return (Criteria) this;
        }

        public Criteria andAssignIdEqualTo(Integer value) {
            addCriterion("assignId =", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotEqualTo(Integer value) {
            addCriterion("assignId <>", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdGreaterThan(Integer value) {
            addCriterion("assignId >", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("assignId >=", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdLessThan(Integer value) {
            addCriterion("assignId <", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdLessThanOrEqualTo(Integer value) {
            addCriterion("assignId <=", value, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdIn(List<Integer> values) {
            addCriterion("assignId in", values, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotIn(List<Integer> values) {
            addCriterion("assignId not in", values, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdBetween(Integer value1, Integer value2) {
            addCriterion("assignId between", value1, value2, "assignId");
            return (Criteria) this;
        }

        public Criteria andAssignIdNotBetween(Integer value1, Integer value2) {
            addCriterion("assignId not between", value1, value2, "assignId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdIsNull() {
            addCriterion("segmentId is null");
            return (Criteria) this;
        }

        public Criteria andSegmentIdIsNotNull() {
            addCriterion("segmentId is not null");
            return (Criteria) this;
        }

        public Criteria andSegmentIdEqualTo(String value) {
            addCriterion("segmentId =", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdNotEqualTo(String value) {
            addCriterion("segmentId <>", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdGreaterThan(String value) {
            addCriterion("segmentId >", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("segmentId >=", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdLessThan(String value) {
            addCriterion("segmentId <", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdLessThanOrEqualTo(String value) {
            addCriterion("segmentId <=", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdLike(String value) {
            addCriterion("segmentId like", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdNotLike(String value) {
            addCriterion("segmentId not like", value, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdIn(List<String> values) {
            addCriterion("segmentId in", values, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdNotIn(List<String> values) {
            addCriterion("segmentId not in", values, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdBetween(String value1, String value2) {
            addCriterion("segmentId between", value1, value2, "segmentId");
            return (Criteria) this;
        }

        public Criteria andSegmentIdNotBetween(String value1, String value2) {
            addCriterion("segmentId not between", value1, value2, "segmentId");
            return (Criteria) this;
        }

        public Criteria andChannel_typeIsNull() {
            addCriterion("channel_type is null");
            return (Criteria) this;
        }

        public Criteria andChannel_typeIsNotNull() {
            addCriterion("channel_type is not null");
            return (Criteria) this;
        }

        public Criteria andChannel_typeEqualTo(Integer value) {
            addCriterion("channel_type =", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeNotEqualTo(Integer value) {
            addCriterion("channel_type <>", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeGreaterThan(Integer value) {
            addCriterion("channel_type >", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_type >=", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeLessThan(Integer value) {
            addCriterion("channel_type <", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeLessThanOrEqualTo(Integer value) {
            addCriterion("channel_type <=", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeIn(List<Integer> values) {
            addCriterion("channel_type in", values, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeNotIn(List<Integer> values) {
            addCriterion("channel_type not in", values, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeBetween(Integer value1, Integer value2) {
            addCriterion("channel_type between", value1, value2, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_type not between", value1, value2, "channel_type");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIsNull() {
            addCriterion("advertiserId is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIsNotNull() {
            addCriterion("advertiserId is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdEqualTo(String value) {
            addCriterion("advertiserId =", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotEqualTo(String value) {
            addCriterion("advertiserId <>", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThan(String value) {
            addCriterion("advertiserId >", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThanOrEqualTo(String value) {
            addCriterion("advertiserId >=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThan(String value) {
            addCriterion("advertiserId <", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThanOrEqualTo(String value) {
            addCriterion("advertiserId <=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLike(String value) {
            addCriterion("advertiserId like", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotLike(String value) {
            addCriterion("advertiserId not like", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIn(List<String> values) {
            addCriterion("advertiserId in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotIn(List<String> values) {
            addCriterion("advertiserId not in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdBetween(String value1, String value2) {
            addCriterion("advertiserId between", value1, value2, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotBetween(String value1, String value2) {
            addCriterion("advertiserId not between", value1, value2, "advertiserId");
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