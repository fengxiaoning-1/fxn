package com.yxb.cms.controller.club;

import com.yxb.cms.domain.dto.PassDoorDto;
import com.yxb.cms.domain.vo.AccessManagerEntity;
import com.yxb.cms.domain.dto.AccessManagerDto;
import com.yxb.cms.service.AccessManagerService;
import com.yxb.cms.service.PassDoorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 俱乐部管理中心
 */
@Controller
@RequestMapping("accessManager")
public class AccessManagerController {

    private Logger log = LogManager.getLogger(AccessManagerController.class);

    @Autowired
    private AccessManagerService accessManagerService;

    @Autowired
    private PassDoorService passDoorService;

    @RequestMapping(value = "/accessManager")
    public String toClubListPage() {
        return "yiqingManager/accessManager/accessManager_list";
    }

    @ResponseBody
    @RequestMapping(value = "/accessManagerList")
    public String queryClubList(AccessManagerEntity accessManagerEntity) {
        log.info("----->accessManagerList:start");
        Map<Object, Object> map = new HashMap<>();

        List<AccessManagerDto> accessManagerList = accessManagerService.accessManagerList(accessManagerEntity);
        Long count = accessManagerService.accessManagerClubCount(accessManagerEntity);
        map.put("code", "0");
        map.put("msg", "查询成功");
        map.put("count", count);
        map.put("data", accessManagerList);
        return Json.toJson(map);
    }

    /**
     * 跳转到角色新增页面
     * @return
     */
    @RequestMapping("/accessManager_add.do")
    public String toAccessManagerAdd(Model model) {

        List<PassDoorDto> fList = passDoorService.selectParkList(null);
        Map<String, String> roleCodeMap = accessManagerService.roleCodeMap();
        model.addAttribute("fList", fList);
        model.addAttribute("roleCodeMap", roleCodeMap);
        model.addAttribute("department", new PassDoorDto());
        //新增页面标识
        model.addAttribute("pageFlag", "addPage");

        return "yiqingManager/accessManager/accessManager_add";
    }



}
