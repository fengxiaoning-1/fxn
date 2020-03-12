package com.yxb.cms.domain.vo;

import java.util.Date;

public class UserPark {
    private Integer id;

    private Integer userid;

    private String truename;

    private String phone;

    private Integer parkid;

    private String parkname;

    private String rolecode;

    private Integer ischeck;

    private String passcode;

    private Date passcodevaliddate;

    private String companyName;

    private String deptname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getParkid() {
        return parkid;
    }

    public void setParkid(Integer parkid) {
        this.parkid = parkid;
    }

    public String getParkname() {
        return parkname;
    }

    public void setParkname(String parkname) {
        this.parkname = parkname == null ? null : parkname.trim();
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public Integer getIscheck() {
        return ischeck;
    }

    public void setIscheck(Integer ischeck) {
        this.ischeck = ischeck;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode == null ? null : passcode.trim();
    }

    public Date getPasscodevaliddate() {
        return passcodevaliddate;
    }

    public void setPasscodevaliddate(Date passcodevaliddate) {
        this.passcodevaliddate = passcodevaliddate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }
}