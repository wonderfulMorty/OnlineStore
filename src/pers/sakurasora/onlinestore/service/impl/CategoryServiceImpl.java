package pers.sakurasora.onlinestore.service.impl;

import java.util.List;

import pers.sakurasora.onlinestore.dao.CategoryDao;
import pers.sakurasora.onlinestore.dao.impl.CategoryDaoImpl;
import pers.sakurasora.onlinestore.entity.Category;
import pers.sakurasora.onlinestore.service.CategoryService;
import pers.sakurasora.onlinestore.utils.JsonUtil;

/**
 * 
 * 
 * @Description
 *				业务逻辑层接口实现类--分类模块
 */
public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public String findAll() 
			throws Exception {
		/**
		 * 1. 调用DAO 查询所有分类<br>
		 * 2. 将list转换成json字符串
		 */
//		List<Category> categoryLis = categoryDao.findAll();
		
		List<Category> categoryLis = findCategoryList();
		
		if(categoryLis != null && categoryLis.size() > 0){
			return JsonUtil.listToJson(categoryLis);
		}
		return null;
	}

	@Override
	public List<Category> findCategoryList() throws Exception {
		return categoryDao.findAll();
	}

	@Override
	public void save(Category category) throws Exception {
		categoryDao.add(category); // 调用dao 完成添加
	}

	@Override
	public void delete(int iCategoryId) throws Exception {
		categoryDao.delete(iCategoryId); // // 调用dao 完成删除
	}

}
