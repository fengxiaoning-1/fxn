package com.yxb.cms.domain.page;

public class Page {

	/**
	 * 起始页
	 */
	private int page; 
	
	/**
	 * 条数
	 */
	private int pageSize=10;
	
	/**
	 * 列名排序
	 */
	private String sortName;
	
	/**
	 * 排序方式
	 */
	private String sortOrder;

	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}



}
