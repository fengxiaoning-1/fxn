package com.yxb.cms.util.excel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import com.yxb.cms.util.StringUtil;

import java.util.ResourceBundle;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Properties;  
/**
 * 
 * @ClassName: ReadProperties 
 * @Description: 读取配置文件
 */
public class ReadProperties {


	public static String getMysqlValue(String file,String key){
		ResourceBundle rb = ResourceBundle.getBundle(file, Locale.CHINESE);
		return rb.getString(key);
	}

	private Properties pros = null;  

	private static class ConfigurationHolder{  
		private static ReadProperties configuration = new ReadProperties();  
	}  

	public static ReadProperties getInstance(){  
		return ConfigurationHolder.configuration;  
	}  

	public String getValue(String key){  
		return pros.getProperty(key);  
	}  

	private ReadProperties(){  
		readConfig();  
	}  

	private void readConfig() {  
		pros = new Properties();          
		InputStream in = null;  
		try {
			in = new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("").getPath() + "system.properties");
			pros.load(in);  
		} catch (FileNotFoundException e) {  
			e.printStackTrace();  
		}catch (IOException e) {  
			e.printStackTrace();  
		}finally{  
			try {  
				in.close();  
			} catch (IOException e) {  
				e.printStackTrace();  
			}  
		}  
	}

	public Map<String,String> getPropertiesMap(){
		Map<String,String> map = new HashMap<String, String>();

		for (Entry<Object, Object> entry : pros.entrySet()) {
			map.put(entry.getKey().toString(),entry.getValue().toString());
		}

		return map;
	}
	
	public final static String PROTOCOL = "protocol";
	public final static String CITY_CODE = "city_code";
	public final static String LICENSE_COLOR = "license_color";
	public final static String VEHICLE_COLOR = "vehicle_color";
	public final static String PURPOSE_CODE = "purpose_code";
	
	public final static String BAIDU_MAP_AK="baidu.map.ak";
	
	public  String getValue(String key,String type){
		String value = pros.getProperty(type+"."+key);
		if(!StringUtil.isNotEmpty(value)){
			value = pros.getProperty(type+".default");
		}
		return value;
	}
	
	public static void main(String[] args) {
		long startTime=System.currentTimeMillis(); //获取结束时间
		
		ReadProperties read = ReadProperties.getInstance();
		for(int i=0;i<100000;i++){
			System.out.println(read.getValue("init.userAccount"));
		}
		
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");		
		
	}

}
