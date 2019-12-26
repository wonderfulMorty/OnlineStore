package pers.sakurasora.onlinestore.service.impl;

import pers.sakurasora.onlinestore.dao.AdminDao;
import pers.sakurasora.onlinestore.dao.impl.AdminDaoImpl;
import pers.sakurasora.onlinestore.entity.Administrator;
import pers.sakurasora.onlinestore.service.AdminService;

/**
 * 
 * 
 * @Description
 *				业务逻辑层实现类--管理员模块
 */
public class AdminServiceImpl implements AdminService {
	private AdminDao adminDao = new AdminDaoImpl();

	@Override
	public Administrator login(String sAccount, String sPassword) throws Exception {
		return adminDao.getAdminByAccountAndPassword(sAccount, sPassword);
	}

}
