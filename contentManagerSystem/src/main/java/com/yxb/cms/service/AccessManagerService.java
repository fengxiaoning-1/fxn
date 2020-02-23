package com.yxb.cms.service;

import com.yxb.cms.dao.AccessManagerMapper;
import com.yxb.cms.domain.vo.AccessManagerEntity;
import com.yxb.cms.domain.dto.AccessManagerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccessManagerService {

    @Autowired
    private AccessManagerMapper accessManagerMapper;

    public List<AccessManagerDto> accessManagerList(AccessManagerEntity accessManagerEntity) {

        List<AccessManagerDto> aManagerList = new ArrayList<AccessManagerDto>();

        List<AccessManagerEntity> accessManagerList = accessManagerMapper.selectAccessManagerListByPage(accessManagerEntity);
        if(accessManagerList!=null && accessManagerList.size()>0){
            for (int i = 0; i < accessManagerList.size(); i++) {
                AccessManagerEntity amEntity = accessManagerList.get(i);
                AccessManagerDto ame = new AccessManagerDto();
                ame.setTrueName(amEntity.getTrueName());
                ame.setParkName(amEntity.getParkName());
                String roleCode = amEntity.getRoleCode();
                switch (roleCode) {
                    case "admin":
                        ame.setRoleCode("管理员");
                        break;
                    case "sentry":
                        ame.setRoleCode("执勤员");
                        break;
                    case "passerby":
                        ame.setRoleCode("通勤人员通行");
                        break;
                    case "visitor":ame.setRoleCode("访客");
                        break;

                    default:
                        ame.setRoleCode("");
                        break;
                }
                Integer isCheck = amEntity.getIsCheck();
                switch (isCheck) {
                    case 0 :
                        ame.setIsCheck("未检查");
                        break;
                    case 1 :
                        ame.setIsCheck("已检查");
                        break;

                    default:
                        ame.setIsCheck("");
                        break;
                }

                //通行码
                ame.setPassCode(amEntity.getPassCode());

                 // 通行时间
                ame.setPassCodeValidDate(amEntity.getPassCodeValidDate());

                aManagerList.add(ame);
            }
        }

        return aManagerList;
    }

    public Long accessManagerClubCount(AccessManagerEntity accessManagerEntity) {

        return accessManagerMapper.accessManagerClubCount(accessManagerEntity);
    }
}
