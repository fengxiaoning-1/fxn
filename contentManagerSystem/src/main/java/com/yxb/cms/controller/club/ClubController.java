package com.yxb.cms.controller.club;

import com.yxb.cms.domain.vo.ClubEntity;
import com.yxb.cms.service.impl.ClubService;

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
@RequestMapping("club")
public class ClubController {
    private Logger log = LogManager.getLogger(ClubController.class);
    @Autowired
    private ClubService clubService;

    @RequestMapping(value = "/to_club_list")
    public String toClubListPage() {
        return "club/club_list";
    }

    @RequestMapping(value = "/queryClub")
    @ResponseBody
    public String queryClubList() {
        log.info("----->queryClubList:start");
        Map<Object, Object> map = new HashMap<>();
        List<ClubEntity> clubEntities = clubService.queryClubList();
        int count = clubService.queryClubCount();
        map.put("code", "0");
        map.put("msg", "查询成功");
        map.put("count", count);
        map.put("data", clubEntities);
        return Json.toJson(map);
    }
}
