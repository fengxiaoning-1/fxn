package com.yxb.cms.dao;

import com.yxb.cms.domain.vo.UserPark;
import com.yxb.cms.domain.vo.UserParkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserParkMapper {
    int countByExample(UserParkExample example);

    int deleteByExample(UserParkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPark record);

    int insertSelective(UserPark record);

    List<UserPark> selectByExample(UserParkExample example);

    UserPark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPark record, @Param("example") UserParkExample example);

    int updateByExample(@Param("record") UserPark record, @Param("example") UserParkExample example);

    int updateByPrimaryKeySelective(UserPark record);

    int updateByPrimaryKey(UserPark record);

	UserPark selectOneByExample(UserParkExample example);
}