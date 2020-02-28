package com.yxb.cms.domain.vo;
import com.yxb.cms.domain.dto.PageDto;
import lombok.Data;
import java.io.Serializable;

@Data
public class PassRecordEntity extends PageDto implements Serializable{

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
    private Integer ParkId;
    /**
     * 真实姓名
     */
    private String ParkName;
    /**
     * 工厂ID
     */
    private Integer DoorId;
    /**
     * 工厂名称
     */
    private String DoorName;
    /**
     *角色类型
     */
    private String SentryTrueName;
    /**
     *通行码
     */
    private String PassTrueName;

    /**
     * 同行时间
     */
    private String PassDate;

    /**
     * 体温
     */
    private String Temperature;

    /**
     *出行理由
     */
    private String Reason;

    /**
     *  出入状态：0:未进门，1:已进门
     */
    private Integer IsIn;

    /**
     *准许标记：0:未审核;1:通过;2:不通过
     */
    private Integer Admit;

    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 电话
     */
    private String PhoneNumber;
    /**
     * 所在单位
     */
    private String company;
    /**
     * 所在部门
     */
    private String department;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public Integer getDoorId() {
        return DoorId;
    }

    public void setDoorId(Integer doorId) {
        DoorId = doorId;
    }

    public String getDoorName() {
        return DoorName;
    }

    public void setDoorName(String doorName) {
        DoorName = doorName;
    }

    public String getSentryTrueName() {
        return SentryTrueName;
    }

    public void setSentryTrueName(String sentryTrueName) {
        SentryTrueName = sentryTrueName;
    }

    public String getPassTrueName() {
        return PassTrueName;
    }

    public void setPassTrueName(String passTrueName) {
        PassTrueName = passTrueName;
    }

    public String getPassDate() {
        return PassDate;
    }

    public void setPassDate(String passDate) {
        PassDate = passDate;
    }

    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        Temperature = temperature;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public Integer getIsIn() {
        return IsIn;
    }

    public void setIsIn(Integer isIn) {
        IsIn = isIn;
    }

    public Integer getAdmit() {
        return Admit;
    }

    public void setAdmit(Integer admit) {
        Admit = admit;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
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
        return "PassRecordEntity{" +
                "Id=" + Id +
                ", ParkId=" + ParkId +
                ", ParkName='" + ParkName + '\'' +
                ", DoorId=" + DoorId +
                ", DoorName='" + DoorName + '\'' +
                ", SentryTrueName='" + SentryTrueName + '\'' +
                ", PassTrueName='" + PassTrueName + '\'' +
                ", PassDate='" + PassDate + '\'' +
                ", Temperature='" + Temperature + '\'' +
                ", Reason='" + Reason + '\'' +
                ", IsIn=" + IsIn +
                ", Admit=" + Admit +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", company='" + company + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
