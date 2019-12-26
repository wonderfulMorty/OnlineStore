package pers.sakurasora.onlinestore.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.print.DocFlavor.STRING;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * 
 * @Description 
 *             	数据源及事务工具类;
 *             	支持当前线程开启事务时使用相同的Connection对象
 */
public class DataSourceUtil_C3P0{
	/**
	 * C3P0数据源对象
	 */
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	/**
	 * 用于存放数据库连接的当前线程局部变量
	 */
	private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();
	
	/**
	 * 获取数据源
	 * 
	 * @return 
	 * 			成功--连接池数据源对象<br>
	 * 			失败--null
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 从当前线程局部变量中获取数据库连接
	 * 
	 * @return 
	 * 			成功--连接池数据源对象<br>
	 * 			失败--null
	 * @throws 	SQLException
	 */
	public static Connection getConnection() 
		throws SQLException {
		Connection con = connectionThreadLocal.get();
		/**
		 * 若是第一次获取，需要从连接池中获取一个连接;
		 * 将这个连接和当前线程绑定
		 */
		if (con == null) {
			con = dataSource.getConnection();
			connectionThreadLocal.set(con);
		}
		return con;
	}
	
	/**
	 * 释放资源
	 * 
	 * @param 	con 连接
	 * @param 	st 语句执行者
	 * @param 	pst 预处理语句执行者
	 * @param 	rs 结果集
	 * @throws 	SQLException 
	 */
	public static void releaseResource(Connection con,Statement st,PreparedStatement pst,ResultSet rs)
		throws SQLException {
		closeResultSet(rs);
		closeStatement(st);
		closePreparedStatement(pst);
		closeConnection(con);
	}
	
	/**
	 * 释放连接并和当前线程解绑
	 * 
	 * @param 	con 连接
	 * @throws 	SQLException 
	 */
	public static void closeConnection(Connection con)
		throws SQLException {
		if (con != null) {
			con.close();
			connectionThreadLocal.remove(); // 和当前线程解绑
			con = null;
		}
	}
	
	/**
	 * 释放语句执行者
	 * 
	 * @param 	st 语句执行者
	 * @throws 	SQLException 
	 */
	public static void closeStatement(Statement st)
		throws SQLException {
		if (st != null) {
			st.close();
			st = null;
		}
	}
	
	/**
	 * 释放预处理语句执行者
	 * 
	 * @param 	pst 预处理语句执行者
	 * @throws 	SQLException 
	 */
	public static void closePreparedStatement(PreparedStatement pst)
		throws SQLException {
		if (pst != null) {
			pst.close();
			pst = null;
		}
	}
	
	/**
	 * 释放结果集
	 * 
	 * @param 	rs 结果集
	 * @throws 	SQLException 
	 */
	public static void closeResultSet(ResultSet rs)
		throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
	}
	
	/**
	 * 开始事务
	 * 
	 * @throws SQLException
	 */
	public static void startTransaction()
		throws SQLException {
		/**
		 * 1. 获取当前数据库连接
		 * 2. 关闭自动提交
		 */
		Connection connection = getConnection();
		connection.setAutoCommit(false);
	}
	
	/**
	 * 提交事务并释放连接
	 * 
	 * @throws SQLException 
	 */
	public static void commitTransaction() 
		throws SQLException {
			/**
			 * 1. 获取当前数据库连接
			 * 2. 手动提交事务
			 * 3. 关闭且移除
			 */
			Connection connection = getConnection();
			connection.commit();
			closeConnection(connection);	
	}
	
	/**
	 * 回滚事务并释放连接
	 * 
	 * @throws SQLException 
	 */
	public static void rollbackTransaction()
		throws SQLException {		
			/**
			 * 1. 获取当前数据库连接
			 * 2. 回滚事务
			 * 3. 关闭且移除数据库连接
			 */
			Connection connection = getConnection();
			connection.rollback();
			closeConnection(connection);		
	}
}
