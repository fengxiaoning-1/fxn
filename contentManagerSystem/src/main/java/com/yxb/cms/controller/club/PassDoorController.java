package com.yxb.cms.controller.club;

import com.yxb.cms.architect.annotation.SystemControllerLog;
import com.yxb.cms.architect.constant.BussinessCode;
import com.yxb.cms.architect.utils.BussinessMsgUtil;
import com.yxb.cms.architect.utils.CommonHelper;
import com.yxb.cms.architect.utils.DateUtil;
import com.yxb.cms.domain.bo.BussinessMsg;
import com.yxb.cms.domain.bo.ExcelExport;
import com.yxb.cms.domain.dto.PassDoorDto;
import com.yxb.cms.domain.dto.PassRecordDto;
import com.yxb.cms.domain.vo.*;
import com.yxb.cms.service.impl.PassDoorService;
import com.yxb.cms.service.impl.PassRecordService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出行记录管理
 */
@Controller
@RequestMapping("passDoor")
public class PassDoorController {
    private Logger log = LogManager.getLogger(PassDoorController.class);
    @Autowired
    private PassDoorService passDoorService;

    /**
     * 去岗亭管理页面
     * @return
     */
    @RequestMapping(value = "/passDoor")
    public String passDoor() {
        return "yiqingManager/passDoor/passDoor_list";
    }

    /**
     * 查询集合
     * @param PassDoorDto
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/passDoorList")
    public String passDoorList(PassDoorDto PassDoorDto) {

        log.info("----->passDoorList:start,PassDoorDto={},",PassDoorDto);
        Map<Object, Object> map = new HashMap<>();

        //得到集合数据
        List<PassDoorVo> passRecordList = passDoorService.passDoorList(PassDoorDto);
        //得到数据条数
        Long count = passDoorService.passDoorCount(PassDoorDto);
        map.put("code", "0");
        map.put("msg", "查询成功");
        map.put("count", count);
        map.put("data", passRecordList);
        return Json.toJson(map);
    }

    /**
     * 跳转到岗亭新增页面
     * @return
     */
    @RequestMapping("/passDoor_add.do")
    public String toPassDoorAdd(Model model) {
        List<PassDoorDto> fList = passDoorService.selectParkList(null);
        model.addAttribute("fList", fList);
        model.addAttribute("department", new PassDoorDto());
        //新增页面标识
        model.addAttribute("pageFlag", "addPage");
        return "yiqingManager/passDoor/passDoor_add";
    }

    /**
     * 保存部门信息
     * @paramDepartment 部门实体
     * @return
     */
    @RequestMapping("/passDoor_addSave.do")
    @ResponseBody
    @SystemControllerLog(description="保存部门信息")
    public String ajaxSaveDepartment(PassDoorDto PassDoorDto){

        try {

            int insert = passDoorService.insert(PassDoorDto);
            if(insert>0){

                return "true";
            }
        } catch (Exception e) {
            log.error("保存部门信息方法内部错误",e);
            return "false";
        }

        return "false";
    }
    @RequestMapping("/passDoor_delete.do")
    @ResponseBody
    @SystemControllerLog(description="删除信息")
    public BussinessMsg passDoorDelete(int id){
        try {
            passDoorService.deleteByPrimaryKey(id);
        }catch (Exception e) {
            log.error("保存岗亭信息方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.DEPARTMENT_DELETE_ERROR);
        }
        return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
    }

    /**
     * 跳转到岗亭修改页面
     * @param id 部门id
     * @return
     */
    @RequestMapping("/passDoor_update.do")
    public String passDoorUpdate(Model model,Integer id){
        List<PassDoorDto> fList = passDoorService.selectParkList(null);
        model.addAttribute("fList", fList);
        PassDoorDto department = passDoorService.getObjByPrimaryKey(id);
        //修改页面标识
        model.addAttribute("pageFlag", "updatePage");
        model.addAttribute("department", department);
        return "yiqingManager/passDoor/passDoor_edit";
    }

    /**
     * 保存部门信息
     * @paramDepartment 部门实体
     * @return
     */
    @RequestMapping("/passDoor_updateSave.do")
    @ResponseBody
    @SystemControllerLog(description="保存部门信息")
    public String passDoorUpdateSave(PassDoorDto passDoorDto){

        try {

            int update = passDoorService.updateByPrimaryKeySelective(passDoorDto);
            if(update>0){

                return "true";
            }
        } catch (Exception e) {
            log.error("保存部门信息方法内部错误",e);
            return "false";
        }

        return "false";
    }
}
