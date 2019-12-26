package pers.sakurasora.onlinestore.service;

import pers.sakurasora.onlinestore.entity.Administrator;

/**
 * 
 * 
 * @Description
 *				业务逻辑层接口--管理员模块
 */
public interface AdminService {
	/**
	 * 管理员登录
	 * @param 	sAccount 	账号
	 * @param 	sPassword 	密码
	 * @return	Administrator
	 * @throws 	Exception
	 */
	public Administrator login(String sAccount, String sPassword) throws Exception;
}
