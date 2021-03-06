package com.yxb.cms.controller.club;

import com.yxb.cms.architect.utils.CommonHelper;
import com.yxb.cms.architect.utils.DateUtil;
import com.yxb.cms.domain.bo.ExcelExport;
import com.yxb.cms.domain.vo.PassRecord;
import com.yxb.cms.domain.vo.PassRecordEntity;
import com.yxb.cms.service.impl.PassRecordService;
import com.yxb.cms.domain.dto.PassRecordDto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.util.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出行记录管理
 */
@Controller
@RequestMapping("passRecord")
public class PassRecordController {
    private Logger log = LogManager.getLogger(PassRecordController.class);
    @Autowired
    private PassRecordService passRecordService;

    @RequestMapping(value = "/passRecord")
    public String toClubListPage() {
        return "yiqingManager/passRecord";
    }

    @ResponseBody
    @RequestMapping(value = "/passRecordList")
    public String queryClubList(PassRecordEntity passRecordEntity) {
        log.info("----->passRecordList:start");
        Map<Object, Object> map = new HashMap<>();
        String passDate = passRecordEntity.getPassDate();
        if(passDate!=null&&passDate!=""){
            String[] dateArr = passDate.split(" - ");
            String startTime = DateUtil.strDate(dateArr[0]);
            passRecordEntity.setStartTime(startTime);
            String endTime = DateUtil.strDate(dateArr[1]);
            passRecordEntity.setEndTime(endTime);
        }

        List<PassRecordDto> passRecordList = passRecordService.passRecordList(passRecordEntity);
        Long count = passRecordService.passRecordCount(passRecordEntity);
        map.put("code", "0");
        map.put("msg", "查询成功");
        map.put("count", count);
        map.put("data", passRecordList);
        return Json.toJson(map);
    }
    /**
     * 导出通行记录信息
     * @param user 用户实体
     * @return
     */
    @RequestMapping("/excel_passRecord_export.do")
    public ModelAndView excelPassRecordExport(PassRecord passRecord){

        //默认得到查询时间
        String passDate = passRecord.getPassDate();
        if(passDate!=null&&passDate!=""){
            String[] dateArr = passDate.split(" - ");
            String startTime = DateUtil.strDate(dateArr[0]);
            passRecord.setStartTime(startTime);
            String endTime = DateUtil.strDate(dateArr[1]);
            passRecord.setEndTime(endTime);
        }

        ExcelExport excelExport = passRecordService.excelExportPassRecordList(passRecord);
        return CommonHelper.getExcelModelAndView(excelExport);
    }




}
