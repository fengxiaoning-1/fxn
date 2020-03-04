package com.yxb.cms.dao;

import com.yxb.cms.domain.dto.PassDoorDto;
import com.yxb.cms.domain.dto.PassRecordDto;
import com.yxb.cms.domain.vo.PassRecord;
import com.yxb.cms.domain.vo.PassRecordEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PassDoorMapper {



    /**
     * 查询出入ListselectParkList
     * @param passDoorDto 出入实体
     * @returnp
     */
    List<PassDoorDto> selectDoorListByPage(PassDoorDto passDoorDto);
    /**
     * 门岗记录
     * @param passDoorDto
     * @return
     */
    Long passDoorCount(PassDoorDto passDoorDto);
    /**
     * 查询出入selectParkList
     * @param passDoorDto 出入实体
     * @returnp
     */
    List<PassDoorDto> selectParkList(PassDoorDto passDoorDto);

    int insert(PassDoorDto passDoorDto);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 得到一个对象
     * @param id
     * @return
     */
    PassDoorDto getObjByPrimaryKey(Integer id);

    //根据主键更新记录
    int updateByPrimaryKeySelective(PassDoorDto passDoorDto);
}
