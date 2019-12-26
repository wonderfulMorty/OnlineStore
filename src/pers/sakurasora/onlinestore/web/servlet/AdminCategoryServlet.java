package pers.sakurasora.onlinestore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.sakurasora.onlinestore.entity.Category;
import pers.sakurasora.onlinestore.service.CategoryService;
import pers.sakurasora.onlinestore.service.impl.CategoryServiceImpl;
import pers.sakurasora.onlinestore.web.servlet.base.BaseServlet;

/**
 * 
 * 
 * @Description
 *				Servlet--分类管理模块
 */
@WebServlet("/adminCategory")
public class AdminCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoryService categoryService = new CategoryServiceImpl();

	/**
	 * 展示所有分类
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/**
		 * 1. 调用service 获取所有的分类<br>
		 * 2. 将返回值放入request域中 请求转发
		 */
		try {
			List<Category> categoryLis = categoryService.findCategoryList();
			
			request.setAttribute("categoryLis", categoryLis);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有分类失败");
		}
		
		return "/jsp/admin/category/list.jsp";
	}
	
	/**
	 * 删除一个分类
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 获取分类编号 categoryId<br>
		 * 2. 调用service 执行删除<br>
		 * 3. 重定向
		 */
		try {
			String sCategoryId = request.getParameter("categoryId");
			categoryService.delete(Integer.parseInt(sCategoryId));
			
			response.sendRedirect(request.getContextPath()+"/adminCategory?method=findAll");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("删除分类失败");
		}
		return null;
	}
	
	/**
	 * 跳转到添加分类页面
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String addUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/admin/category/add.jsp";
	}
	
	/**
	 * 添加分类
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 封装category对象<br>
		 * 2. 调用service完成添加操作<br>
		 * 3. 重定向
		 */
		try {
			Category category = new Category();
			category.setName(request.getParameter("name"));
			
			categoryService.save(category);
			
			response.sendRedirect(request.getContextPath()+"/adminCategory?method=findAll");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加分类失败");
		}
		return null;
	}

}
