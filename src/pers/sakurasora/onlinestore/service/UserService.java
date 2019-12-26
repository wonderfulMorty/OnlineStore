package pers.sakurasora.onlinestore.service;

import pers.sakurasora.onlinestore.entity.User;

/**
 * 
 * 
 * @Description
 *				业务逻辑层接口--用户模块
 */
public interface UserService {
	
	/**
	 * 验证用户名是否已存在
	 * @param sAccount 用户名
	 * @return
	 * @throws Exception
	 */
	public User verifyAccount(String sAccount) throws Exception;
	
	/**
	 * 验证邮箱是否已存在
	 * @param sEmail 邮箱
	 * @return
	 * @throws Exception
	 */
	public User verifyEmail(String sEmail) throws Exception;

	/**
	 * 用户注册
	 * @param 	user 用户信息对象
	 * @throws 	Exception 
	 */
	public void regist(User user) throws Exception;

	

	/**
	 * 用户登录
	 * @param 	sAccount 	用户名
	 * @param 	sPassword 	密码
	 * @return	User
	 * @throws 	Exception
	 */
	public User login(String sAccount, String sPassword) throws Exception;

}
