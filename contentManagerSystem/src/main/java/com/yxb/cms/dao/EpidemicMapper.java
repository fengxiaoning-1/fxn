package com.yxb.cms.dao;

import com.yxb.cms.domain.vo.Epidemic;
import com.yxb.cms.domain.vo.EpidemicExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EpidemicMapper {
    int countByExample(EpidemicExample example);

    int deleteByExample(EpidemicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Epidemic record);

    int insertSelective(Epidemic record);

    List<Epidemic> selectByExample(EpidemicExample example);
    
    Epidemic selectByPrimaryKey(Integer id);
    
    Epidemic selectByIdCard(String idCard);

    int updateByExampleSelective(@Param("record") Epidemic record, @Param("example") EpidemicExample example);

    int updateByExample(@Param("record") Epidemic record, @Param("example") EpidemicExample example);

    int updateByPrimaryKeySelective(Epidemic record);

    int updateByPrimaryKey(Epidemic record);
}