package pers.sakurasora.onlinestore.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 
 * 
 * @Description 使用UUID生成唯一标识码
 * 			 <p>java.util.UUID类表示一个不变的通用唯一标识符（UUID）<br>
 *				0-9，a-f的十六进制<br>
 *				UUID的唯一缺陷在于生成的结果串会比较长</p>
 */
public class UUIDUtil {
	public static void main(String[] args) {
		System.out.println(getCode());
		System.out.println(getOrderId());
	}
	
	/**
	 * 生成随机激活码
	 * 
	 * @return 激活码
	 */
	public static String getCode(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase(); // 去掉"-“，小写改为大写
	}
	
	/**
	 * 生成唯一订单号
	 * @param iUserId 用户编号
	 * @return
	 */
	public static String getOrderId(){
		int iHashCode = UUID.randomUUID().toString().hashCode();
		if (iHashCode < 0)
			iHashCode = -iHashCode;
		String sHashCode = String.valueOf(iHashCode);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String sDate = formatter.format(new Date());
		
		return sHashCode + sDate;
	}
	
//	/**
//	 * 生成唯一订单号（用户编号+yyyyMMddHHmmss）
//	 * @param iUserId 用户编号
//	 * @return
//	 */
//	public static String getOrderId(int iUserId){
//		String sUserId = String.valueOf(iUserId);
//		
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//		String sDate = formatter.format(new Date());
//		
//		return sUserId + sDate;
//	}
}
