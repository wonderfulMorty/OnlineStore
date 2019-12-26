package pers.sakurasora.onlinestore.service;

import java.util.List;

import pers.sakurasora.onlinestore.entity.Category;

/**
 * 
 * 
 * @Description
 *				业务逻辑层接口--前台分类模块
 */
public interface CategoryService {

	/**
	 * 查询所有分类
	 * @return JSON字符串/null
	 * @throws Exception
	 */
	String findAll() throws Exception;
	
	/**
	 * 后台展示所有分类
	 * @return	List<Category>
	 * @throws Exception
	 */
	List<Category> findCategoryList() throws Exception;

	/**
	 * 添加分类
	 * @param Category
	 * @throws Exception
	 */
	void save(Category category) throws Exception;
	
	/**
	 * 根据分类编号删除分类
	 * @param 	iCategoryId 分类编号
	 * @throws 	Exception
	 */
	void delete(int iCategoryId) throws Exception;

}
