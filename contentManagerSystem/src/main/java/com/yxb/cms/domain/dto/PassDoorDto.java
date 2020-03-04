package com.yxb.cms.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PassDoorDto extends PageDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer Id;
    /**
     * 工厂ID
     */
    private Integer parkId;
    /**
     * 工厂名称
     */
    private String Name;
    /**
     * 大门名称
     */
    private String DoorName;
    /**
     * 所在地址
     */
    private String Address;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDoorName() {
        return DoorName;
    }

    public void setDoorName(String doorName) {
        DoorName = doorName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }
}
