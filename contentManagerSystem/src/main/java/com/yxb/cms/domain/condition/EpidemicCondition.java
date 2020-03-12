package com.yxb.cms.domain.condition;

import java.io.Serializable;

/**
 *	疫情查询条件
 */
public class EpidemicCondition implements Serializable {
	//单位
	private String company;
	//部门
	private String department;
	//姓名
	private String name;
	//身份证
	private String idCard;
	//手机号
	private String phoneNumber;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
