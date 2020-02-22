package com.yxb.cms.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class AccessManagerEntity {

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
}
