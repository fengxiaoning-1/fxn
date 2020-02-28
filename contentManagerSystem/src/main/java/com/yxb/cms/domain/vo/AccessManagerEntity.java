package com.yxb.cms.domain.vo;

import com.yxb.cms.domain.dto.PageDto;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AccessManagerEntity extends PageDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    /**
     * 编号
     */
    private Integer Id;
    /**
     *用户编号
     */
    private Integer UserId;
    /**
     * 真实姓名
     */
    private String TrueName;
    /**
     * 工厂ID
     */
    private Integer ParkId;
    /**
     * 工厂名称
     */
    private String ParkName;
    /**
     *角色类型
     */
    private String RoleCode;
    /**
     * 是否检查
     */
    private Integer IsCheck;
    /**
     *通行码
     */
    private String PassCode;

    /**
     * PassCodeValidDate
     */
    private String PassCodeValidDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getTrueName() {
        return TrueName;
    }

    public void setTrueName(String trueName) {
        TrueName = trueName;
    }

    public Integer getParkId() {
        return ParkId;
    }

    public void setParkId(Integer parkId) {
        ParkId = parkId;
    }

    public String getParkName() {
        return ParkName;
    }

    public void setParkName(String parkName) {
        ParkName = parkName;
    }

    public String getRoleCode() {
        return RoleCode;
    }

    public void setRoleCode(String roleCode) {
        RoleCode = roleCode;
    }

    public Integer getIsCheck() {
        return IsCheck;
    }

    public void setIsCheck(Integer isCheck) {
        IsCheck = isCheck;
    }

    public String getPassCode() {
        return PassCode;
    }

    public void setPassCode(String passCode) {
        PassCode = passCode;
    }

    public String getPassCodeValidDate() {
        return PassCodeValidDate;
    }

    public void setPassCodeValidDate(String passCodeValidDate) {
        PassCodeValidDate = passCodeValidDate;
    }

    @Override
    public String toString() {
        return "AccessManagerEntity{" +
                "Id=" + Id +
                ", UserId=" + UserId +
                ", TrueName='" + TrueName + '\'' +
                ", ParkId=" + ParkId +
                ", ParkName='" + ParkName + '\'' +
                ", RoleCode='" + RoleCode + '\'' +
                ", IsCheck=" + IsCheck +
                ", PassCode='" + PassCode + '\'' +
                ", PassCodeValidDate='" + PassCodeValidDate + '\'' +
                '}';
    }
}
