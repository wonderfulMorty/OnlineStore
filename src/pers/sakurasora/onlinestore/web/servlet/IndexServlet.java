package pers.sakurasora.onlinestore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.sakurasora.onlinestore.entity.Product;
import pers.sakurasora.onlinestore.service.ProductService;
import pers.sakurasora.onlinestore.service.impl.ProductServiceImpl;
import pers.sakurasora.onlinestore.web.servlet.base.BaseServlet;

/**
 * 
 * 
 * @Description
 *				首页模块
 */
@WebServlet("/index")
public class IndexServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = new ProductServiceImpl();

	@Override
	public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 调用productService查询最新商品 和 热门商品<br>
		 * 2. 将两个list都放入request域中
		 */
		try {
			
			List<Product> hotList = productService.findHotProduct();
			List<Product> newList = productService.findNewProduct();
			
			request.setAttribute("hotList", hotList);
			request.setAttribute("newList", newList);
		} catch (Exception e) {
		}
		return "/jsp/index.jsp";
	}

}
