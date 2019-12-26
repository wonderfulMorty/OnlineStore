package pers.sakurasora.onlinestore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.sakurasora.onlinestore.service.CategoryService;
import pers.sakurasora.onlinestore.service.impl.CategoryServiceImpl;
import pers.sakurasora.onlinestore.web.servlet.base.BaseServlet;

/**
 * 
 * 
 * @Description
 *				Servlet--前台分类模块
 */
@WebServlet("/category")
public class CategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoryService categoryService = new CategoryServiceImpl();

	/**
	 * 查询所有分类
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/**
		 * 1. 设置响应编码<br>
		 * 2. 调用service,查询所有分类,返回值 json字符串<br>
		 * 3. 将字符串写回浏览器
		 */
		try {
			response.setContentType("text/html;charset=utf-8");
			String categoryJSON = categoryService.findAll();
			response.getWriter().println(categoryJSON);
		} catch (Exception e) {
		}
		return null;
	}

}
