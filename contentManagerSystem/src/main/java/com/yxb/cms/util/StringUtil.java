package com.yxb.cms.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	/**
	 * 
	 * @Title: getList 
	 * @Description: Long型字符串转List<Long>
	 * @author songzhipeng
	 * @param @param str
	 * @param @return  
	 * @return List<Long>    
	 * @throws
	 */
	public static List<Long> getList(String str){
		List<Long> list = new ArrayList<Long>();
		String[] strs = str.split(",");
		for(int j=0; j<strs.length; j++){
			list.add(Long.valueOf(strs[j]));
		}
		return list;
	}
	
	public static boolean isNotEmpty(String str){
		if (null==str) {
			return false;
		}else if (("").equals(str)) {
			return false;
		}else{
			return true;
		}
	}
}
