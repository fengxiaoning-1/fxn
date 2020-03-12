package com.yxb.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yxb.cms.domain.condition.EpidemicCondition;
import com.yxb.cms.domain.page.Page;
import com.yxb.cms.domain.page.PagedResult;
import com.yxb.cms.domain.vo.Epidemic;
import com.yxb.cms.domain.vo.UserPark;
import com.yxb.cms.service.EpidemicService;
import com.yxb.cms.service.UserParkService;
import com.yxb.cms.util.ConstUtils;
import com.yxb.cms.util.excel.ParserEpidemicExcel;
import com.yxb.cms.util.excel.ReadExcelUtils;

@Controller
@RequestMapping("epidemic")
public class EpidemicController {

	private Logger logger = LogManager.getLogger(EpidemicController.class);

	@Autowired
	private EpidemicService epidemicService;

	@Autowired
	private UserParkService userParkService;

	@RequestMapping(value = "/toList")
	public String toEpidemicPage() {
		return "yiqingManager/epidemic_list";
	}

	@ResponseBody
	@RequestMapping(value = "/list")
	public String list(EpidemicCondition condition, Page page) {
		PagedResult<Epidemic> pagedResult = epidemicService.getEpidemics(condition, page);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pagedResult.getTotal());
		map.put("data", pagedResult.getData());

		return Json.toJson(map);
	}

	@RequestMapping(value = "toAdd")
	public String toEpidemicAdd() {
		return "yiqingManager/epidemic_add";
	}

	@RequestMapping(value = "add")
	public int addEpidemic(Epidemic epidemic) {
		return epidemicService.addEpidemic(epidemic);
	}

	@RequestMapping(value = "toImport")
	public String toEpidemicImport() {
		return "yiqingManager/epidemic_import";
	}

	@RequestMapping(value = "/uploadEpidemicXls")
	@ResponseBody
	public String uploadEpidemicXls(@RequestParam("parkId") Integer parkId, @RequestParam("parkName") String parkName,
			@RequestParam("file") MultipartFile file) {
		
		//判空
		if(file.isEmpty()){
			return "";
		}
		String path=ConstUtils.FILE_PATH+new Date().getTime()+file.getOriginalFilename();
		uploadXls(file,path);

		ReadExcelUtils excelReader = new ReadExcelUtils(path);
		try {
			List<Epidemic> list = excelReader.parseExcelContent(new ParserEpidemicExcel());
			
			if(null != list) {
				for (Epidemic epidemic : list) {
					Epidemic e = epidemicService.selectByidCard(epidemic.getIdCard());
					if(null != e) {
						epidemicService.updateEpidemic(epidemic);
					} else {
						epidemicService.addEpidemic(epidemic);
					}
					
					UserPark userPark = userParkService.selectByPhoneAndParkId(epidemic.getPhoneNumber(),parkId);
					UserPark up = new UserPark(); 
					up.setTruename(epidemic.getName());
					up.setPhone(epidemic.getPhoneNumber()); 
					up.setParkid(parkId);
					up.setParkname(parkName); 
					up.setRolecode("passerby"); 
					up.setIscheck(1);
					up.setCompanyName(epidemic.getCompany());
					up.setDeptname(epidemic.getDepartment());
					userParkService.addUserPark(userPark);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "/error";
		}

		return "/success"; 
	}

	private void uploadXls(MultipartFile file, String path) {
		long startTime = System.currentTimeMillis();
		System.out.println("fileName：" + file.getOriginalFilename());

		File newFile = new File(path);
		// 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
		try {
			file.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("运行时间：" + String.valueOf(endTime - startTime) + "ms");
	}
}
