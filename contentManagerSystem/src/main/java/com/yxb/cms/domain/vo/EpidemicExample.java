package com.yxb.cms.domain.vo;

import java.util.ArrayList;
import java.util.List;

public class EpidemicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EpidemicExample() {
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

        public Criteria andNearfieldtouchIsNull() {
            addCriterion("NearFieldTouch is null");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchIsNotNull() {
            addCriterion("NearFieldTouch is not null");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchEqualTo(String value) {
            addCriterion("NearFieldTouch =", value, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchNotEqualTo(String value) {
            addCriterion("NearFieldTouch <>", value, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchGreaterThan(String value) {
            addCriterion("NearFieldTouch >", value, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchGreaterThanOrEqualTo(String value) {
            addCriterion("NearFieldTouch >=", value, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchLessThan(String value) {
            addCriterion("NearFieldTouch <", value, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchLessThanOrEqualTo(String value) {
            addCriterion("NearFieldTouch <=", value, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchLike(String value) {
            addCriterion("NearFieldTouch like", value, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchNotLike(String value) {
            addCriterion("NearFieldTouch not like", value, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchIn(List<String> values) {
            addCriterion("NearFieldTouch in", values, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchNotIn(List<String> values) {
            addCriterion("NearFieldTouch not in", values, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchBetween(String value1, String value2) {
            addCriterion("NearFieldTouch between", value1, value2, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andNearfieldtouchNotBetween(String value1, String value2) {
            addCriterion("NearFieldTouch not between", value1, value2, "nearfieldtouch");
            return (Criteria) this;
        }

        public Criteria andComefromIsNull() {
            addCriterion("ComeFrom is null");
            return (Criteria) this;
        }

        public Criteria andComefromIsNotNull() {
            addCriterion("ComeFrom is not null");
            return (Criteria) this;
        }

        public Criteria andComefromEqualTo(String value) {
            addCriterion("ComeFrom =", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromNotEqualTo(String value) {
            addCriterion("ComeFrom <>", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromGreaterThan(String value) {
            addCriterion("ComeFrom >", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromGreaterThanOrEqualTo(String value) {
            addCriterion("ComeFrom >=", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromLessThan(String value) {
            addCriterion("ComeFrom <", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromLessThanOrEqualTo(String value) {
            addCriterion("ComeFrom <=", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromLike(String value) {
            addCriterion("ComeFrom like", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromNotLike(String value) {
            addCriterion("ComeFrom not like", value, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromIn(List<String> values) {
            addCriterion("ComeFrom in", values, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromNotIn(List<String> values) {
            addCriterion("ComeFrom not in", values, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromBetween(String value1, String value2) {
            addCriterion("ComeFrom between", value1, value2, "comefrom");
            return (Criteria) this;
        }

        public Criteria andComefromNotBetween(String value1, String value2) {
            addCriterion("ComeFrom not between", value1, value2, "comefrom");
            return (Criteria) this;
        }

        public Criteria andVehicleIsNull() {
            addCriterion("Vehicle is null");
            return (Criteria) this;
        }

        public Criteria andVehicleIsNotNull() {
            addCriterion("Vehicle is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleEqualTo(String value) {
            addCriterion("Vehicle =", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotEqualTo(String value) {
            addCriterion("Vehicle <>", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleGreaterThan(String value) {
            addCriterion("Vehicle >", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleGreaterThanOrEqualTo(String value) {
            addCriterion("Vehicle >=", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLessThan(String value) {
            addCriterion("Vehicle <", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLessThanOrEqualTo(String value) {
            addCriterion("Vehicle <=", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleLike(String value) {
            addCriterion("Vehicle like", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotLike(String value) {
            addCriterion("Vehicle not like", value, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleIn(List<String> values) {
            addCriterion("Vehicle in", values, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotIn(List<String> values) {
            addCriterion("Vehicle not in", values, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleBetween(String value1, String value2) {
            addCriterion("Vehicle between", value1, value2, "vehicle");
            return (Criteria) this;
        }

        public Criteria andVehicleNotBetween(String value1, String value2) {
            addCriterion("Vehicle not between", value1, value2, "vehicle");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressIsNull() {
            addCriterion("permanent_address is null");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressIsNotNull() {
            addCriterion("permanent_address is not null");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressEqualTo(String value) {
            addCriterion("permanent_address =", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressNotEqualTo(String value) {
            addCriterion("permanent_address <>", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressGreaterThan(String value) {
            addCriterion("permanent_address >", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressGreaterThanOrEqualTo(String value) {
            addCriterion("permanent_address >=", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressLessThan(String value) {
            addCriterion("permanent_address <", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressLessThanOrEqualTo(String value) {
            addCriterion("permanent_address <=", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressLike(String value) {
            addCriterion("permanent_address like", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressNotLike(String value) {
            addCriterion("permanent_address not like", value, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressIn(List<String> values) {
            addCriterion("permanent_address in", values, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressNotIn(List<String> values) {
            addCriterion("permanent_address not in", values, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressBetween(String value1, String value2) {
            addCriterion("permanent_address between", value1, value2, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andPermanentAddressNotBetween(String value1, String value2) {
            addCriterion("permanent_address not between", value1, value2, "permanentAddress");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andHealthIsNull() {
            addCriterion("health is null");
            return (Criteria) this;
        }

        public Criteria andHealthIsNotNull() {
            addCriterion("health is not null");
            return (Criteria) this;
        }

        public Criteria andHealthEqualTo(String value) {
            addCriterion("health =", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotEqualTo(String value) {
            addCriterion("health <>", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthGreaterThan(String value) {
            addCriterion("health >", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthGreaterThanOrEqualTo(String value) {
            addCriterion("health >=", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLessThan(String value) {
            addCriterion("health <", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLessThanOrEqualTo(String value) {
            addCriterion("health <=", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthLike(String value) {
            addCriterion("health like", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotLike(String value) {
            addCriterion("health not like", value, "health");
            return (Criteria) this;
        }

        public Criteria andHealthIn(List<String> values) {
            addCriterion("health in", values, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotIn(List<String> values) {
            addCriterion("health not in", values, "health");
            return (Criteria) this;
        }

        public Criteria andHealthBetween(String value1, String value2) {
            addCriterion("health between", value1, value2, "health");
            return (Criteria) this;
        }

        public Criteria andHealthNotBetween(String value1, String value2) {
            addCriterion("health not between", value1, value2, "health");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationIsNull() {
            addCriterion("current_location is null");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationIsNotNull() {
            addCriterion("current_location is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationEqualTo(String value) {
            addCriterion("current_location =", value, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationNotEqualTo(String value) {
            addCriterion("current_location <>", value, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationGreaterThan(String value) {
            addCriterion("current_location >", value, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationGreaterThanOrEqualTo(String value) {
            addCriterion("current_location >=", value, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationLessThan(String value) {
            addCriterion("current_location <", value, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationLessThanOrEqualTo(String value) {
            addCriterion("current_location <=", value, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationLike(String value) {
            addCriterion("current_location like", value, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationNotLike(String value) {
            addCriterion("current_location not like", value, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationIn(List<String> values) {
            addCriterion("current_location in", values, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationNotIn(List<String> values) {
            addCriterion("current_location not in", values, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationBetween(String value1, String value2) {
            addCriterion("current_location between", value1, value2, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andCurrentLocationNotBetween(String value1, String value2) {
            addCriterion("current_location not between", value1, value2, "currentLocation");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("duration like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("duration not like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<String> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<String> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andLeaveDateIsNull() {
            addCriterion("leave_date is null");
            return (Criteria) this;
        }

        public Criteria andLeaveDateIsNotNull() {
            addCriterion("leave_date is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveDateEqualTo(String value) {
            addCriterion("leave_date =", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateNotEqualTo(String value) {
            addCriterion("leave_date <>", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateGreaterThan(String value) {
            addCriterion("leave_date >", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateGreaterThanOrEqualTo(String value) {
            addCriterion("leave_date >=", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateLessThan(String value) {
            addCriterion("leave_date <", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateLessThanOrEqualTo(String value) {
            addCriterion("leave_date <=", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateLike(String value) {
            addCriterion("leave_date like", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateNotLike(String value) {
            addCriterion("leave_date not like", value, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateIn(List<String> values) {
            addCriterion("leave_date in", values, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateNotIn(List<String> values) {
            addCriterion("leave_date not in", values, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateBetween(String value1, String value2) {
            addCriterion("leave_date between", value1, value2, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDateNotBetween(String value1, String value2) {
            addCriterion("leave_date not between", value1, value2, "leaveDate");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideIsNull() {
            addCriterion("leave_destination_inside is null");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideIsNotNull() {
            addCriterion("leave_destination_inside is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideEqualTo(String value) {
            addCriterion("leave_destination_inside =", value, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideNotEqualTo(String value) {
            addCriterion("leave_destination_inside <>", value, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideGreaterThan(String value) {
            addCriterion("leave_destination_inside >", value, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideGreaterThanOrEqualTo(String value) {
            addCriterion("leave_destination_inside >=", value, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideLessThan(String value) {
            addCriterion("leave_destination_inside <", value, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideLessThanOrEqualTo(String value) {
            addCriterion("leave_destination_inside <=", value, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideLike(String value) {
            addCriterion("leave_destination_inside like", value, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideNotLike(String value) {
            addCriterion("leave_destination_inside not like", value, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideIn(List<String> values) {
            addCriterion("leave_destination_inside in", values, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideNotIn(List<String> values) {
            addCriterion("leave_destination_inside not in", values, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideBetween(String value1, String value2) {
            addCriterion("leave_destination_inside between", value1, value2, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationInsideNotBetween(String value1, String value2) {
            addCriterion("leave_destination_inside not between", value1, value2, "leaveDestinationInside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideIsNull() {
            addCriterion("leave_destination_outside is null");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideIsNotNull() {
            addCriterion("leave_destination_outside is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideEqualTo(String value) {
            addCriterion("leave_destination_outside =", value, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideNotEqualTo(String value) {
            addCriterion("leave_destination_outside <>", value, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideGreaterThan(String value) {
            addCriterion("leave_destination_outside >", value, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideGreaterThanOrEqualTo(String value) {
            addCriterion("leave_destination_outside >=", value, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideLessThan(String value) {
            addCriterion("leave_destination_outside <", value, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideLessThanOrEqualTo(String value) {
            addCriterion("leave_destination_outside <=", value, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideLike(String value) {
            addCriterion("leave_destination_outside like", value, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideNotLike(String value) {
            addCriterion("leave_destination_outside not like", value, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideIn(List<String> values) {
            addCriterion("leave_destination_outside in", values, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideNotIn(List<String> values) {
            addCriterion("leave_destination_outside not in", values, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideBetween(String value1, String value2) {
            addCriterion("leave_destination_outside between", value1, value2, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveDestinationOutsideNotBetween(String value1, String value2) {
            addCriterion("leave_destination_outside not between", value1, value2, "leaveDestinationOutside");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleIsNull() {
            addCriterion("leave_vehicle is null");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleIsNotNull() {
            addCriterion("leave_vehicle is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleEqualTo(String value) {
            addCriterion("leave_vehicle =", value, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleNotEqualTo(String value) {
            addCriterion("leave_vehicle <>", value, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleGreaterThan(String value) {
            addCriterion("leave_vehicle >", value, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleGreaterThanOrEqualTo(String value) {
            addCriterion("leave_vehicle >=", value, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleLessThan(String value) {
            addCriterion("leave_vehicle <", value, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleLessThanOrEqualTo(String value) {
            addCriterion("leave_vehicle <=", value, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleLike(String value) {
            addCriterion("leave_vehicle like", value, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleNotLike(String value) {
            addCriterion("leave_vehicle not like", value, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleIn(List<String> values) {
            addCriterion("leave_vehicle in", values, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleNotIn(List<String> values) {
            addCriterion("leave_vehicle not in", values, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleBetween(String value1, String value2) {
            addCriterion("leave_vehicle between", value1, value2, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andLeaveVehicleNotBetween(String value1, String value2) {
            addCriterion("leave_vehicle not between", value1, value2, "leaveVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNull() {
            addCriterion("return_date is null");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNotNull() {
            addCriterion("return_date is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDateEqualTo(String value) {
            addCriterion("return_date =", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotEqualTo(String value) {
            addCriterion("return_date <>", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThan(String value) {
            addCriterion("return_date >", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThanOrEqualTo(String value) {
            addCriterion("return_date >=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThan(String value) {
            addCriterion("return_date <", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThanOrEqualTo(String value) {
            addCriterion("return_date <=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLike(String value) {
            addCriterion("return_date like", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotLike(String value) {
            addCriterion("return_date not like", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIn(List<String> values) {
            addCriterion("return_date in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotIn(List<String> values) {
            addCriterion("return_date not in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateBetween(String value1, String value2) {
            addCriterion("return_date between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotBetween(String value1, String value2) {
            addCriterion("return_date not between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleIsNull() {
            addCriterion("return_vehicle is null");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleIsNotNull() {
            addCriterion("return_vehicle is not null");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleEqualTo(String value) {
            addCriterion("return_vehicle =", value, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleNotEqualTo(String value) {
            addCriterion("return_vehicle <>", value, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleGreaterThan(String value) {
            addCriterion("return_vehicle >", value, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleGreaterThanOrEqualTo(String value) {
            addCriterion("return_vehicle >=", value, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleLessThan(String value) {
            addCriterion("return_vehicle <", value, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleLessThanOrEqualTo(String value) {
            addCriterion("return_vehicle <=", value, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleLike(String value) {
            addCriterion("return_vehicle like", value, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleNotLike(String value) {
            addCriterion("return_vehicle not like", value, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleIn(List<String> values) {
            addCriterion("return_vehicle in", values, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleNotIn(List<String> values) {
            addCriterion("return_vehicle not in", values, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleBetween(String value1, String value2) {
            addCriterion("return_vehicle between", value1, value2, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andReturnVehicleNotBetween(String value1, String value2) {
            addCriterion("return_vehicle not between", value1, value2, "returnVehicle");
            return (Criteria) this;
        }

        public Criteria andContactSituationIsNull() {
            addCriterion("contact_situation is null");
            return (Criteria) this;
        }

        public Criteria andContactSituationIsNotNull() {
            addCriterion("contact_situation is not null");
            return (Criteria) this;
        }

        public Criteria andContactSituationEqualTo(String value) {
            addCriterion("contact_situation =", value, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationNotEqualTo(String value) {
            addCriterion("contact_situation <>", value, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationGreaterThan(String value) {
            addCriterion("contact_situation >", value, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationGreaterThanOrEqualTo(String value) {
            addCriterion("contact_situation >=", value, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationLessThan(String value) {
            addCriterion("contact_situation <", value, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationLessThanOrEqualTo(String value) {
            addCriterion("contact_situation <=", value, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationLike(String value) {
            addCriterion("contact_situation like", value, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationNotLike(String value) {
            addCriterion("contact_situation not like", value, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationIn(List<String> values) {
            addCriterion("contact_situation in", values, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationNotIn(List<String> values) {
            addCriterion("contact_situation not in", values, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationBetween(String value1, String value2) {
            addCriterion("contact_situation between", value1, value2, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andContactSituationNotBetween(String value1, String value2) {
            addCriterion("contact_situation not between", value1, value2, "contactSituation");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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