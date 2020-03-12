package com.yxb.cms.controller.club;

import com.yxb.cms.domain.dto.UserNewsManagerDto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.json.Json;
import com.yxb.cms.domain.vo.UserNewsManagerEntity;
import com.yxb.cms.service.impl.UserNewsManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出行记录管理
 */
@Controller
@RequestMapping("userManager")
public class UserNewsManagerController {
    private Logger log = LogManager.getLogger(UserNewsManagerController.class);
    @Autowired
    private UserNewsManagerService userNewsManagerService;

    @RequestMapping(value = "/userNewsManagers")
    public String toClubListPage() {
        return "yiqingManager/userNewsManager";
    }

    @ResponseBody
    @RequestMapping(value = "/userNewsManagerList")
    public String queryClubList(UserNewsManagerEntity userNewsManagerEntity) {
        log.info("----->userNewsManagerList:start");
        Map<Object, Object> map = new HashMap<>();


        List<UserNewsManagerDto> userNewsManagerList = userNewsManagerService.userNewsManagerList(userNewsManagerEntity);
        Long count = userNewsManagerService.userNewsManagerCount(userNewsManagerEntity);
        map.put("code", "0");
        map.put("msg", "查询成功");
        map.put("count", count);
        map.put("data", userNewsManagerList);
        return Json.toJson(map);
    }
}
