package com.yxb.cms.domain.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: PagedResult 
 * @Description: PageHelper分页
 * @author zouyan
 * @date 2016年4月20日 下午5:34:30 
 * 
 * @param <T>
 */
public class PagedResult<T> extends BaseEntity {

	public PagedResult(){
		this.setPage(0);
		this.setPageSize(0);
		this.setData(new ArrayList<T>());
		this.setTotal(0);
	}

	public PagedResult(long page,long pageSize){
		this.setPage(page);
		this.setPageSize(pageSize);
		this.setData(new ArrayList<T>());
		this.setTotal(0);
	}

	public PagedResult(long page,long pageSize,List<T> data,long total){
		if(data != null){
			this.setPage(page);
			this.setPageSize(pageSize);
			this.setData(data);
			this.setTotal(total);
		}else {
			this.setPage(1);
			this.setPageSize(pageSize);
			this.setData(data);
			this.setTotal(0);
		}
	}

	private static final long serialVersionUID = 1L;

	/**
	 * list
	 */
	private List<T> data;

	/**
	 * 当前页
	 */
	private long page;

	/**
	 * 条数
	 */
	private long pageSize;

	/**
	 * 总条数
	 */
	private long total;



	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}





}
