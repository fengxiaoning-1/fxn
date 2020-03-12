package com.yxb.cms.util;

public class AdapterUtil {
	
	public static Page getCommPage(com.yxb.cms.domain.page.Page page){
		if(page==null){
			return null;
		}
		Page p = new Page();
		p.setPageNo(page.getPage());
		p.setPageSize(page.getPageSize());
		return p;
	}
	
}
