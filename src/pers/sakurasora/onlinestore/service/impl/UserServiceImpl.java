package pers.sakurasora.onlinestore.service.impl;

import pers.sakurasora.onlinestore.constant.Constant;
import pers.sakurasora.onlinestore.dao.UserDao;
import pers.sakurasora.onlinestore.dao.impl.UserDaoImpl;
import pers.sakurasora.onlinestore.entity.User;
import pers.sakurasora.onlinestore.service.UserService;

/**
 * 
 * 
 * @Description
 *				业务逻辑层接口实现类--用户模块
 */
public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User verifyAccount(String sAccount) 
			throws Exception {
		return userDao.getUserByAccount(sAccount);
	}

	@Override
	public User verifyEmail(String sEmail) 
			throws Exception {
		return userDao.getUserByEmail(sEmail);
	}
	
	@Override
	public void regist(User user)
			throws Exception {
		/**
		 * 1. 调用DAO保存用户信息完成注册
		 * 2. 发送激活邮件
		 */
		userDao.add(user);
		
	}

	

	@Override
	public User login(String sAccount, String sPassword) 
			throws Exception {
		return userDao.getUserByAccountAndPassword(sAccount,sPassword);
	}

}
