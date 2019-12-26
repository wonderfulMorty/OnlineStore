package pers.sakurasora.onlinestore.utils;

import javax.servlet.http.Cookie;

/**
 * 
 * 
 * @Description
 *				通过名称在cookie数组获取指定的cookie
 */
public class CookUtil {
	
	/**
	 * 通过名称在cookie数组获取指定的cookie
	 * 
	 * @param 	name 指定名称
	 * @param 	cookies cookie数组
	 * @return
	 * 			成功--cookie<br>
	 * 			失败--null
	 */
	public static Cookie getCookieByName(String name, Cookie[] cookies) {
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
	
}
