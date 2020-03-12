package com.yxb.cms.service;

import com.yxb.cms.domain.condition.EpidemicCondition;
import com.yxb.cms.domain.page.Page;
import com.yxb.cms.domain.page.PagedResult;
import com.yxb.cms.domain.vo.Epidemic;

public interface EpidemicService {

	public PagedResult<Epidemic> getEpidemics(EpidemicCondition condition,Page page);
	
	public Epidemic selectByidCard(String idCard);
	
	public int addEpidemic(Epidemic epidemic);
	
	public int updateEpidemic(Epidemic epidemic);
	
}
