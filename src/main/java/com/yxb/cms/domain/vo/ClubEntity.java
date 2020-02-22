package com.yxb.cms.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ClubEntity {
    private int id;
    private String clubName;
    private String clubBossName;
    private String clubBossSex;
    private String clubLevel;
    private Date clubCreateTime;
}
