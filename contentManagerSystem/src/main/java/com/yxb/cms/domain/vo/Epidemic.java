package com.yxb.cms.domain.vo;

import java.io.Serializable;

import com.github.pagehelper.PageInfo;

public class Epidemic implements Serializable{
    private Integer id;

    private Integer userid;

    private String nearfieldtouch;

    private String comefrom;

    private String vehicle;

    private String company;

    private String department;

    private String name;

    private String idCard;

    private String permanentAddress;

    private String address;

    private String phoneNumber;

    private String category;

    private String type;

    private String health;

    private String currentLocation;

    private String duration;

    private String leaveDate;

    private String leaveDestinationInside;

    private String leaveDestinationOutside;

    private String leaveVehicle;

    private String returnDate;

    private String returnVehicle;

    private String contactSituation;

    private String sign;

    private String remarks;

    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNearfieldtouch() {
        return nearfieldtouch;
    }

    public void setNearfieldtouch(String nearfieldtouch) {
        this.nearfieldtouch = nearfieldtouch == null ? null : nearfieldtouch.trim();
    }

    public String getComefrom() {
        return comefrom;
    }

    public void setComefrom(String comefrom) {
        this.comefrom = comefrom == null ? null : comefrom.trim();
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle == null ? null : vehicle.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress == null ? null : permanentAddress.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health == null ? null : health.trim();
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation == null ? null : currentLocation.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate == null ? null : leaveDate.trim();
    }

    public String getLeaveDestinationInside() {
        return leaveDestinationInside;
    }

    public void setLeaveDestinationInside(String leaveDestinationInside) {
        this.leaveDestinationInside = leaveDestinationInside == null ? null : leaveDestinationInside.trim();
    }

    public String getLeaveDestinationOutside() {
        return leaveDestinationOutside;
    }

    public void setLeaveDestinationOutside(String leaveDestinationOutside) {
        this.leaveDestinationOutside = leaveDestinationOutside == null ? null : leaveDestinationOutside.trim();
    }

    public String getLeaveVehicle() {
        return leaveVehicle;
    }

    public void setLeaveVehicle(String leaveVehicle) {
        this.leaveVehicle = leaveVehicle == null ? null : leaveVehicle.trim();
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate == null ? null : returnDate.trim();
    }

    public String getReturnVehicle() {
        return returnVehicle;
    }

    public void setReturnVehicle(String returnVehicle) {
        this.returnVehicle = returnVehicle == null ? null : returnVehicle.trim();
    }

    public String getContactSituation() {
        return contactSituation;
    }

    public void setContactSituation(String contactSituation) {
        this.contactSituation = contactSituation == null ? null : contactSituation.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}