package com.yxb.cms.controller.club;

import com.yxb.cms.domain.vo.AccessManagerEntity;
import com.yxb.cms.service.impl.AccessManagerService;
import com.yxb.cms.domain.dto.AccessManagerDto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/accessManager")
    public String toClubListPage() {
        return "yiqingManager/accessManager";
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
}
