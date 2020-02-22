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

    public List<AccessManagerDto> accessManagerList() {

        List<AccessManagerDto> aManagerList = new ArrayList<AccessManagerDto>();

        List<AccessManagerEntity> accessManagerList = accessManagerMapper.accessManagerList();
        if(accessManagerList!=null && accessManagerList.size()>0){
            for (int i = 0; i < accessManagerList.size(); i++) {
                AccessManagerEntity accessManagerEntity = accessManagerList.get(i);
                AccessManagerDto ame = new AccessManagerDto();
                ame.setTrueName(accessManagerEntity.getTrueName());
                ame.setParkName(accessManagerEntity.getParkName());
                String roleCode = accessManagerEntity.getRoleCode();
                switch (roleCode) {
                    case "0":
                        ame.setRoleCode("管理员");
                        break;
                    case "1":
                        ame.setRoleCode("执勤员");
                        break;
                    case "10":
                        ame.setRoleCode("家长");
                        break;
                    case "11":ame.setRoleCode("通行人");
                        break;

                    default:
                        ame.setRoleCode("");
                        break;
                }
                Integer isCheck = accessManagerEntity.getIsCheck();
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
                ame.setPassCode(accessManagerEntity.getPassCode());

                 // 通行时间
                ame.setPassCodeValidDate(accessManagerEntity.getPassCodeValidDate());

                aManagerList.add(ame);
            }
        }

        return aManagerList;
    }

    public int accessManagerClubCount() {

        return accessManagerMapper.accessManagerClubCount();
    }
}
