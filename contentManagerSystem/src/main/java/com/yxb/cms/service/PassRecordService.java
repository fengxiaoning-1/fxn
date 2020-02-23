package com.yxb.cms.service;

import com.yxb.cms.dao.PassRecordMapper;
import com.yxb.cms.domain.dto.PassRecordDto;
import com.yxb.cms.domain.vo.PassRecordEntity;
import com.yxb.cms.domain.vo.PassRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassRecordService {

    @Autowired
    private PassRecordMapper passRecordMapper;

    public List<PassRecordDto> passRecordList(PassRecordEntity passRecordEntity) {

        List<PassRecordDto> aManagerList = new ArrayList<PassRecordDto>();

        List<PassRecordEntity> passRecordList = passRecordMapper.selectPassRecordListByPage(passRecordEntity);
        if(passRecordList!=null && passRecordList.size()>0){
            for (int i = 0; i < passRecordList.size(); i++) {
                PassRecordEntity prEntity = passRecordList.get(i);
                PassRecordDto prd = new PassRecordDto();
                prd.setId(prEntity.getId());
                prd.setParkId(prEntity.getParkId());
                prd.setParkName(prEntity.getParkName());
                prd.setDoorName(prEntity.getDoorName());
                prd.setSentryTrueName(prEntity.getSentryTrueName());
                prd.setPassTrueName(prEntity.getPassTrueName());
                prd.setPassDate(prEntity.getPassDate());
                prd.setTemperature(prEntity.getTemperature());
                prd.setReason(prEntity.getReason());

                Integer isIn = prEntity.getIsIn();
                switch (isIn) {
                    case 0 :
                        prd.setIsIn("未进门");
                        break;
                    case 1 :
                        prd.setIsIn("已进门");
                        break;

                    default:
                        prd.setIsIn("");
                        break;
                }

                //0:未审核;1:通过;2:不通过
                Integer admit = prEntity.getAdmit();
                switch (admit) {
                    case 0:
                        prd.setAdmit("未审核");
                        break;
                    case 1:
                        prd.setAdmit("通过");
                        break;
                    case 2:
                        prd.setAdmit("不通过");
                        break;

                    default:
                        prd.setAdmit("");
                        break;
                }

                aManagerList.add(prd);
            }
        }

        return aManagerList;
    }
    /**
     * 出入记录EXCEL导出
     * @param PassRecord 出入实体
     * @return
     */
    public ExcelExport excelExportPassRecordList(PassRecord passRecord){
        ExcelExport excelExport = new ExcelExport();
        List<PassRecord> passList = this.selectPassList(passRecord);
        excelExport.addColumnInfo("用户编号","ParkId");
        excelExport.addColumnInfo("用户姓名","ParkName");
        excelExport.addColumnInfo("工厂名称","DoorName");
        excelExport.addColumnInfo("通行时间","PassDate");
        excelExport.addColumnInfo("体温","Temperature");
        excelExport.addColumnInfo("出行理由","Reason");
        excelExport.addColumnInfo("出入状态","IsIn");
        excelExport.addColumnInfo("修改时间","Admit");

        excelExport.setDataList(passList);
        return excelExport;
    }
    /**
     * 出入记录List
     * @param PassRecord 出入实体
     * @return
     */
    public List<PassRecord> selectPassList(PassRecord passRecord){

        List<PassRecord> passList = passRecordMapper.selectUserList(passRecord);
        if (null != passList && !passList.isEmpty()){
            for (PassRecord ps : passList) {
            	String isIn = ps.getIsIn();
                switch (isIn) {
                    case "0" :
                    	ps.setIsIn("未进门");
                        break;
                    case "1" :
                    	ps.setIsIn("已进门");
                        break;

                    default:
                    	ps.setIsIn("");
                        break;
                }

                //0:未审核;1:通过;2:不通过
                String admit = ps.getAdmit();
                switch (admit) {
                    case "0":
                    	ps.setAdmit("未审核");
                        break;
                    case "1":
                    	ps.setAdmit("通过");
                        break;
                    case "2":
                    	ps.setAdmit("不通过");
                        break;

                    default:
                    	ps.setAdmit("");
                        break;
                }

            }
        }
        return passList;
    }

    public Long passRecordCount(PassRecordEntity passRecordEntity) {

        return passRecordMapper.passRecordCount(passRecordEntity);
    }
}
