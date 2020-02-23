package com.yxb.cms.domain.vo;

import lombok.Data;

@Data
public class PassRecordEntity {

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




}
