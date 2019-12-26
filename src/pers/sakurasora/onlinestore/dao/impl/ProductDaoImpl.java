package pers.sakurasora.onlinestore.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import pers.sakurasora.onlinestore.constant.Constant;
import pers.sakurasora.onlinestore.dao.ProductDao;
import pers.sakurasora.onlinestore.entity.PageBean;
import pers.sakurasora.onlinestore.entity.Product;
import pers.sakurasora.onlinestore.utils.DataSourceUtil_C3P0;

/**
 * 
 * 
 * @Description
 *				Dao层实现类--操作t_product表
 */
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> findHotProduct() 
			throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_product where is_hot=? and is_down=? and stock>0 order by shelf_time desc limit ?";
		return queryRunner.query(sql, new BeanListHandler<>(Product.class), Constant.PRODUCT_IS_HOT,Constant.PRODUCT_IS_NOT_DOWN,Constant.LIMIT_NUM);
	}

	@Override
	public List<Product> findNewProduct() 
			throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_product where is_down=? and stock>0 order by shelf_time desc limit ?";
		return queryRunner.query(sql, new BeanListHandler<>(Product.class),Constant.PRODUCT_IS_NOT_DOWN,Constant.LIMIT_NUM);
	}

	@Override
	public Product getProductById(String sId) 
			throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_product where id=? limit 1";
		return queryRunner.query(sql, new BeanHandler<>(Product.class), sId);
	}

	@Override
	public List<Product> findProductByPage(PageBean<Product> productPageBean, int iCategoryId) 
			throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_product where category_id=? and is_down=? and stock>0 order by shelf_time desc limit ?,?";
		return queryRunner.query(sql, new BeanListHandler<>(Product.class), iCategoryId,Constant.PRODUCT_IS_NOT_DOWN,productPageBean.getStartIndex(),productPageBean.getPageSize());
	}
	
	@Override
	public int getTotalRecordByCategoryId(int iCategoryId)
			throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select count(*) from t_product where category_id=? and is_down=? and stock>0";
		/*
		 * ScalarHandler：	将单个值封装（例如select count(*)，求内容的条数）
		 * Long.intValue()：	将Long转为int
		 */
		return ((Long) queryRunner.query(sql, new ScalarHandler(), iCategoryId,Constant.PRODUCT_IS_NOT_DOWN)).intValue();
	}

	@Override
	public void updateStockById(int iStock, int iId) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql="update t_product set stock = ? where id = ?";
		queryRunner.update(sql,iStock,iId);
	}

	@Override
	public List<Product> findAll() throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_product where is_down = ? order by shelf_time desc";
		return queryRunner.query(sql, new BeanListHandler<>(Product.class), Constant.PRODUCT_IS_NOT_DOWN);
	}

	@Override
	public void updateDownFlag(int iProductId) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "update t_product set is_down = ? where id = ?";
		queryRunner.update(sql, Constant.PRODUCT_IS_DOWN,iProductId);
	}
	
	@Override
	public void add(Product product) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql="insert into t_product(category_id,product_name,market_price,mall_price,image,description,shelf_time,is_hot,is_down,stock) values(?,?,?,?,?,?,?,?,?,?);";
		queryRunner.update(sql, product.getCategory().getId(),product.getProduct_name(),product.getMarket_price(),product.getMall_price(),product.getImage(),product.getDescription(),product.getShelf_time(),product.getIs_hot(),product.getIs_down(),product.getStock());
	}

	@Override
	public List<Product> findByPages(int pageIndex, int pageSize) throws Exception {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		int p1 = (pageIndex-1)*pageSize;
		int p2 =pageSize;
		String sql = "select * from t_product where is_down = ? order by shelf_time desc limit ?,?";
		System.out.println("p1:"+p1+",p2:"+p2);
		return queryRunner.query(sql, new BeanListHandler<>(Product.class), Constant.PRODUCT_IS_NOT_DOWN,p1,p2);
	}
	
}
