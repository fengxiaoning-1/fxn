package com.yxb.cms.dao;

import com.yxb.cms.domain.vo.PassRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import com.yxb.cms.domain.vo.PassRecord;

import java.util.List;

@Mapper
public interface PassRecordMapper {


    List<PassRecordEntity> selectPassRecordListByPage(PassRecordEntity passRecordEntity);

    Long passRecordCount(PassRecordEntity passRecordEntity);
    /**
     * 查询出入List
     * @param PassRecord 出入实体
     * @return
     */
    List<PassRecord>selectPassRecordList(PassRecord passRecord);
}
