package com.antony.service.mail.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cm3001Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public Cm3001Example() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSenderaddrIsNull() {
            addCriterion("SENDERADDR is null");
            return (Criteria) this;
        }

        public Criteria andSenderaddrIsNotNull() {
            addCriterion("SENDERADDR is not null");
            return (Criteria) this;
        }

        public Criteria andSenderaddrEqualTo(String value) {
            addCriterion("SENDERADDR =", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrNotEqualTo(String value) {
            addCriterion("SENDERADDR <>", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrGreaterThan(String value) {
            addCriterion("SENDERADDR >", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrGreaterThanOrEqualTo(String value) {
            addCriterion("SENDERADDR >=", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrLessThan(String value) {
            addCriterion("SENDERADDR <", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrLessThanOrEqualTo(String value) {
            addCriterion("SENDERADDR <=", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrLike(String value) {
            addCriterion("SENDERADDR like", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrNotLike(String value) {
            addCriterion("SENDERADDR not like", value, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrIn(List<String> values) {
            addCriterion("SENDERADDR in", values, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrNotIn(List<String> values) {
            addCriterion("SENDERADDR not in", values, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrBetween(String value1, String value2) {
            addCriterion("SENDERADDR between", value1, value2, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSenderaddrNotBetween(String value1, String value2) {
            addCriterion("SENDERADDR not between", value1, value2, "senderaddr");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNull() {
            addCriterion("SENDERNAME is null");
            return (Criteria) this;
        }

        public Criteria andSendernameIsNotNull() {
            addCriterion("SENDERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSendernameEqualTo(String value) {
            addCriterion("SENDERNAME =", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotEqualTo(String value) {
            addCriterion("SENDERNAME <>", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThan(String value) {
            addCriterion("SENDERNAME >", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameGreaterThanOrEqualTo(String value) {
            addCriterion("SENDERNAME >=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThan(String value) {
            addCriterion("SENDERNAME <", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLessThanOrEqualTo(String value) {
            addCriterion("SENDERNAME <=", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameLike(String value) {
            addCriterion("SENDERNAME like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotLike(String value) {
            addCriterion("SENDERNAME not like", value, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameIn(List<String> values) {
            addCriterion("SENDERNAME in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotIn(List<String> values) {
            addCriterion("SENDERNAME not in", values, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameBetween(String value1, String value2) {
            addCriterion("SENDERNAME between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andSendernameNotBetween(String value1, String value2) {
            addCriterion("SENDERNAME not between", value1, value2, "sendername");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrIsNull() {
            addCriterion("RECEIVERADDR is null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrIsNotNull() {
            addCriterion("RECEIVERADDR is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrEqualTo(String value) {
            addCriterion("RECEIVERADDR =", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrNotEqualTo(String value) {
            addCriterion("RECEIVERADDR <>", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrGreaterThan(String value) {
            addCriterion("RECEIVERADDR >", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIVERADDR >=", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrLessThan(String value) {
            addCriterion("RECEIVERADDR <", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrLessThanOrEqualTo(String value) {
            addCriterion("RECEIVERADDR <=", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrLike(String value) {
            addCriterion("RECEIVERADDR like", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrNotLike(String value) {
            addCriterion("RECEIVERADDR not like", value, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrIn(List<String> values) {
            addCriterion("RECEIVERADDR in", values, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrNotIn(List<String> values) {
            addCriterion("RECEIVERADDR not in", values, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrBetween(String value1, String value2) {
            addCriterion("RECEIVERADDR between", value1, value2, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andReceiveraddrNotBetween(String value1, String value2) {
            addCriterion("RECEIVERADDR not between", value1, value2, "receiveraddr");
            return (Criteria) this;
        }

        public Criteria andHitIsNull() {
            addCriterion("HIT is null");
            return (Criteria) this;
        }

        public Criteria andHitIsNotNull() {
            addCriterion("HIT is not null");
            return (Criteria) this;
        }

        public Criteria andHitEqualTo(Integer value) {
            addCriterion("HIT =", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitNotEqualTo(Integer value) {
            addCriterion("HIT <>", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitGreaterThan(Integer value) {
            addCriterion("HIT >", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitGreaterThanOrEqualTo(Integer value) {
            addCriterion("HIT >=", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitLessThan(Integer value) {
            addCriterion("HIT <", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitLessThanOrEqualTo(Integer value) {
            addCriterion("HIT <=", value, "hit");
            return (Criteria) this;
        }

        public Criteria andHitIn(List<Integer> values) {
            addCriterion("HIT in", values, "hit");
            return (Criteria) this;
        }

        public Criteria andHitNotIn(List<Integer> values) {
            addCriterion("HIT not in", values, "hit");
            return (Criteria) this;
        }

        public Criteria andHitBetween(Integer value1, Integer value2) {
            addCriterion("HIT between", value1, value2, "hit");
            return (Criteria) this;
        }

        public Criteria andHitNotBetween(Integer value1, Integer value2) {
            addCriterion("HIT not between", value1, value2, "hit");
            return (Criteria) this;
        }

        public Criteria andCcsIsNull() {
            addCriterion("CCS is null");
            return (Criteria) this;
        }

        public Criteria andCcsIsNotNull() {
            addCriterion("CCS is not null");
            return (Criteria) this;
        }

        public Criteria andCcsEqualTo(String value) {
            addCriterion("CCS =", value, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsNotEqualTo(String value) {
            addCriterion("CCS <>", value, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsGreaterThan(String value) {
            addCriterion("CCS >", value, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsGreaterThanOrEqualTo(String value) {
            addCriterion("CCS >=", value, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsLessThan(String value) {
            addCriterion("CCS <", value, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsLessThanOrEqualTo(String value) {
            addCriterion("CCS <=", value, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsLike(String value) {
            addCriterion("CCS like", value, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsNotLike(String value) {
            addCriterion("CCS not like", value, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsIn(List<String> values) {
            addCriterion("CCS in", values, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsNotIn(List<String> values) {
            addCriterion("CCS not in", values, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsBetween(String value1, String value2) {
            addCriterion("CCS between", value1, value2, "ccs");
            return (Criteria) this;
        }

        public Criteria andCcsNotBetween(String value1, String value2) {
            addCriterion("CCS not between", value1, value2, "ccs");
            return (Criteria) this;
        }

        public Criteria andBccsIsNull() {
            addCriterion("BCCS is null");
            return (Criteria) this;
        }

        public Criteria andBccsIsNotNull() {
            addCriterion("BCCS is not null");
            return (Criteria) this;
        }

        public Criteria andBccsEqualTo(String value) {
            addCriterion("BCCS =", value, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsNotEqualTo(String value) {
            addCriterion("BCCS <>", value, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsGreaterThan(String value) {
            addCriterion("BCCS >", value, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsGreaterThanOrEqualTo(String value) {
            addCriterion("BCCS >=", value, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsLessThan(String value) {
            addCriterion("BCCS <", value, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsLessThanOrEqualTo(String value) {
            addCriterion("BCCS <=", value, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsLike(String value) {
            addCriterion("BCCS like", value, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsNotLike(String value) {
            addCriterion("BCCS not like", value, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsIn(List<String> values) {
            addCriterion("BCCS in", values, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsNotIn(List<String> values) {
            addCriterion("BCCS not in", values, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsBetween(String value1, String value2) {
            addCriterion("BCCS between", value1, value2, "bccs");
            return (Criteria) this;
        }

        public Criteria andBccsNotBetween(String value1, String value2) {
            addCriterion("BCCS not between", value1, value2, "bccs");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("SUBJECT is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("SUBJECT is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("SUBJECT =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("SUBJECT <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("SUBJECT >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("SUBJECT <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("SUBJECT like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("SUBJECT not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("SUBJECT in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("SUBJECT not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("SUBJECT between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("SUBJECT not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSenddateIsNull() {
            addCriterion("SENDDATE is null");
            return (Criteria) this;
        }

        public Criteria andSenddateIsNotNull() {
            addCriterion("SENDDATE is not null");
            return (Criteria) this;
        }

        public Criteria andSenddateEqualTo(Date value) {
            addCriterion("SENDDATE =", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotEqualTo(Date value) {
            addCriterion("SENDDATE <>", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateGreaterThan(Date value) {
            addCriterion("SENDDATE >", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("SENDDATE >=", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateLessThan(Date value) {
            addCriterion("SENDDATE <", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateLessThanOrEqualTo(Date value) {
            addCriterion("SENDDATE <=", value, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateIn(List<Date> values) {
            addCriterion("SENDDATE in", values, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotIn(List<Date> values) {
            addCriterion("SENDDATE not in", values, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateBetween(Date value1, Date value2) {
            addCriterion("SENDDATE between", value1, value2, "senddate");
            return (Criteria) this;
        }

        public Criteria andSenddateNotBetween(Date value1, Date value2) {
            addCriterion("SENDDATE not between", value1, value2, "senddate");
            return (Criteria) this;
        }

        public Criteria andResendnoIsNull() {
            addCriterion("RESENDNO is null");
            return (Criteria) this;
        }

        public Criteria andResendnoIsNotNull() {
            addCriterion("RESENDNO is not null");
            return (Criteria) this;
        }

        public Criteria andResendnoEqualTo(String value) {
            addCriterion("RESENDNO =", value, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoNotEqualTo(String value) {
            addCriterion("RESENDNO <>", value, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoGreaterThan(String value) {
            addCriterion("RESENDNO >", value, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoGreaterThanOrEqualTo(String value) {
            addCriterion("RESENDNO >=", value, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoLessThan(String value) {
            addCriterion("RESENDNO <", value, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoLessThanOrEqualTo(String value) {
            addCriterion("RESENDNO <=", value, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoLike(String value) {
            addCriterion("RESENDNO like", value, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoNotLike(String value) {
            addCriterion("RESENDNO not like", value, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoIn(List<String> values) {
            addCriterion("RESENDNO in", values, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoNotIn(List<String> values) {
            addCriterion("RESENDNO not in", values, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoBetween(String value1, String value2) {
            addCriterion("RESENDNO between", value1, value2, "resendno");
            return (Criteria) this;
        }

        public Criteria andResendnoNotBetween(String value1, String value2) {
            addCriterion("RESENDNO not between", value1, value2, "resendno");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andActnoIsNull() {
            addCriterion("ACTNO is null");
            return (Criteria) this;
        }

        public Criteria andActnoIsNotNull() {
            addCriterion("ACTNO is not null");
            return (Criteria) this;
        }

        public Criteria andActnoEqualTo(Integer value) {
            addCriterion("ACTNO =", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotEqualTo(Integer value) {
            addCriterion("ACTNO <>", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoGreaterThan(Integer value) {
            addCriterion("ACTNO >", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ACTNO >=", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoLessThan(Integer value) {
            addCriterion("ACTNO <", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoLessThanOrEqualTo(Integer value) {
            addCriterion("ACTNO <=", value, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoIn(List<Integer> values) {
            addCriterion("ACTNO in", values, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotIn(List<Integer> values) {
            addCriterion("ACTNO not in", values, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoBetween(Integer value1, Integer value2) {
            addCriterion("ACTNO between", value1, value2, "actno");
            return (Criteria) this;
        }

        public Criteria andActnoNotBetween(Integer value1, Integer value2) {
            addCriterion("ACTNO not between", value1, value2, "actno");
            return (Criteria) this;
        }

        public Criteria andScheduletypeIsNull() {
            addCriterion("SCHEDULETYPE is null");
            return (Criteria) this;
        }

        public Criteria andScheduletypeIsNotNull() {
            addCriterion("SCHEDULETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andScheduletypeEqualTo(String value) {
            addCriterion("SCHEDULETYPE =", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeNotEqualTo(String value) {
            addCriterion("SCHEDULETYPE <>", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeGreaterThan(String value) {
            addCriterion("SCHEDULETYPE >", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeGreaterThanOrEqualTo(String value) {
            addCriterion("SCHEDULETYPE >=", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeLessThan(String value) {
            addCriterion("SCHEDULETYPE <", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeLessThanOrEqualTo(String value) {
            addCriterion("SCHEDULETYPE <=", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeLike(String value) {
            addCriterion("SCHEDULETYPE like", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeNotLike(String value) {
            addCriterion("SCHEDULETYPE not like", value, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeIn(List<String> values) {
            addCriterion("SCHEDULETYPE in", values, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeNotIn(List<String> values) {
            addCriterion("SCHEDULETYPE not in", values, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeBetween(String value1, String value2) {
            addCriterion("SCHEDULETYPE between", value1, value2, "scheduletype");
            return (Criteria) this;
        }

        public Criteria andScheduletypeNotBetween(String value1, String value2) {
            addCriterion("SCHEDULETYPE not between", value1, value2, "scheduletype");
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