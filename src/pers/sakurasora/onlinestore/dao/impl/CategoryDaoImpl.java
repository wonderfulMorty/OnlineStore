package pers.sakurasora.onlinestore.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pers.sakurasora.onlinestore.dao.CategoryDao;
import pers.sakurasora.onlinestore.entity.Category;
import pers.sakurasora.onlinestore.utils.DataSourceUtil_C3P0;

/**
 * 
 * 
 * @Description
 *				Dao层实现类--操作t_category表
 */
public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAll() 
			throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_category";
		return queryRunner.query(sql, new BeanListHandler<>(Category.class));
	}

	@Override
	public void add(Category category) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "insert into t_category(name) values (?);";
		queryRunner.update(sql, category.getName());
	}

	@Override
	public void delete(int iCategoryId) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "delete from t_category where id = ?;";
		queryRunner.update(sql, iCategoryId);
	}

}
