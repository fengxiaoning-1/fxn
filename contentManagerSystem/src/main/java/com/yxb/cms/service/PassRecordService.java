package com.yxb.cms.service;

import com.yxb.cms.dao.PassRecordMapper;
import com.yxb.cms.domain.dto.PassRecordDto;
import com.yxb.cms.domain.vo.PassRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassRecordService {

    @Autowired
    private PassRecordMapper passRecordMapper;

    public List<PassRecordDto> passRecordList() {

        List<PassRecordDto> aManagerList = new ArrayList<PassRecordDto>();

        List<PassRecordEntity> passRecordList = passRecordMapper.passRecordList();
        if(passRecordList!=null && passRecordList.size()>0){
            for (int i = 0; i < passRecordList.size(); i++) {
                PassRecordEntity passRecordEntity = passRecordList.get(i);
                PassRecordDto prd = new PassRecordDto();
                prd.setId(passRecordEntity.getId());
                prd.setParkId(passRecordEntity.getParkId());
                prd.setParkName(passRecordEntity.getParkName());
                prd.setDoorName(passRecordEntity.getDoorName());
                prd.setSentryTrueName(passRecordEntity.getSentryTrueName());
                prd.setPassTrueName(passRecordEntity.getPassTrueName());
                prd.setPassDate(passRecordEntity.getPassDate());
                prd.setTemperature(passRecordEntity.getTemperature());
                prd.setReason(passRecordEntity.getReason());

                Integer isIn = passRecordEntity.getIsIn();
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
                Integer admit = passRecordEntity.getAdmit();
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

    public int passRecordCount() {

        return passRecordMapper.passRecordCount();
    }
}
