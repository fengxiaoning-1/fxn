package com.yxb.cms.dao;

import com.yxb.cms.domain.vo.PassRecordEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PassRecordMapper {


    List<PassRecordEntity> passRecordList();

    int passRecordCount();
}
