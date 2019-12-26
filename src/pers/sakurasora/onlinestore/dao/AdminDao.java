package pers.sakurasora.onlinestore.dao;

import pers.sakurasora.onlinestore.entity.Administrator;

/**
 * 
 * 
 * @Description
 *				Dao层接口--操作t_administrator表
 */
public interface AdminDao {
	/**
	 * 根据账号和密码查找管理员
	 * @param 	sAccount 	账号
	 * @param 	sPassword 	密码
	 * @return	Administrator
	 * @throws 	Exception
	 */
	public Administrator getAdminByAccountAndPassword(String sAccount, String sPassword) throws Exception;
}
