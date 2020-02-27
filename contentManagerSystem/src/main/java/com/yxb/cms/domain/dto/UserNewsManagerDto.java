package com.yxb.cms.domain.dto;

import lombok.Data;

@Data
public class UserNewsManagerDto {


    private Integer Id;

    /**
     * 真实姓名
     */
    private String TrueName;
    /**
     *
     */
    private String NickName;
    /**
     *
     */
    private String OpenId;

    /**
     * 用户性别. 0：未知；1：男性；2：女性。
     */
    private String Gender;

    private String ParkName;
    private String company;



    private String department;
    private String idCard;
    private String phoneNumber;
    private String permanentAddress;
    private String address;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTrueName() {
        return TrueName;
    }

    public void setTrueName(String trueName) {
        TrueName = trueName;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getParkName() {
        return ParkName;
    }

    public void setParkName(String parkName) {
        ParkName = parkName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "UserNewsManagerDto{" +
                "Id=" + Id +
                ", TrueName='" + TrueName + '\'' +
                ", NickName='" + NickName + '\'' +
                ", OpenId='" + OpenId + '\'' +
                ", Gender='" + Gender + '\'' +
                ", ParkName='" + ParkName + '\'' +
                ", company='" + company + '\'' +
                ", department='" + department + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
