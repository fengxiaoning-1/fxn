package com.yxb.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yxb.cms.domain.vo.Department;

@Mapper
public interface DepartmentMapper {
	//根据主键删除记录
	int deleteByPrimaryKey(Integer id);
	//插入记录
	int insert(Department record);
	//根据主键查询记录
	Department selectByPrimaryKey(Integer id);
	//根据主键更新记录
	int updateByPrimaryKeySelective(Department record);
	//统计记录总数
	Long selectCount(Department record);
	//分页查询列表
	List<Department> selectDepartmentListByPage(Department record);
	//
	int insertSelective(Department record);
	//
    Long selectNameCheck(@Param("name") String roleName,@Param("id") Integer id);
    //
    List<Department> selectDepartmentList(Department record);

}
