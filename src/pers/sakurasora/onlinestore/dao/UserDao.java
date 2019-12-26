package pers.sakurasora.onlinestore.dao;

import pers.sakurasora.onlinestore.entity.User;

/**
 * 
 * 
 * @Description
 *				Dao层接口--操作t_user表
 */
public interface UserDao {
	
	/**
	 * 根据用户名查询用户
	 * @param 	sAccount 用户名
	 * @return
	 * @throws 	Exception
	 */
	public User getUserByAccount(String sAccount) throws Exception;
	
	/**
	 * 根据邮箱查询用户
	 * @param sEmail 邮箱
	 * @return
	 * @throws Exception
	 */
	public User getUserByEmail(String sEmail) throws Exception;

	/**
	 * 添加用户
	 * @param 	user 用户对象
	 * @throws 	Exception
	 */
	public void add(User user) throws Exception;

	



	/**
	 * 根据用户名和密码查找用户
	 * @param 	sAccount 	用户名
	 * @param 	sPassword 	密码
	 * @return
	 * @throws 	Exception
	 */
	public User getUserByAccountAndPassword(String sAccount, String sPassword) throws Exception;
}
