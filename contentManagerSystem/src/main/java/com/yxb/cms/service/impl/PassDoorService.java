package com.yxb.cms.service.impl;

import com.yxb.cms.dao.PassDoorMapper;
import com.yxb.cms.domain.dto.PassDoorDto;
import com.yxb.cms.domain.vo.PassDoorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PassDoorService {

    @Autowired
    private PassDoorMapper passDoorMapper;

    /**
     * 门岗记录
     * @param passDoorDto
     * @return
     */
    public List<PassDoorVo> passDoorList(PassDoorDto passDoorDto) {

        List<PassDoorVo> aManagerList = new ArrayList<PassDoorVo>();

        List<PassDoorDto> passRecordList = passDoorMapper.selectDoorListByPage(passDoorDto);
        if(passRecordList!=null && passRecordList.size()>0){
            for (int i = 0; i < passRecordList.size(); i++) {
                PassDoorDto prEntity = passRecordList.get(i);
                PassDoorVo prd = new PassDoorVo();
                prd.setId(prEntity.getId());
                prd.setName(prEntity.getName());
                prd.setAddress(prEntity.getAddress());
                prd.setDoorName(prEntity.getDoorName());

                aManagerList.add(prd);
            }
        }

        return aManagerList;
    }

    /**
     * 数据总条数
     * @param passDoorDto
     * @return
     */
    public Long passDoorCount(PassDoorDto passDoorDto) {

        return passDoorMapper.passDoorCount(passDoorDto);
    }

    /**
     * 得到工厂集合
     * @param passDoorDto
     * @return
     */
    public List<PassDoorDto> selectParkList(PassDoorDto passDoorDto){

        return passDoorMapper.selectParkList(passDoorDto);
    }

    /**
     * 新增岗亭
     * @param passDoorDto
     * @return
     */
    public int insert(PassDoorDto passDoorDto){

        return passDoorMapper.insert(passDoorDto);
    }

    public  int deleteByPrimaryKey(Integer id){
        return passDoorMapper.deleteByPrimaryKey(id);
    }

    /**
     * 得到一个对象
     * @param id
     * @return
     */
    public PassDoorDto getObjByPrimaryKey(Integer id){

            return passDoorMapper.getObjByPrimaryKey(id);
    }

    /**
     * 根据主键更新记录
     * @param id
     * @return
     */
    public int updateByPrimaryKeySelective(PassDoorDto passDoorDto){
        return passDoorMapper.updateByPrimaryKeySelective(passDoorDto);
    }
}
