package com.yxb.cms.util;

import com.yxb.cms.util.excel.ReadProperties;

public class ConstUtils {

	
	public final static String PROTOCOL = "protocol";
	public final static String CITY_CODE = "city_code";
	public final static String LICENSE_COLOR = "license_color";
	public final static String VEHICLE_COLOR = "vehicle_color";
	public final static String PURPOSE_CODE = "purpose_code";
	
	public final static String PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath() ;
	
	public final static String FILE_PATH= PATH+"upload/";
	
	public static String getValue(String key,String type){
		ReadProperties read = ReadProperties.getInstance();
		String value = read.getValue(type+"."+key);
		if(!StringUtil.isNotEmpty(value)){
			value = read.getValue(type+".default");
		}
		return value;
	}
	
	
}
