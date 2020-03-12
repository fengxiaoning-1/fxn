package com.yxb.cms.util.excel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 读取Excel
 * 
 */
public class ReadExcelUtils {
	private Logger logger = LoggerFactory.getLogger(ReadExcelUtils.class);
	private Workbook wb;
	private Sheet sheet;
	private Row row;

	public ReadExcelUtils(String filepath) {
		if(filepath==null){
			return;
		}
		filepath = "C:\\Users\\JiangYuCong\\Desktop\\力帆乘用车有限公司北碚分公司复工人员总名单0309.xlsx";
		String ext = filepath.substring(filepath.lastIndexOf("."));
		File a = new File(filepath);
		try {
			InputStream is = new FileInputStream(filepath);
			if(".xls".equals(ext)){
				wb = new HSSFWorkbook(is);
			}else if(".xlsx".equals(ext)){
				wb = new XSSFWorkbook(is);
			}else{
				wb=null;
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		}
	}

	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param InputStream
	 * @return String 表头内容的数组
	 */
	public String[] readExcelTitle() throws Exception{
		if(wb==null){
			throw new Exception("Workbook对象为空！");
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			// title[i] = getStringCellValue(row.getCell((short) i));
			title[i] = row.getCell(i).getCellFormula();
		}
		return title;
	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 */
	public Map<Integer, Map<Integer,Object>> readExcelContent() throws Exception{
		if(wb==null){
			throw new Exception("Workbook对象为空！");
		}
		Map<Integer, Map<Integer,Object>> content = new HashMap<Integer, Map<Integer,Object>>();

		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			Map<Integer,Object> cellValue = new HashMap<Integer, Object>();
			while (j < colNum) {
				Object obj = getCellFormatValue(row.getCell(j));
				cellValue.put(j, obj);

				j++;
			}
			content.put(i, cellValue);
		}
		return content;
	}


	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 * @param <T>
	 */
	public <T> List<T> parseExcelContent(ParserExcel parserExcel) throws Exception{

		List<T> list = new ArrayList<T>();
		if(wb==null){
			throw new Exception("Workbook对象为空！");
		}
		Map<Integer, Map<Integer,Object>> content = new HashMap<Integer, Map<Integer,Object>>();

		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			T t = parserExcel.parse(colNum,row);
			list.add(t);
		}
		//		return content;
		return list;
	}

	/**
	 * 
	 * 根据Cell类型设置数据
	 * 
	 * @param cell
	 * @return
	 */
	public static Object getCellFormatValue(Cell cell) {
		Object cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
			case Cell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (DateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式
					// data格式是带时分秒的：2013-7-10 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();
					// data格式是不带带时分秒的：2013-7-10
					Date date = cell.getDateCellValue();
					cellvalue = date;
				} else {// 如果是纯数字

					// 取得当前Cell的数值
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			default:// 默认的Cell值
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}


	//生成文件路径
	private static String path = "D:\\file\\";

	//文件路径+名称
	private static String filenameTemp;
	/**
	 * 创建文件
	 * @param fileName  文件名称
	 * @param filecontent   文件内容
	 * @return  是否创建成功，成功则返回true
	 */
	public static boolean createFile(String fileName,String filecontent){
		Boolean bool = false;
		filenameTemp = path+fileName+".txt";//文件路径+名称+文件类型
		File file = new File(filenameTemp);
		try {
			//如果文件不存在，则创建新的文件
			if(!file.exists()){
				file.createNewFile();
				bool = true;
				System.out.println("success create file,the file is "+filenameTemp);
				//创建文件成功后，写入内容到文件里
				writeFileContent(filenameTemp, filecontent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bool;
	}

	/**
	 * 向文件中写入内容
	 * @param filepath 文件路径与名称
	 * @param newstr  写入的内容
	 * @return
	 * @throws IOException
	 */
	public static boolean writeFileContent(String filepath,String newstr) throws IOException{
		Boolean bool = false;
		String filein = newstr+"\r\n";//新写入的行，换行
		String temp  = "";

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileOutputStream fos  = null;
		PrintWriter pw = null;
		try {
			File file = new File(filepath);//文件路径(包括文件名称)
			//将文件读入输入流
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();

			//文件原有内容
			for(int i=0;(temp =br.readLine())!=null;i++){
				buffer.append(temp);
				// 行与行之间的分隔符 相当于“\n”
				buffer = buffer.append(System.getProperty("line.separator"));
			}
			buffer.append(filein);

			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buffer.toString().toCharArray());
			pw.flush();
			bool = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//不要忘记关闭
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
		return bool;
	}

	/**
	 * 删除文件
	 * @param fileName 文件名称
	 * @return
	 */
	public static boolean delFile(String fileName){
		Boolean bool = false;
		filenameTemp = path+fileName+".txt";
		File file  = new File(filenameTemp);
		try {
			if(file.exists()){
				file.delete();
				bool = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bool;
	}
	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		createFile(uuid+"myfile", "我的梦说别停留等待,就让光芒折射泪湿的瞳孔,映出心中最想拥有的彩虹,带我奔向那片有你的天空,因为你是我的梦 我的梦");

		//	        try {
		//				String filepath = "E://1.xlsx";
		//				
		//				ReadExcelUtils excelReader = new ReadExcelUtils(filepath);
		//				List<VehicleDto> list = excelReader.parseExcelContent(new ParserVehicleExcel());
		//				
		//				System.out.println(list.size());
		//				
		//				
		//				// 对读取Excel表格标题测试
		////				String[] title = excelReader.readExcelTitle();
		////				System.out.println("获得Excel表格的标题:");
		////				for (String s : title) {
		////					System.out.print(s + " ");
		////				}
		//				
		//				// 对读取Excel表格内容测试
		//				Map<Integer, Map<Integer,Object>> map = excelReader.readExcelContent();
		//				System.out.println("获得Excel表格的内容:");
		//				for (int i = 1; i <= map.size(); i++) {
		//					System.out.println(map.get(i));
		//				}
		//			} catch (FileNotFoundException e) {
		//				System.out.println("未找到指定路径的文件!");
		//				e.printStackTrace();
		//			}catch (Exception e) {
		//				e.printStackTrace();
		//			}

	}
}
