package pers.sakurasora.onlinestore.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 
 * 
 * @Description
 *				文件上传工具类
 */
public class UploadUtil {
	
	public static void main(String[] args) {
		// String s="G:\\day17-基础加强\\resource\\1.jpg";
		String s="1";
		String realName = getRealName(s);
		System.out.println(realName);
		
		String uuidName = getUUIDName(realName);
		System.out.println(uuidName);
		
		String dir = getDir();
		System.out.println(dir);
	}
	
	/**
	 * 获取文件真实名称（可能带路径）
	 * 由于浏览器的不同获取的名称可能为:c:/upload/1.jpg或者1.jpg 
	 * 最终获取的为  1.jpg
	 * @param name 	上传上来的文件名称
	 * @return		真实名称
	 */
	public static String getRealName(String name){
		int index = name.lastIndexOf("\\"); //获取最后一个"/"
		return name.substring(index+1);
	}
	
	
	/**
	 * 获取随机名称
	 * @param realName 	真实名称
	 * @return uuid 	随机名称
	 */
	public static String getUUIDName(String realName){
		//realname  可能是  1.jpg   也可能是  1
		int index = realName.lastIndexOf("."); // 获取后缀名
		if(index == -1){
			return UUID.randomUUID().toString().replace("-", "").toUpperCase();
		}else{
			return UUID.randomUUID().toString().replace("-", "").toUpperCase() + realName.substring(index);
		}
	}
	
	/**
	 * 获取文件目录,可以获取256个随机目录
	 * @return 随机目录
	 */
	public static String getDir(){
		String str = "0123456789ABCDEF";
		Random random = new Random();
		return "/"+str.charAt(random.nextInt(16))+"/"+str.charAt(random.nextInt(16));
	}
	
}
