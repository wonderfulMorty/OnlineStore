package pers.sakurasora.onlinestore.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.sakurasora.onlinestore.constant.Constant;
import pers.sakurasora.onlinestore.entity.Cart;
import pers.sakurasora.onlinestore.entity.CartItem;
import pers.sakurasora.onlinestore.entity.Order;
import pers.sakurasora.onlinestore.entity.OrderDetail;
import pers.sakurasora.onlinestore.entity.PageBean;
import pers.sakurasora.onlinestore.entity.User;
import pers.sakurasora.onlinestore.service.OrderService;
import pers.sakurasora.onlinestore.service.ProductService;
import pers.sakurasora.onlinestore.service.impl.OrderServiceImpl;
import pers.sakurasora.onlinestore.service.impl.ProductServiceImpl;
import pers.sakurasora.onlinestore.utils.UUIDUtil;
import pers.sakurasora.onlinestore.web.servlet.base.BaseServlet;

/**
 * 
 * 
 * @Description Servlet--订单模块
 */
@WebServlet("/order")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();
	private ProductService productService = new ProductServiceImpl();

	/**
	 * 生成（保存）订单
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 从session中获取user： 未登录 提示登录<br>
		 * 
		 * 2. 获取购物车<br>
		 * 3. 封装订单对象：<br>
		 * 创建对象; 设置订单号id; 设置下单时间order_time; 设置total(从购物车中获取）; 设置订单状态state; 设置user;
		 * 设置items(订单项列表)--遍历购物项列表<br>
		 * 4. 封装订单项<br>
		 * 5. 将订单项加入到订单的items中<br>
		 * 6. 调用orderservice完成保存订单操作<br>
		 * 7. 清空购物车<br>
		 * 8. 请求转发到 order_info.jsp
		 */
		try {
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				request.setAttribute("sMessage", "请先登录!");
				return "/jsp/message.jsp";
			}

			Cart cart = (Cart) request.getSession().getAttribute("cart");

			Order order = new Order(); // 封装订单对象
			order.setId(UUIDUtil.getOrderId());
			;

			// order.setOrder_time(new Date());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			order.setOrder_time(Timestamp.valueOf(formatter.format(new Date())));

			order.setTotal(cart.getTotal());
			order.setState(Constant.ORDER_NON_PAYMENT);
			order.setUser(user);
			for (CartItem cartItem : cart.getCartItems()) { // 遍历购物项列表
				OrderDetail orderDetail = new OrderDetail(); // 封装订单项
				orderDetail.setCount(cartItem.getCount()); // 数量
				orderDetail.setSubtotal(cartItem.getSubtotal()); // 小计
				orderDetail.setProduct(cartItem.getProduct()); // 从购物项中获取商品
				orderDetail.setOrder(order); // 属于哪个订单

				order.getItems().add(orderDetail); // 将订单项加入order 的items中
			}

			orderService.saveOrder(order);

			cart.clearCart();

			request.setAttribute("order", order);
		} catch (Exception e) {
		}
		return "/jsp/order_info.jsp";
	}

	/**
	 * 我的订单
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findMyOrdersByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1. 获取pageNumber 设置pageSize 获取user(user_id)<br>
		 * 未登录 提示<br>
		 * 2. 调用service获取当前页所有数据 pagebean<br>
		 * 3. 将pagebean放入request域中,请求转发 order_list.jsp
		 */
		try {
			int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			int pageSize = 3;

			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				request.setAttribute("sMessage", "请先登录");
				return "/jsp/message.jsp";
			}

			PageBean<Order> orderPageBean = orderService.findMyOrdersByPage(pageNumber, pageSize, user.getId());

			request.setAttribute("orderPageBean", orderPageBean);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("sMessage", "获取我的订单失败");
			return "/jsp/message.jsp";
		}
		return "/jsp/order_list.jsp";
	}

	/**
	 * 获取订单详情（点击“去付款”）
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String getProductById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1. 获取orderId<br>
		 * 2. 调用service 查询单个订单 <br>
		 * 3. 请求转发 order_info.jsp
		 */
		try {
			String sOrderId = request.getParameter("orderId");

			Order order = orderService.getOrderById(sOrderId);

			request.setAttribute("order", order);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("sMessage", "查询订单详情失败");
			return "/jsp/message.jsp";
		}
		return "/jsp/order_info.jsp";
	}

	/**
	 * 下订单
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 获取收获信息 获取orderId 获取银行<br>
		 * 2. 调用service获取订单 修改收获人信息 更新订单<br>
		 * 3. 拼接给第三方的url<br>
		 * 4. 重定向 （相应银行在线支付页面）
		 */
		try {
			String sAddress = request.getParameter("address");
			String sName = request.getParameter("name");
			String sTelephone = request.getParameter("telephone");
			String sOrderId = request.getParameter("orderId");
			System.out.println("sOrderId:" + sOrderId);
			Order order = orderService.getOrderById(sOrderId);
			order.setAddress(sAddress);
			order.setName(sName);
			order.setTelephone(sTelephone);
			orderService.updateOrder(order);
			request.setAttribute("sMessage", "订单成功！但是未支付");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("sMessage", "支付失败");
			return "/jsp/message.jsp";
		}

		return "/jsp/message.jsp";
	}

	

	/**
	 * 修改订单状态（对已付款订单发货）
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String updateState(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1. 获取orderId<br>
		 * 2. 设置订单的状态,更新<br>
		 * 3. 重定向
		 */
		try {
			String sOrderId = request.getParameter("orderId");

			orderService.updateStateById(Constant.ORDER_IS_FINISH, sOrderId);

			response.sendRedirect(request.getContextPath() + "/order?method=findMyOrdersByPage&pageNumber=1");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("修改订单状态（确认收货）失败");
		}
		return null;
	}
}
