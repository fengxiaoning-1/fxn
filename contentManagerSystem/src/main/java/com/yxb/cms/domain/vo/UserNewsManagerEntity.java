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
     * 工厂ID
     */
    private Integer IdCard;
    /**
     * 工厂名称
     */
    private String NickName;
    /**
     *角色类型
     */
    private String OpenId;

    private Integer Gender;
    private String Country;
    private String Province;
    private String Language;
    private String PhoneNumber;
    private String City;
    private String DefaultRoleCode;
    private String HasEpidemic;
    private String SessionKey;
    private String AvatarUrl;

    private Integer DefaultParkId;









}
