package com.yxb.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yxb.cms.domain.vo.Factory;

@Mapper
public interface FactoryMapper {
	//根据主键删除记录
	int deleteByPrimaryKey(Integer id);
	//插入记录
	int insert(Factory record);
	//根据主键查询记录
	Factory selectByPrimaryKey(Integer id);
	//更新记录
	int updateByPrimaryKeySelective(Factory record);
	//统计记录总数
	Long selectCount(Factory record);
	//分页查询列表
	List<Factory> selectFactoryListByPage(Factory record);
	int insertSelective(Factory record);
	//
	Long selectNameCheck(@Param("name") String roleName,@Param("id") Integer id);
	//
	List<Factory> selectFactoryList(Factory record);

}
