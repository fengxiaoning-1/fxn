package com.yxb.cms.service;

import com.yxb.cms.dao.ClubMapper;
import com.yxb.cms.domain.vo.ClubEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    private ClubMapper clubMapper;

    public List<ClubEntity> queryClubList() {

        return clubMapper.queryClubList();
    }

    public int queryClubCount() {

        return clubMapper.queryClubCount();
    }
}
