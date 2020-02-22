package com.yxb.cms.dao;

import com.yxb.cms.domain.vo.AccessManagerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccessManagerMapper {


    List<AccessManagerEntity> accessManagerList();

    int accessManagerClubCount();
}
