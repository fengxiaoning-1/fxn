package com.yxb.cms.service;

import com.yxb.cms.domain.vo.UserPark;

public interface UserParkService {

	public int addUserPark(UserPark userPark);

	public UserPark selectByPhoneAndParkId(String phoneNumber, Integer parkId);
}
