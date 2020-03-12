package com.yxb.cms.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxb.cms.architect.constant.BussinessCode;
import com.yxb.cms.architect.utils.BussinessMsgUtil;
import com.yxb.cms.dao.DepartmentMapper;
import com.yxb.cms.domain.bo.BussinessMsg;
import com.yxb.cms.domain.vo.Department;

@Service
public class DepartmentService {
	private Logger log = LogManager.getLogger(DepartmentService.class);
	@Autowired
	private DepartmentMapper departmentMapper;
	/**
     * 部门信息分页显示
     * @param resource
     * @return
     */
    public String selectDepartmentResultPageList(Department department){

        List<Department> resourceList = departmentMapper.selectDepartmentListByPage(department);

        Long count = departmentMapper.selectCount(department);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data", resourceList);

        return Json.toJson(map);
    }

    public  Department selectByPrimaryKey(Integer id){
        return departmentMapper.selectByPrimaryKey(id);
    }
    
    public List<Department> selectDepartmentList(Department department){
    	return departmentMapper.selectDepartmentList(department);
    }
    
    @Transactional
    public BussinessMsg saveOrUpdateDepartment(Department department, String loginName) throws Exception {
        log.info("保存部门开始");
        long start = System.currentTimeMillis();
        try {
            //验证角色名称唯一性
            Long checkName = departmentMapper.selectNameCheck(department.getName(),department.getId());
            if(checkName.intValue() > 0){
                return BussinessMsgUtil.returnCodeMessage(BussinessCode.ROLE_NAME_EXIST);
            }

            //保存角色信息
            if (null == department.getId()) {
            	department.setCreator(loginName);
            	department.setCreateTime(new Date());
                departmentMapper.insertSelective(department);
            } else {
                //更新角色
            	department.setModifier(loginName);
            	department.setModifierTime(new Date());
                departmentMapper.updateByPrimaryKeySelective(department);
            }
        } catch (Exception e) {
            log.error("保存部门方法内部错误", e.toString());
            throw e;
        } finally {
            log.info("保存部门信息结束,用时" + (System.currentTimeMillis() - start) + "毫秒");
        }
        return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
    }
    public  int deleteByPrimaryKey(Integer id){
        return departmentMapper.deleteByPrimaryKey(id);
    }
}
