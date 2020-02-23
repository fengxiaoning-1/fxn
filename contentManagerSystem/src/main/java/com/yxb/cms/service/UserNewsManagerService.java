package com.yxb.cms.service;

import com.yxb.cms.dao.UserNewsManagerMapper;
import com.yxb.cms.domain.dto.UserNewsManagerDto;
import com.yxb.cms.domain.vo.UserNewsManagerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserNewsManagerService {

    @Autowired
    private UserNewsManagerMapper userNewsManagerMapper;

    public List<UserNewsManagerDto> userNewsManagerList() {

        List<UserNewsManagerDto> aManagerList = new ArrayList<UserNewsManagerDto>();

        List<UserNewsManagerEntity> passRecordList = userNewsManagerMapper.userNewsManagerList();
        if(passRecordList!=null && passRecordList.size()>0){
            for (int i = 0; i < passRecordList.size(); i++) {
                UserNewsManagerEntity passRecordEntity = passRecordList.get(i);
                UserNewsManagerDto prd = new UserNewsManagerDto();
                prd.setId(passRecordEntity.getId());
                prd.setTrueName(passRecordEntity.getTrueName());
                prd.setNickName(passRecordEntity.getNickName());

                prd.setPhoneNumber(passRecordEntity.getPhoneNumber());
                prd.setDefaultRoleCode(passRecordEntity.getDefaultRoleCode());

                /**
                 * 用户性别. 0：未知；1：男性；2：女性。
                 */
                Integer gender = passRecordEntity.getGender();
                switch (gender) {
                    case 0 :
                        prd.setGender("未知");
                        break;
                    case 1 :
                        prd.setGender("男性");
                        break;
                    case 2 :
                        prd.setGender("女性");
                        break;

                    default:
                        prd.setGender("未知");
                        break;
                }

                aManagerList.add(prd);
            }
        }

        return aManagerList;
    }

    public int userNewsManagerCount() {

        return userNewsManagerMapper.userNewsManagerCount();
    }
}
