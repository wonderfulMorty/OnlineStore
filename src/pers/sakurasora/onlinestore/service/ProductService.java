package pers.sakurasora.onlinestore.service;

import java.util.List;

import pers.sakurasora.onlinestore.entity.PageBean;
import pers.sakurasora.onlinestore.entity.Product;

/**
 * 
 * 
 * @Description
 *				业务逻辑层接口--商品模块
 */
public interface ProductService {

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
	 * 查询单个商品详情（根据商品编号查找商品）
	 * @param 	sId 商品编号
	 * @return 	Product
	 * @throws 	Exception
	 */
	Product getProductById(String sId) throws Exception;

	/**
	 * 分页展示分类商品
	 * @param 	iPageNumber 当前页
	 * @param 	iPageSize 	每页显示的数量
	 * @param 	iCategoryId 分类编号
	 * @return 	PageBean<Product>
	 * @throws 	Exception
	 */
	PageBean<Product> findProductByPageAndCategoryId(int iPageNumber, int iPageSize, int iCategoryId) throws Exception;

	/**
	 * 根据商品编号更新库存
	 * @param iStock 	库存
	 * @param iId		商品编号
	 * @throws Exception
	 */
	void updateStockById(int iStock, int iId) throws Exception;
	
	/**
	 * 已上架商品列表
	 * @return List<Product>
	 * @throws Exception
	 */
	List<Product> findAll() throws Exception;

	
	
	List<Product> findByPages(int pageIndex, int pageSize) throws Exception;
	/**
	 * 添加商品
	 * @param product 商品对象
	 * @throws Exception
	 */
	void save(Product product)throws Exception;
	
	/**
	 * 根据商品编号下架商品
	 * @param 	iProductId 商品编号
	 * @throws 	Exception
	 */
	void down(int iProductId) throws Exception;
}
