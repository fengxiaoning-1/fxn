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
    private Integer IdCard;
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
    private String Country;
    private String Province;
    private String Language;
    private String PhoneNumber;
    private String City;
    private String DefaultRoleCode;
    private String HasEpidemic;
    private String SessionKey;

    private Integer DefaultParkId;

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

    public Integer getIdCard() {
        return IdCard;
    }

    public void setIdCard(Integer idCard) {
        IdCard = idCard;
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

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDefaultRoleCode() {
        return DefaultRoleCode;
    }

    public void setDefaultRoleCode(String defaultRoleCode) {
        DefaultRoleCode = defaultRoleCode;
    }

    public String getHasEpidemic() {
        return HasEpidemic;
    }

    public void setHasEpidemic(String hasEpidemic) {
        HasEpidemic = hasEpidemic;
    }

    public String getSessionKey() {
        return SessionKey;
    }

    public void setSessionKey(String sessionKey) {
        SessionKey = sessionKey;
    }

    public Integer getDefaultParkId() {
        return DefaultParkId;
    }

    public void setDefaultParkId(Integer defaultParkId) {
        DefaultParkId = defaultParkId;
    }


    @Override
    public String toString() {
        return "UserNewsManagerDto{" +
                "Id=" + Id +
                ", TrueName='" + TrueName + '\'' +
                ", IdCard=" + IdCard +
                ", NickName='" + NickName + '\'' +
                ", OpenId='" + OpenId + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Country='" + Country + '\'' +
                ", Province='" + Province + '\'' +
                ", Language='" + Language + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", City='" + City + '\'' +
                ", DefaultRoleCode='" + DefaultRoleCode + '\'' +
                ", HasEpidemic='" + HasEpidemic + '\'' +
                ", SessionKey='" + SessionKey + '\'' +
                ", DefaultParkId=" + DefaultParkId +
                '}';
    }
}
