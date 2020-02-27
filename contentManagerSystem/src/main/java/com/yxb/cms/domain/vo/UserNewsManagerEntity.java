package com.yxb.cms.domain.vo;

import com.yxb.cms.domain.dto.PageDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserNewsManagerEntity extends PageDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    private Integer Id;

    /**
     * 真实姓名
     */
    private String TrueName;
    /**
     * 工厂名称
     */
    private String NickName;
    /**
     *角色类型
     */
    private String OpenId;

    private String ParkName;
    private String company;
    private String department;
    private String idCard;
    private String phoneNumber;
    private String permanentAddress;
    private String address;









}
