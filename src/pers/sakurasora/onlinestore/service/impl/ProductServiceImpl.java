package pers.sakurasora.onlinestore.service.impl;

import java.util.List;

import pers.sakurasora.onlinestore.dao.ProductDao;
import pers.sakurasora.onlinestore.dao.impl.ProductDaoImpl;
import pers.sakurasora.onlinestore.entity.PageBean;
import pers.sakurasora.onlinestore.entity.Product;
import pers.sakurasora.onlinestore.service.ProductService;

/**
 * @author SakuraSora
 * 
 * @Description 业务逻辑层接口实现类--商品模块
 */
public class ProductServiceImpl implements ProductService {
	private ProductDao productDao = new ProductDaoImpl();

	@Override
	public List<Product> findHotProduct()
			throws Exception {
		return productDao.findHotProduct();
	}

	@Override
	public List<Product> findNewProduct() 
			throws Exception {
		return productDao.findNewProduct();
	}

	@Override
	public Product getProductById(String sId) 
			throws Exception {
		return productDao.getProductById(sId);
	}

	@Override
	public PageBean<Product> findProductByPageAndCategoryId(int iPageNumber, int iPageSize, int iCategoryId)
			throws Exception {
		/**
		 * 1. 创建pagebean<br>
		 * 2. 设置当前页数据<br>
		 * 3. 设置总记录数
		 */
		PageBean<Product> productPageBean = new PageBean<>(iPageNumber, iPageSize);
		List<Product> productLis = productDao.findProductByPage(productPageBean, iCategoryId);
		productPageBean.setData(productLis);
		int totalRecord = productDao.getTotalRecordByCategoryId(iCategoryId);
		productPageBean.setTotalRecord(totalRecord);

		return productPageBean;
	}

	@Override
	public void updateStockById(int iStock, int iId) throws Exception {
		productDao.updateStockById(iStock, iId);
	}

	@Override
	public List<Product> findAll() throws Exception {
		return productDao.findAll();
	}

	@Override
	public void save(Product product) throws Exception {
		productDao.add(product);
	}

	@Override
	public void down(int iProductId) throws Exception {
		productDao.updateDownFlag(iProductId);
	}

	@Override
	public List<Product> findByPages(int pageIndex, int pageSize) throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("findByPages--->pageIndex:"+pageIndex+"pageSize:"+pageSize);
		return productDao.findByPages(pageIndex, pageSize);
	}

}
