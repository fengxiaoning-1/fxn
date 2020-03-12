package com.yxb.cms.domain.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserParkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserParkExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("UserId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("UserId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("UserId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("UserId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("UserId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("UserId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("UserId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("UserId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("UserId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("UserId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("UserId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("UserId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andTruenameIsNull() {
            addCriterion("TrueName is null");
            return (Criteria) this;
        }

        public Criteria andTruenameIsNotNull() {
            addCriterion("TrueName is not null");
            return (Criteria) this;
        }

        public Criteria andTruenameEqualTo(String value) {
            addCriterion("TrueName =", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotEqualTo(String value) {
            addCriterion("TrueName <>", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameGreaterThan(String value) {
            addCriterion("TrueName >", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameGreaterThanOrEqualTo(String value) {
            addCriterion("TrueName >=", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLessThan(String value) {
            addCriterion("TrueName <", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLessThanOrEqualTo(String value) {
            addCriterion("TrueName <=", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameLike(String value) {
            addCriterion("TrueName like", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotLike(String value) {
            addCriterion("TrueName not like", value, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameIn(List<String> values) {
            addCriterion("TrueName in", values, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotIn(List<String> values) {
            addCriterion("TrueName not in", values, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameBetween(String value1, String value2) {
            addCriterion("TrueName between", value1, value2, "truename");
            return (Criteria) this;
        }

        public Criteria andTruenameNotBetween(String value1, String value2) {
            addCriterion("TrueName not between", value1, value2, "truename");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("Phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("Phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("Phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("Phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("Phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("Phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("Phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("Phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("Phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("Phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("Phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("Phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("Phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andParkidIsNull() {
            addCriterion("ParkId is null");
            return (Criteria) this;
        }

        public Criteria andParkidIsNotNull() {
            addCriterion("ParkId is not null");
            return (Criteria) this;
        }

        public Criteria andParkidEqualTo(Integer value) {
            addCriterion("ParkId =", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidNotEqualTo(Integer value) {
            addCriterion("ParkId <>", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidGreaterThan(Integer value) {
            addCriterion("ParkId >", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ParkId >=", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidLessThan(Integer value) {
            addCriterion("ParkId <", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidLessThanOrEqualTo(Integer value) {
            addCriterion("ParkId <=", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidIn(List<Integer> values) {
            addCriterion("ParkId in", values, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidNotIn(List<Integer> values) {
            addCriterion("ParkId not in", values, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidBetween(Integer value1, Integer value2) {
            addCriterion("ParkId between", value1, value2, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidNotBetween(Integer value1, Integer value2) {
            addCriterion("ParkId not between", value1, value2, "parkid");
            return (Criteria) this;
        }

        public Criteria andParknameIsNull() {
            addCriterion("ParkName is null");
            return (Criteria) this;
        }

        public Criteria andParknameIsNotNull() {
            addCriterion("ParkName is not null");
            return (Criteria) this;
        }

        public Criteria andParknameEqualTo(String value) {
            addCriterion("ParkName =", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameNotEqualTo(String value) {
            addCriterion("ParkName <>", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameGreaterThan(String value) {
            addCriterion("ParkName >", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameGreaterThanOrEqualTo(String value) {
            addCriterion("ParkName >=", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameLessThan(String value) {
            addCriterion("ParkName <", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameLessThanOrEqualTo(String value) {
            addCriterion("ParkName <=", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameLike(String value) {
            addCriterion("ParkName like", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameNotLike(String value) {
            addCriterion("ParkName not like", value, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameIn(List<String> values) {
            addCriterion("ParkName in", values, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameNotIn(List<String> values) {
            addCriterion("ParkName not in", values, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameBetween(String value1, String value2) {
            addCriterion("ParkName between", value1, value2, "parkname");
            return (Criteria) this;
        }

        public Criteria andParknameNotBetween(String value1, String value2) {
            addCriterion("ParkName not between", value1, value2, "parkname");
            return (Criteria) this;
        }

        public Criteria andRolecodeIsNull() {
            addCriterion("RoleCode is null");
            return (Criteria) this;
        }

        public Criteria andRolecodeIsNotNull() {
            addCriterion("RoleCode is not null");
            return (Criteria) this;
        }

        public Criteria andRolecodeEqualTo(String value) {
            addCriterion("RoleCode =", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeNotEqualTo(String value) {
            addCriterion("RoleCode <>", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeGreaterThan(String value) {
            addCriterion("RoleCode >", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeGreaterThanOrEqualTo(String value) {
            addCriterion("RoleCode >=", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeLessThan(String value) {
            addCriterion("RoleCode <", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeLessThanOrEqualTo(String value) {
            addCriterion("RoleCode <=", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeLike(String value) {
            addCriterion("RoleCode like", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeNotLike(String value) {
            addCriterion("RoleCode not like", value, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeIn(List<String> values) {
            addCriterion("RoleCode in", values, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeNotIn(List<String> values) {
            addCriterion("RoleCode not in", values, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeBetween(String value1, String value2) {
            addCriterion("RoleCode between", value1, value2, "rolecode");
            return (Criteria) this;
        }

        public Criteria andRolecodeNotBetween(String value1, String value2) {
            addCriterion("RoleCode not between", value1, value2, "rolecode");
            return (Criteria) this;
        }

        public Criteria andIscheckIsNull() {
            addCriterion("IsCheck is null");
            return (Criteria) this;
        }

        public Criteria andIscheckIsNotNull() {
            addCriterion("IsCheck is not null");
            return (Criteria) this;
        }

        public Criteria andIscheckEqualTo(Integer value) {
            addCriterion("IsCheck =", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckNotEqualTo(Integer value) {
            addCriterion("IsCheck <>", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckGreaterThan(Integer value) {
            addCriterion("IsCheck >", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("IsCheck >=", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckLessThan(Integer value) {
            addCriterion("IsCheck <", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckLessThanOrEqualTo(Integer value) {
            addCriterion("IsCheck <=", value, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckIn(List<Integer> values) {
            addCriterion("IsCheck in", values, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckNotIn(List<Integer> values) {
            addCriterion("IsCheck not in", values, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckBetween(Integer value1, Integer value2) {
            addCriterion("IsCheck between", value1, value2, "ischeck");
            return (Criteria) this;
        }

        public Criteria andIscheckNotBetween(Integer value1, Integer value2) {
            addCriterion("IsCheck not between", value1, value2, "ischeck");
            return (Criteria) this;
        }

        public Criteria andPasscodeIsNull() {
            addCriterion("PassCode is null");
            return (Criteria) this;
        }

        public Criteria andPasscodeIsNotNull() {
            addCriterion("PassCode is not null");
            return (Criteria) this;
        }

        public Criteria andPasscodeEqualTo(String value) {
            addCriterion("PassCode =", value, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeNotEqualTo(String value) {
            addCriterion("PassCode <>", value, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeGreaterThan(String value) {
            addCriterion("PassCode >", value, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeGreaterThanOrEqualTo(String value) {
            addCriterion("PassCode >=", value, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeLessThan(String value) {
            addCriterion("PassCode <", value, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeLessThanOrEqualTo(String value) {
            addCriterion("PassCode <=", value, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeLike(String value) {
            addCriterion("PassCode like", value, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeNotLike(String value) {
            addCriterion("PassCode not like", value, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeIn(List<String> values) {
            addCriterion("PassCode in", values, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeNotIn(List<String> values) {
            addCriterion("PassCode not in", values, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeBetween(String value1, String value2) {
            addCriterion("PassCode between", value1, value2, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodeNotBetween(String value1, String value2) {
            addCriterion("PassCode not between", value1, value2, "passcode");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateIsNull() {
            addCriterion("PassCodeValidDate is null");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateIsNotNull() {
            addCriterion("PassCodeValidDate is not null");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateEqualTo(Date value) {
            addCriterionForJDBCDate("PassCodeValidDate =", value, "passcodevaliddate");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("PassCodeValidDate <>", value, "passcodevaliddate");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateGreaterThan(Date value) {
            addCriterionForJDBCDate("PassCodeValidDate >", value, "passcodevaliddate");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PassCodeValidDate >=", value, "passcodevaliddate");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateLessThan(Date value) {
            addCriterionForJDBCDate("PassCodeValidDate <", value, "passcodevaliddate");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PassCodeValidDate <=", value, "passcodevaliddate");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateIn(List<Date> values) {
            addCriterionForJDBCDate("PassCodeValidDate in", values, "passcodevaliddate");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("PassCodeValidDate not in", values, "passcodevaliddate");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PassCodeValidDate between", value1, value2, "passcodevaliddate");
            return (Criteria) this;
        }

        public Criteria andPasscodevaliddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PassCodeValidDate not between", value1, value2, "passcodevaliddate");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNull() {
            addCriterion("DeptName is null");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNotNull() {
            addCriterion("DeptName is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnameEqualTo(String value) {
            addCriterion("DeptName =", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotEqualTo(String value) {
            addCriterion("DeptName <>", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThan(String value) {
            addCriterion("DeptName >", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("DeptName >=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThan(String value) {
            addCriterion("DeptName <", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThanOrEqualTo(String value) {
            addCriterion("DeptName <=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLike(String value) {
            addCriterion("DeptName like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotLike(String value) {
            addCriterion("DeptName not like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameIn(List<String> values) {
            addCriterion("DeptName in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotIn(List<String> values) {
            addCriterion("DeptName not in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameBetween(String value1, String value2) {
            addCriterion("DeptName between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotBetween(String value1, String value2) {
            addCriterion("DeptName not between", value1, value2, "deptname");
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