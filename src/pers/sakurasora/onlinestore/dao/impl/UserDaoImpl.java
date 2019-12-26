package pers.sakurasora.onlinestore.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.sakurasora.onlinestore.dao.UserDao;
import pers.sakurasora.onlinestore.entity.User;
import pers.sakurasora.onlinestore.utils.DataSourceUtil_C3P0;

/**
 * 
 * 
 * @Description
 *				Dao层接口实现类--操作t_user表
 */
public class UserDaoImpl implements UserDao{

	@Override
	public User getUserByAccount(String sAccount) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_user where account=? limit 1";
		return queryRunner.query(sql, new BeanHandler<>(User.class), sAccount);
	}

	@Override
	public User getUserByEmail(String sEmail) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_user where email=?  limit 1";
		return queryRunner.query(sql, new BeanHandler<>(User.class), sEmail);
	}
	
	@Override
	public void add(User user)
			throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sSql = "insert into t_user(account,password,name,sex,email,telephone,birthday) values(?,MD5(?),?,?,?,?,?)"; // 插入密码时使用MySQL中的MD5函数
		queryRunner.update(sSql, user.getAccount(),user.getPassword(),user.getName(),user.getSex(),user.getEmail(),user.getTelephone(),user.getBirthday());
	}

	

	@Override
	public User getUserByAccountAndPassword(String sAccount, String sPassword) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_user where account=? and password=MD5(?) limit 1";
		return queryRunner.query(sql, new BeanHandler<>(User.class), sAccount,sPassword);
	}

	

}
