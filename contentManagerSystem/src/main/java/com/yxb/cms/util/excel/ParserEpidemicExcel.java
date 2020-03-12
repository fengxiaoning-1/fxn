/**  
 * @Title:  ParserVehicleExcel.java   
 * @Package com.woasis.iov.console.util.excel   
 * @Description:
 * @author: lws     
 * @date:   2017年5月5日 下午2:27:57   
 */  
package com.yxb.cms.util.excel;

import org.apache.poi.ss.usermodel.Row;

import com.yxb.cms.domain.vo.Epidemic;


public class ParserEpidemicExcel implements ParserExcel {

	/**
	 * Title: parse
	 * Description: 
	 * @param colNum
	 * @param row
	 * @return  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Epidemic parse(Integer colNum, Row row) {
		Epidemic epidemic = new Epidemic();
		
		int j = 0;
		while (j < colNum) {
			Object obj = ReadExcelUtils.getCellFormatValue(row.getCell(j));
			if(obj!=null){
				getParam(epidemic,j,obj);
			}
			j++;
		}
		return epidemic;
	}

	public void getParam(Epidemic epidemic, Integer index,Object o){
		switch(index) { 
		case 1:	//单位
			String company = (String) o;
			epidemic.setCompany(company);
			break;
		case 2: //部门
			String department = (String) o;
			epidemic.setDepartment(department);
			break;
		case 3: //姓名
			String name = (String) o;
			epidemic.setName(name);
			break; 
		case 4: //身份证
			String idCard = (String) o;
			epidemic.setIdCard(idCard);
			break; 
		case 5: //户籍地址
			String permanentAddress = (String)o;
			epidemic.setPermanentAddress(permanentAddress);
			break; 
		case 6: //长期居住地
			String address = (String)o;
			epidemic.setAddress(address);
			break; 
		case 7: //手机号
			String phoneNumber = (String)o;
			epidemic.setPhoneNumber(phoneNumber);
			break; 
		case 8: //类别
			String category = (String)o;
			epidemic.setCategory(category);
			break; 
		case 9: //类型
			String type = (String)o;
			epidemic.setType(type);
			break; 
		case 10: //身体状况
			String health = (String)o;
			epidemic.setHealth(health);
			break; 
		case 11: //目前所在地
			String currentLocation = (String)o;
			epidemic.setCurrentLocation(currentLocation);
			break; 
		case 12: //放假期间在家/外出
			String duration = (String)o;
			epidemic.setDuration(duration);
			break; 
		case 13:  //离开日期
			String leaveDate = (String)o;
			epidemic.setLeaveDate(leaveDate);
			break; 
		case 14: //离碚目的地(市内)
			String leaveDestinationInside = (String)o;
			epidemic.setLeaveDestinationInside(leaveDestinationInside);
			break; 
		case 15: //离碚目的地(市外)
			String leaveDestinationOutside = (String)o;
			epidemic.setLeaveDestinationOutside(leaveDestinationOutside);
			break; 
		case 16: //离碚交通工具
			String leaveVehicle = (String)o;
			epidemic.setLeaveVehicle(leaveVehicle);
			break; 
		case 17: //返渝日期
			String returnDate = (String)o;
			epidemic.setReturnDate(returnDate);
			break; 
		case 18://返渝交通工具
			String returnVehicle = (String)o;
			epidemic.setReturnVehicle(returnVehicle);
			break;
		case 19://接触情况
			String contactSituation = (String)o;
			epidemic.setContactSituation(contactSituation);
			break;
		case 20://签字
			String sign = (String)o;
			epidemic.setSign(sign);
			break;
		case 21://备注
			String remarks = (String)o;
			epidemic.setRemarks(remarks);
			break;
		default:
			break;
		}
		
		
	}

}
