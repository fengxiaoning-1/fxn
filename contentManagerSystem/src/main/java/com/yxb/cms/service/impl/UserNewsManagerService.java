package com.yxb.cms.service.impl;

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

    public List<UserNewsManagerDto> userNewsManagerList(UserNewsManagerEntity userNewsManagerEntity) {

        List<UserNewsManagerDto> aManagerList = new ArrayList<UserNewsManagerDto>();

        List<UserNewsManagerEntity> passRecordList = userNewsManagerMapper.userNewsManagerListByPage(userNewsManagerEntity);
        if(passRecordList!=null && passRecordList.size()>0){
            for (int i = 0; i < passRecordList.size(); i++) {
                UserNewsManagerEntity passRecordEntity = passRecordList.get(i);

                //得到对象
                UserNewsManagerDto prd  = getUserNewsManagerDtoObj(passRecordEntity);

                aManagerList.add(prd);
            }
        }

        return aManagerList;
    }

    public Long userNewsManagerCount(UserNewsManagerEntity userNewsManagerEntity) {

        return userNewsManagerMapper.userNewsManagerCount(userNewsManagerEntity);
    }

    //拿到对象
   public  UserNewsManagerDto getUserNewsManagerDtoObj(UserNewsManagerEntity passRecordEntity){
       UserNewsManagerDto prd = new UserNewsManagerDto();
       prd.setId(passRecordEntity.getId());
       prd.setTrueName(passRecordEntity.getTrueName());
       prd.setCompany(passRecordEntity.getCompany());
       prd.setParkName(passRecordEntity.getParkName());
       prd.setDepartment(passRecordEntity.getDepartment());
       prd.setPhoneNumber(passRecordEntity.getPhoneNumber());
       prd.setPermanentAddress(passRecordEntity.getPermanentAddress());
       prd.setAddress(passRecordEntity.getAddress());
       prd.setIdCard(passRecordEntity.getIdCard());

       return prd;
   }












}
