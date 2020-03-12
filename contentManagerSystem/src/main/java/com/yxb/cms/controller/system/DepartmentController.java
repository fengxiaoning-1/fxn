package com.yxb.cms.controller.system;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxb.cms.architect.annotation.SystemControllerLog;
import com.yxb.cms.architect.constant.BussinessCode;
import com.yxb.cms.architect.utils.BussinessMsgUtil;
import com.yxb.cms.controller.BasicController;
import com.yxb.cms.domain.bo.BussinessMsg;
import com.yxb.cms.domain.vo.Department;
import com.yxb.cms.domain.vo.Factory;
import com.yxb.cms.service.impl.DepartmentService;
import com.yxb.cms.service.impl.FactoryService;

@Controller
@RequestMapping("department")
public class DepartmentController extends BasicController{
	private Logger log = LogManager.getLogger(DepartmentService.class);
	@Autowired
    private DepartmentService departmentService;
	@Autowired
    private FactoryService factoryService;
	/**
     *跳转到部门列表页面
     * @return
     */
    @RequestMapping("/department_list.do")
    public String todepartmentListPage() {
        return "system/department_list";
    }
    /**
     * 加载部门列表List
     * @param resource
     * @return
     */
    @RequestMapping("/ajax_department_list.do")
    @ResponseBody
    public String ajaxDepartmentList(Department department){
        return departmentService.selectDepartmentResultPageList(department);
    }
    /**
     * 跳转到部门新增页面
     * @return
     */
    @RequestMapping("/department_add.do")
    public String toDepartmentAddPage(Model model) {
    	List<Factory> fList = factoryService.selectFactoryList(null);
    	model.addAttribute("fList", fList);
    	model.addAttribute("department", new Department());
        //新增页面标识
        model.addAttribute("pageFlag", "addPage");
        return "system/department_add";
    }

    /**
     * 跳转到部门修改页面
     * @param id 部门id
     * @return
     */
    @RequestMapping("/department_update.do")
    public String departmentUpdatePage(Model model,Integer id){
    	List<Factory> fList = factoryService.selectFactoryList(null);
    	model.addAttribute("fList", fList);
    	Department department = departmentService.selectByPrimaryKey(id);
        //修改页面标识
        model.addAttribute("pageFlag", "updatePage");
        model.addAttribute("department", department);
        return "system/department_edit";
    }
    /**
     * 保存部门信息
     * @param Department 部门实体
     * @return
     */
    @RequestMapping("/ajax_save_department.do")
    @ResponseBody
    @SystemControllerLog(description="保存部门信息")
    public BussinessMsg ajaxSaveDepartment(Department department){
        try {
            return departmentService.saveOrUpdateDepartment(department, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("保存部门信息方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.USER_SAVE_ERROR);
        }
    }
    @RequestMapping("/ajax_department_parent_menu.do")
    @ResponseBody
    @SystemControllerLog(description="保存部门信息")
    public String ajax_department_parent_menu(Department department){
        return Json.toJson(departmentService.selectDepartmentList(department));
    } 
    
    @RequestMapping("/ajax_delete_department.do")
    @ResponseBody
    @SystemControllerLog(description="删除部门信息")
    public BussinessMsg ajaxDeleteDepartment(int id){
    	try {
    		departmentService.deleteByPrimaryKey(id);
    	}catch (Exception e) {
            log.error("保存部门信息方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.DEPARTMENT_DELETE_ERROR);
    	}
    	return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
    }
    
    
}
