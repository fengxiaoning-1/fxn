package com.yxb.cms.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yxb.cms.architect.constant.BussinessCode;
import com.yxb.cms.architect.utils.BussinessMsgUtil;
import com.yxb.cms.dao.FactoryMapper;
import com.yxb.cms.domain.bo.BussinessMsg;
import com.yxb.cms.domain.vo.Factory;

@Service
public class FactoryService {
	private Logger log = LogManager.getLogger(FactoryService.class);
	@Autowired
	private FactoryMapper factoryMapper;
	
	public String selectFactoryResultPageList(Factory factory){

        List<Factory> resourceList = factoryMapper.selectFactoryListByPage(factory);

        Long count = factoryMapper.selectCount(factory);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data", resourceList);

        return Json.toJson(map);
    }
	public List<Factory> selectFactoryList(Factory factory){

        List<Factory> factoryList = factoryMapper.selectFactoryList(factory);
        return factoryList;
    }

    public  Factory selectByPrimaryKey(Integer resId){
        return factoryMapper.selectByPrimaryKey(resId);
    }
    @Transactional
    public BussinessMsg saveOrUpdateFactory(Factory factory, String loginName) throws Exception {
        log.info("保存工厂开始");
        long start = System.currentTimeMillis();
        try {
            //验证工厂名称唯一性
            Long checkName = factoryMapper.selectNameCheck(factory.getName(),factory.getId());
            if(checkName.intValue() > 0){
                return BussinessMsgUtil.returnCodeMessage(BussinessCode.ROLE_NAME_EXIST);
            }

            //保存工厂信息
            if (null == factory.getId()) {
            	factory.setCreator(loginName);
            	factory.setCreateTime(new Date());
                factoryMapper.insertSelective(factory);
            } else {
                //更新角色
            	factory.setModifier(loginName);
            	factory.setModifierTime(new Date());
                factoryMapper.updateByPrimaryKeySelective(factory);
            }
        } catch (Exception e) {
            log.error("保存工厂方法内部错误", e.toString());
            throw e;
        } finally {
            log.info("保存工厂信息结束,用时" + (System.currentTimeMillis() - start) + "毫秒");
        }
        return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
    }
}
