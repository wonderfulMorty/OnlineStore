package pers.sakurasora.onlinestore.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.sakurasora.onlinestore.dao.AdminDao;
import pers.sakurasora.onlinestore.entity.Administrator;
import pers.sakurasora.onlinestore.utils.DataSourceUtil_C3P0;

/**
 * 
 * 
 * @Description
 *				Dao层实现类--操作t_administrator表
 */
public class AdminDaoImpl implements AdminDao {

	@Override
	public Administrator getAdminByAccountAndPassword(String sAccount, String sPassword) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_administrator where account=? and password=MD5(?) limit 1";
		return queryRunner.query(sql, new BeanHandler<>(Administrator.class), sAccount,sPassword);
	}

}
