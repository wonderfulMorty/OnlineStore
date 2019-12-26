package pers.sakurasora.onlinestore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.sakurasora.onlinestore.entity.Cart;
import pers.sakurasora.onlinestore.entity.CartItem;
import pers.sakurasora.onlinestore.entity.Product;
import pers.sakurasora.onlinestore.entity.User;
import pers.sakurasora.onlinestore.service.ProductService;
import pers.sakurasora.onlinestore.service.impl.ProductServiceImpl;
import pers.sakurasora.onlinestore.web.servlet.base.BaseServlet;

/**
 * 
 * 
 * @Description
 *				Servlet--购物车模块
 */
@WebServlet("/cart")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductService productService = new ProductServiceImpl();
	
	/**
	 * 获取购物车
	 * @param request
	 * @return
	 */
	private Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			request.getSession().setAttribute("cart", cart); // 将cart放入session中
		}
		return cart;
	}

	/**
	 * 加入购物车
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 0. 未登录提示登录<br>
		 * 1. 获取 productId count<br>
		 * 2. 封装cartitem：<br>
		 * 					调用service获取product<br>
		 * 					创建cartitem<br>
		 * 3. 获取购物车,将cartitem加入购物车<br>
		 * 4. 重定向 /jsp/cart.jsp
		 */
		try {
			User user = (User)request.getSession().getAttribute("user");
			if(user == null){
				request.setAttribute("sMessage", "请先登录!");
				return "/jsp/message.jsp";
			}			

			String sProductId = request.getParameter("productId");
			int count = Integer.parseInt(request.getParameter("count"));

			Product product = productService.getProductById(sProductId);
			CartItem cartItem = new CartItem(product, count);
			
			Cart cart = getCart(request);
			cart.addToCart(cartItem);
			
			response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("sMessage", "加入购物车失败");
			return "/jsp/message.jsp";
		}
		
		return null;
	}
	
	/**
	 * 从购物车移除商品
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 获取商品编号 productId<br>
		 * 2. 获取购物车 执行移除<br>
		 * 3. 重定向 /jsp/cart.jsp
		 */
		String sProductId = request.getParameter("productId");
		getCart(request).removeFromCart(Integer.parseInt(sProductId));
		response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
		return null;
	}
	
	/**
	 * 清空购物车
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 获取购物车 执行清空操作<br>
		 * 2. 重定向 /jsp/cart.jsp
		 */
		getCart(request).clearCart();
		response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
		
		return null;
	}
	
}
