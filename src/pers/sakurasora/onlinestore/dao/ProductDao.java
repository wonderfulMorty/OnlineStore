package pers.sakurasora.onlinestore.dao;

import java.util.List;

import pers.sakurasora.onlinestore.entity.Order;
import pers.sakurasora.onlinestore.entity.PageBean;
import pers.sakurasora.onlinestore.entity.Product;

/**
 * 
 * 
 * @Description
 *				Dao层接口--操作t_product表
 */
public interface ProductDao {
	
	/**
	 * 查询热门商品
	 * @return List<Product>
	 * @throws Exception
	 */
	List<Product> findHotProduct() throws Exception;

	/**
	 * 查询最新商品
	 * @return List<Product>
	 * @throws Exception
	 */
	List<Product> findNewProduct() throws Exception;

	/**
	 * 根据商品编号查找商品
	 * @param 	sId 商品编号
	 * @return 	Product
	 * @throws 	Exception
	 */
	Product getProductById(String sId) throws Exception;
	
	/**
	 * 查询当前页分类商品
	 * @param 	productPage PageBean<Product>
	 * @param 	iCategoryId 分类编号
	 * @return 	List<Product>
	 * @throws 	Exception
	 */
	List<Product> findProductByPage(PageBean<Product> productPageBean, int iCategoryId) throws Exception;

	/**
	 * 根据分类编号查询商品记录数
	 * @param iCategoryId
	 * @return
	 * @throws Exception
	 */
	int getTotalRecordByCategoryId(int iCategoryId) throws Exception;
	
	/**
	 * 根据商品编号更新商品库存
	 * @param 	iStock 	商品库存
	 * @param	iId		商品编号
	 * @throws 	Exception
	 */
	void updateStockById(int iStock, int iId) throws Exception;
	
	/**
	 * 查询所有上架商品
	 * @return List<Product>
	 * @throws Exception
	 */
	List<Product> findAll() throws Exception;
	
	
	List<Product> findByPages(int pageIndex, int pageSize) throws Exception;
	
	/**
	 * 根据商品编号下架商品
	 * @param iProductId 商品编号
	 * @throws Exception
	 */
	void updateDownFlag(int iProductId) throws Exception;

	/**
	 * 添加商品
	 * @param product
	 * @throws Exception
	 */
	void add(Product product) throws Exception;

}
