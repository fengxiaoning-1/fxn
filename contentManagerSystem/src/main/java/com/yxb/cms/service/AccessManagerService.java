package com.yxb.cms.service;

import com.yxb.cms.dao.AccessManagerMapper;
import com.yxb.cms.domain.vo.AccessManagerEntity;
import com.yxb.cms.domain.dto.AccessManagerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccessManagerService {

    @Autowired
    private AccessManagerMapper accessManagerMapper;

    public List<AccessManagerDto> accessManagerList(AccessManagerEntity accessManagerEntity) {

        List<AccessManagerDto> aManagerList = new ArrayList<AccessManagerDto>();

        List<AccessManagerEntity> accessManagerList = accessManagerMapper.selectAccessManagerListByPage(accessManagerEntity);
        if(accessManagerList!=null && accessManagerList.size()>0){
            for (AccessManagerEntity amEntity:accessManagerList) {

                //得地对象
                AccessManagerDto accessManagerDto = getAccessManagerDto(amEntity);

                //添加到集合
                aManagerList.add(accessManagerDto);
            }
        }

        return aManagerList;
    }

    /**
     * 获取数据总条数
     * @param accessManagerEntity
     * @return
     */
    public Long accessManagerClubCount(AccessManagerEntity accessManagerEntity) {

        return accessManagerMapper.accessManagerClubCount(accessManagerEntity);
    }

    /**
     * 得到通行人员信息对象
     * @param amEntity
     * @return
     */
    public AccessManagerDto getAccessManagerDto(AccessManagerEntity amEntity){

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
        //单位
        ame.setCompanyName(amEntity.getCompanyName());
        //所在部门
        ame.setDeptName(amEntity.getDeptName());

        return ame;
    }

    /**
     * 得到角色名称集合
     * @return
     */
    public Map<String,String> roleCodeMap(){

        List<AccessManagerDto> aManagerList = new ArrayList<AccessManagerDto>();
        Map<String,String> roleCodeMap = new HashMap<String,String>();
        roleCodeMap.put("admin","管理员");
        roleCodeMap.put("sentry","执勤员");
        roleCodeMap.put("passerby","通勤人员通行");
        roleCodeMap.put("visitor","访客");

        return roleCodeMap;
    }
    /**
     * 得到角色名称集合
     * @return
     */
    public Map<String,String> getIsCheckMap(){

        Map<String,String> isCheckMap = new HashMap<String,String>();
        isCheckMap.put("0","未检查");
        isCheckMap.put("1","已检查");

        return isCheckMap;
    }






}
