package pers.sakurasora.onlinestore.dao;

import java.util.List;

import pers.sakurasora.onlinestore.entity.Category;

/**
 * 
 * 
 * @Description
 *				Dao层接口--操作t_category表
 */
public interface CategoryDao {

	/**
	 * 查询所有分类
	 * @return List<Category>
	 * @throws Exception
	 */
	List<Category> findAll() throws Exception;
	
	/**
	 * 添加分类
	 * @param category
	 * @throws Exception
	 */
	void add(Category category) throws Exception;
	
	/**
	 * 根据分类编号删除分类
	 * @param 	iCategoryId 分类编号
	 * @throws 	Exception
	 */
	void delete(int iCategoryId) throws Exception;

}
