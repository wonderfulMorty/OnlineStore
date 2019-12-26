package pers.sakurasora.onlinestore.service;

import java.util.List;

import pers.sakurasora.onlinestore.entity.Order;
import pers.sakurasora.onlinestore.entity.PageBean;

/**
 * 
 * 
 * @Description
 *				业务逻辑层接口--订单模块
 */
public interface OrderService {

	/**
	 * 生成订单
	 * @param 	order 订单对象
	 * @throws 	Exception
	 */
	void saveOrder(Order order)throws Exception;

	/**
	 * 分页展示我的订单
	 * @param 	iPageNumber	当前页
	 * @param 	iPageSize 	每页显示的数量
	 * @param 	iUserId		用户编号
	 * @return	PageBean<Order>
	 * @throws 	Exception
	 */
	PageBean<Order> findMyOrdersByPage(int iPageNumber, int iPageSize, int iUserId)throws Exception;

	/**
	 * 根据订单号获取订单
	 * @param 	sOrderId 订单号
	 * @return
	 * @throws 	Exception
	 */
	Order getOrderById(String sOrderId)throws Exception;

	/**
	 * 更新订单
	 * @param 	order 订单对象
	 * @throws 	Exception
	 */
	void updateOrder(Order order)throws Exception;
	
	/**
	 * 按状态展示订单列表
	 * @param 	state 订单状态	（可能为null）
	 * @return
	 * @throws 	Exception
	 */
	List<Order> findAllByState(String state)throws Exception;
	
	/**
	 * 修改订单状态
	 * @param 	iState 订单状态
	 * @param	sOrderId 订单号
	 * @throws 	Exception
	 */
	void updateStateById(int iState,String sOrderId) throws Exception;

}
