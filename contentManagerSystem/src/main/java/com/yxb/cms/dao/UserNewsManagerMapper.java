package com.yxb.cms.dao;

import com.yxb.cms.domain.vo.UserNewsManagerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserNewsManagerMapper {


    List<UserNewsManagerEntity> userNewsManagerListByPage(UserNewsManagerEntity userNewsManagerEntity);

    Long userNewsManagerCount(UserNewsManagerEntity userNewsManagerEntity);
}
