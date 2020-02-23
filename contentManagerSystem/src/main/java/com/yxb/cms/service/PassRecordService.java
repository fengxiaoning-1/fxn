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

    public Long passRecordCount(PassRecordEntity passRecordEntity) {

        return passRecordMapper.passRecordCount(passRecordEntity);
    }
}
