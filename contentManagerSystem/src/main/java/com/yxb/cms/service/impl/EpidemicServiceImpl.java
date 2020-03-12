package com.yxb.cms.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxb.cms.dao.EpidemicMapper;
import com.yxb.cms.domain.condition.EpidemicCondition;
import com.yxb.cms.domain.page.Page;

import com.yxb.cms.domain.page.PagedResult;
import com.yxb.cms.domain.vo.Epidemic;
import com.yxb.cms.domain.vo.EpidemicExample;
import com.yxb.cms.domain.vo.EpidemicExample.Criteria;
import com.yxb.cms.service.EpidemicService;
import com.yxb.cms.util.AdapterUtil;
import com.yxb.cms.util.ObjectUtil;

/**
 * @Description
 * @Author chencheng.jiang
 * @Date 2020-02-29 13:04
 */
@Service
public class EpidemicServiceImpl implements EpidemicService {
    private Logger log = LogManager.getLogger(EpidemicServiceImpl.class);

    @Autowired
    private EpidemicMapper epidemicMapper;

	@Override
	public PagedResult<Epidemic> getEpidemics(EpidemicCondition condition, Page page) {
		PagedResult<Epidemic> pagedResult = new PagedResult<Epidemic>();
		
		PageInfo<Epidemic> pageInfo = getEpidemicPage(condition, AdapterUtil.getCommPage(page));
		
		pagedResult.setData(pageInfo.getList());
		pagedResult.setPage(pageInfo.getPageNum());
		pagedResult.setPageSize(pageInfo.getPageSize());
		pagedResult.setTotal(pageInfo.getTotal());
		return pagedResult;
	}
    
	public PageInfo<Epidemic> getEpidemicPage(EpidemicCondition condition, com.yxb.cms.util.Page page) {
		//实例化查询条件
		EpidemicExample example = getEpidemicExample(condition);
		
		//分页设置
		if (page != null) {
			PageHelper.startPage(page.getPageNo(), page.getPageSize(), true);
		}
		List<Epidemic> epidemicList = epidemicMapper.selectByExample(example);
		
		PageInfo<Epidemic> epidemicPage = new PageInfo<>(epidemicList);
		
		return epidemicPage;
	}
	
	private EpidemicExample getEpidemicExample(EpidemicCondition condition) {
		EpidemicExample epidemicExample = new EpidemicExample();
		Criteria criteria = epidemicExample.createCriteria();
		criteria.andIsDeleteNotEqualTo(1);
		if (ObjectUtil.isNotEmpty(condition.getCompany())) {
			criteria.andComefromLike("%"+condition.getCompany()+"%");
		}
		if (ObjectUtil.isNotEmpty(condition.getDepartment())) {
			criteria.andDepartmentLike("%"+condition.getDepartment()+"%");
		}
		if (ObjectUtil.isNotEmpty(condition.getName())) {
			criteria.andNameLike("%"+condition.getName()+"%");
		}
		if (ObjectUtil.isNotEmpty(condition.getIdCard())) {
			criteria.andIdCardLike("%"+condition.getIdCard()+"%");
		}
		if (ObjectUtil.isNotEmpty(condition.getPhoneNumber())) {
			criteria.andPhoneNumberLike("%"+condition.getPhoneNumber()+"%");
		}
		
		return epidemicExample;
	}

	@Override
	public int addEpidemic(Epidemic epidemic) {
		int number = epidemicMapper.insert(epidemic);
		return 0;
	}

	@Override
	public int updateEpidemic(Epidemic epidemic) {
		return epidemicMapper.updateByPrimaryKey(epidemic);
	}

	@Override
	public Epidemic selectByidCard(String idCard) {
		return epidemicMapper.selectByIdCard(idCard);
	}
}
