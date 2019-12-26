package pers.sakurasora.onlinestore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import pers.sakurasora.onlinestore.constant.Constant;
import pers.sakurasora.onlinestore.entity.Order;
import pers.sakurasora.onlinestore.entity.OrderDetail;
import pers.sakurasora.onlinestore.service.OrderService;
import pers.sakurasora.onlinestore.service.impl.OrderServiceImpl;
import pers.sakurasora.onlinestore.utils.JsonUtil;
import pers.sakurasora.onlinestore.web.servlet.base.BaseServlet;

/**
 * 
 * 
 * @Description
 *				Servlet--订单管理模块
 */
@WebServlet("/adminOrder")
public class AdminOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private OrderService orderService = new OrderServiceImpl();

	/**
	 * 根据订单状态查询订单列表
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String findAllByState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 获取state<br>
		 * 2. 调用service 获取不同的列表<br>
		 * 3. 将list放入request域中,请求转发
		 */
		try {
			String state = request.getParameter("state");
			
			List<Order> orderLis = orderService.findAllByState(state);
			
			request.setAttribute("orderLis", orderLis);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("根据状态查询订单失败");
		}
		return "/jsp/admin/order/list.jsp";
	}
	
	/**
	 * 展示订单详情
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String showDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 设置编码<br>
		 * 2. 获取orderId<br>
		 * 3. 调用service 获取订单<br>
		 * 4. 获取订单的订单项列表 转成json 写回浏览器
		 */
		try {
			response.setContentType("text/html;charset=utf-8");
			
			String sOrderId = request.getParameter("orderId");
			
			Order order = orderService.getOrderById(sOrderId);
			
			if(order != null){
				List<OrderDetail> itemLis = order.getItems();
				if(itemLis != null && itemLis.size() > 0){					
					JsonConfig config = JsonUtil.configJson(new String[]{"order","shelf_time","description","id"});
					response.getWriter().println(JSONArray.fromObject(itemLis, config));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("根据订单号查询订单失败");
		}
		return null;
	}
	
	/**
	 * 修改订单状态（对已付款订单发货）
	 * @param 	request
	 * @param 	response
	 * @return
	 * @throws 	ServletException
	 * @throws 	IOException
	 */
	public String updateState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1. 获取orderId<br>
		 * 2. 设置订单的状态,更新<br>
		 * 3. 重定向
		 */
		try {
			String sOrderId = request.getParameter("orderId");
			
			orderService.updateStateById(Constant.ORDER_IS_DELIVERED, sOrderId);
			
			response.sendRedirect(request.getContextPath()+"/adminOrder?method=findAllByState&state=1");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("修改订单状态（去发货）失败");
		}
		return null;
	}

}
