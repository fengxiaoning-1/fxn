package com.yxb.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yxb.cms.dao.UserParkMapper;
import com.yxb.cms.domain.vo.UserPark;
import com.yxb.cms.domain.vo.UserParkExample;
import com.yxb.cms.domain.vo.UserParkExample.Criteria;
import com.yxb.cms.service.UserParkService;
import com.yxb.cms.util.ObjectUtil;

@Service
public class UserParkServiceImpl implements UserParkService {
	
	@Autowired
	private UserParkMapper userParkMapper; 

	@Override
	public int addUserPark(UserPark userPark) {
		return userParkMapper.insert(userPark);
	}

	@Override
	public UserPark selectByPhoneAndParkId(String phoneNumber, Integer parkId) {
		UserParkExample example = new UserParkExample();
		Criteria criteria = example.createCriteria();
		if (ObjectUtil.isNotEmpty(phoneNumber)) {
			criteria.andPhoneEqualTo(phoneNumber);
		}
		if (ObjectUtil.isNotEmpty(parkId)) {
			criteria.andParkidEqualTo(parkId);
		}
		return userParkMapper.selectOneByExample(example);
	}

}
