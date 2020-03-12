/**  
 * @Title:  ObjUtil.java   
 * @Package com.woasis.iov.customer.util   
 * @Description:
 * @author: lws     
 * @date:   2017年5月24日 上午10:44:35   
 */  
package com.yxb.cms.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.nustaq.serialization.FSTObjectInput;
import org.nustaq.serialization.FSTObjectOutput;

import com.mysql.jdbc.StringUtils;

public class ObjectUtil {

	final static Logger log = LogManager.getLogger(ObjectUtil.class);
	private static Object o;
	
	public static <T> T unserializeT(final byte[] bytes){
		if(ObjectUtil.isNotEmpty(bytes)){
			ByteArrayInputStream bais = null;
			try {
				bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais);
				T t =   (T) ois.readObject(); 
				return t;
			} catch (Exception e) {

			} 
		}
		return null;
	}

	
	public static byte[] getByte(Integer integer){
		return (integer.toString()).getBytes();
	}

	public static byte[] getByte(String obj){
		return obj.getBytes();
	}
	
	public static byte[] getByte(Object obj){
		return (obj.toString()).getBytes();
	}

	public static String getString(Object id){
		if(id==null){
			return null;
		}
		return id.toString();
	}

	public static String getString(byte[] b){
		return new String(b);
	}

	public static boolean isEmpty(Object...objects ){
		if(objects==null || objects.length ==0){
			return true;
		}
		for (Object object : objects) {
			if(isEmpty(object)){
				return true;
			}
		}
		return false;
	}

	private static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		if (obj instanceof String)
			return StringUtils.isEmptyOrWhitespaceOnly((String) obj);
		if (obj instanceof Collection && ((Collection<?>) obj).isEmpty() && ((Collection<?>) obj).size()<=0)
			return true;
		if (obj.getClass().isArray() && Array.getLength(obj) == 0)
			return true;
		if (obj instanceof Map && ((Map<?, ?>) obj).isEmpty())
			return true;
		return false;
	}

	public static boolean isNotEmpty(Object... obj){
		return !isEmpty(obj);
	}

	public static boolean isNotEmpty(Object obj){
		return !isEmpty(obj);
	}

	public static byte[] serialize(Object obj) {
		return fstSerialize(obj);
		//return kryoSerizlize(obj);
		//return jdkSerialize(obj);
	}

	public static <T> T deserialize(byte[] sec) {
		return (T)fstDeSerialize(sec);
		//return kryoDeSerizlize(sec);
		//return jdkDeSerialize(sec);
	}

	public static byte[] fstSerialize(Object obj) {
		ByteArrayOutputStream out = null;
		FSTObjectOutput fout = null;
		try {
			out = new ByteArrayOutputStream();
			fout = new FSTObjectOutput(out);
			fout.writeObject(obj);
			fout.flush();
			return out.toByteArray();
		}
		catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
		finally {
			if (fout != null)
				try {
					fout.close();
				}
			catch (IOException e) {
			}
		}
	}

	public static Object fstDeSerialize(byte[] bytes) {
		if (bytes == null || bytes.length == 0)
			return null;
		FSTObjectInput in = null;
		try {
			in = new FSTObjectInput(new ByteArrayInputStream(bytes));
			return in.readObject();
		}
		catch (ClassNotFoundException e) {
			log.error(e.getMessage());
			return null;
		}
		catch (IOException e) {
			log.error(e.getMessage());
			return null;
		}
		finally {
			if (in != null)
				try {
					in.close();
				}
			catch (IOException e) {
				log.error(e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		//		VehicleDto vo = new VehicleDto();
		//		vo.setVin("123");
		//		
		//		
		//		VehicleDto dto = unserializeT(serialize(vo));
		//		System.out.println(dto.getVin());
	}


	public static String ObjectToJSONString(Object obj){
		JSONObject s = JSONObject.fromObject(obj);
		return s.toString();
		
	}
	

	@SuppressWarnings("unchecked")
	public static <T> T JSONStringToObject(String json, Class<T> c ){
		JSONObject jsonObject=JSONObject.fromObject(json);
		T t = (T) JSONObject.toBean(jsonObject,c);
		return t;
	}

	//根据List<Key>获取二元数组
	public static byte[][] getByteDyadicArray(Set<String> set){
		if(ObjectUtil.isNotEmpty(set)){
			byte[][] byteArr = new byte[set.size()][];
			int i = 0;
			for (String str : set) {
				byte[] b = ObjectUtil.getByte(str);
				byteArr[i] = b;
				i++;
			}
			return byteArr; 
		}
		return null;
	}

	public static byte[][] getByteArrByStrList(List<String> list){
		if(list!=null && list.size()>0){
			byte[][] byteArr = new byte[list.size()][] ;
			for(int i=0;i<list.size();i++){
				if(null !=list.get(i)){
					byteArr[i]=getByte(list.get(i));
				}
			}
			return byteArr;
		}
		return null;
	}

	public static byte[][] getByteArrByStrSet(Set<String> set){
		if(set!=null && set.size()>0){
			List<String> list = new ArrayList<String>(set);
			byte[][] byteArr = new byte[list.size()][] ;
			for(int i=0;i<list.size();i++){
				if(null !=list.get(i)){
					byteArr[i]=getByte(list.get(i));
				}
			}
			return byteArr;
		}
		return null;
	}
}
