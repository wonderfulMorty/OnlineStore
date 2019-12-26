package pers.sakurasora.onlinestore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.sakurasora.onlinestore.entity.PageBean;
import pers.sakurasora.onlinestore.entity.Product;
import pers.sakurasora.onlinestore.service.ProductService;
import pers.sakurasora.onlinestore.service.impl.ProductServiceImpl;
import pers.sakurasora.onlinestore.web.servlet.base.BaseServlet;

/**
 * 
 * 
 * @Description
 *				Servlet--商品模块
 */
@WebServlet("/product")
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService =new ProductServiceImpl();

	/**
	 * 单个商品详情
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String getProductById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1. 获取商品编号id<br>
		 * 2. 调用service获取单个商品 参数:id 返回值:product<br>
		 * 3. 将product放入request域中,请求转发 /jsp/product_info.jsp
		 */
		try {
			String sId = request.getParameter("id");
			Product product = productService.getProductById(sId);
			request.setAttribute("product", product);
		} catch (Exception e) {
			request.setAttribute("sMessage", "获取单个商品详情失败！");
			return "/jsp/message.jsp";
		}
		
		return "/jsp/product_info.jsp";
	}
	
	/**
	 * 分类商品分页展示
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String findProductByPageAndCategoryId(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1. 获取pageNumber categoryId  设置pageSize<br>
		 * 2. 调用service 分页查询商品  返回值:pagebean<br>
		 * 3. 将pagebean放入request中,请求转发 product_list.jsp
		 */
		try {
			int pageNumber = 1;
			int pageSize = 12;
			
			try {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			} catch (NumberFormatException e) {
			}
			
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			
			PageBean<Product> productPageBean = productService.findProductByPageAndCategoryId(pageNumber,pageSize,categoryId);
			
			request.setAttribute("productPageBean", productPageBean);
		} catch (Exception e) {
			request.setAttribute("sMessage", "分页查询失败");
			return "/jsp/message.jsp";
		}
		return "/jsp/product_list.jsp";
	}

}
