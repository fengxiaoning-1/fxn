package com.yxb.cms.controller.club;

import com.yxb.cms.architect.utils.CommonHelper;
import com.yxb.cms.domain.bo.ExcelExport;
import com.yxb.cms.domain.vo.PassRecord;
import com.yxb.cms.domain.vo.PassRecordEntity;
import com.yxb.cms.domain.dto.PassRecordDto;
import com.yxb.cms.service.PassRecordService;
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
            String startTime = strDate(dateArr[0]);
            passRecordEntity.setStartTime(startTime);
            String endTime = strDate(dateArr[1]);
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
        String passDate = passRecord.getPassDate();
        if(passDate!=null&&passDate!=""){
            String[] dateArr = passDate.split(" - ");
            String startTime = strDate(dateArr[0]);
            passRecord.setStartTime(startTime);
            String endTime = strDate(dateArr[1]);
            passRecord.setEndTime(endTime);
        }
        ExcelExport excelExport = passRecordService.excelExportPassRecordList(passRecord);
        return CommonHelper.getExcelModelAndView(excelExport);
    }

    /**
     *
     * @Title: str2StringList
     * @Description: 返回字符串时间list
     * @author songzhipeng
     * @param @param date timeZone时间区域
     * @param @return
     * @return List<String>
     * @throws
     */
    public static List<String> str2StringList(String date){
        String[] dateArr = date.split(" - ");
        if(null != dateArr&&dateArr.length==2){
            List<String> dateList = new ArrayList<String>();
            String startDate = strDate(dateArr[0]);
            dateList.add(startDate);
            String endDate = strDate(dateArr[1]);
            dateList.add(endDate);
            return dateList;
        }
        return null;
    }

    /**
     *
     * @Title: strDate
     * @Description: 转为yyyy-MM-dd HH:mm的字符串格式
     * @author songzhipeng
     * @param @param date
     * @param @return
     * @return String
     * @throws
     */
    public static String strDate(String date){
        String returnstr = "";
        if(notEmpty(date)){
            returnstr = date.trim();
            returnstr = returnstr.replaceAll("/", "-");
        }
        return returnstr;
    }

    /**
     * 检测字符串是否不为空(null,"","null")
     * @param s
     * @return 不为空则返回true，否则返回false
     */
    public static boolean notEmpty(String s){
        return s!=null && !"".equals(s) && !"null".equals(s);
    }
}
