package com.yxb.cms.dao;

import com.yxb.cms.domain.vo.ClubEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClubMapper {
    List<ClubEntity> queryClubList();

    int queryClubCount();
}
