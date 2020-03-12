/**  
 * @Title:  ParserExcel.java   
 * @Package com.woasis.iov.console.util.excel   
 * @Description:
 * @author: lws     
 * @date:   2017年5月5日 下午2:26:26   
 */  
package com.yxb.cms.util.excel;

import org.apache.poi.ss.usermodel.Row;

public interface ParserExcel {
	public <T> T parse( Integer colNum,Row row);
}
