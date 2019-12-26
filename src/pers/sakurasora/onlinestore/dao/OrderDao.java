package pers.sakurasora.onlinestore.dao;

import java.util.List;

import pers.sakurasora.onlinestore.entity.Order;
import pers.sakurasora.onlinestore.entity.OrderDetail;
import pers.sakurasora.onlinestore.entity.PageBean;

/**
 * 
 * 
 * @Description
 *				Dao层接口--操作t_order表
 */
public interface OrderDao {

	/**
	 * 添加订单
	 * @param 	order 订单对象
	 * @throws 	Exception
	 */
	void add(Order order) throws Exception;

	/**
	 * 保存订单明细
	 * @param 	orderDetail	订单项
	 * @throws 	Exception
	 */
	void saveItem(OrderDetail orderDetail) throws Exception;

	/**
	 * 根据用户编号获取订单总记录数（获取我的订单的总条数）
	 * @param 	iUserId	用户编号
	 * @return	总记录数
	 * @throws 	Exception
	 */
	int getTotalRecord(int iUserId) throws Exception;

	/**
	 * 分页查询我的订单
	 * @param 	orderPageBean	PageBean<Order>
	 * @param 	iUserId			用户编号
	 * @return	List<Order>
	 * @throws 	Exception
	 */
	List<Order> findMyOrdersByPage(PageBean<Order> orderPageBean, int iUserId) throws Exception;

	/**
	 * 根据订单号查询订单
	 * @param 	sOrderId 订单号
	 * @return
	 * @throws 	Exception
	 */
	Order getOrderById(String sOrderId) throws Exception;

	/**
	 * 更新订单
	 * @param 	order 订单对象
	 * @throws 	Exception
	 */
	void update(Order order) throws Exception;
	
	/**
	 * 根据订单状态查询订单
	 * @param 	state 订单状态	（可能为null）
	 * @return
	 * @throws 	Exception
	 */
	List<Order> findAllByState(String state) throws Exception;
	
	/**
	 * 根据订单号更新订单状态
	 * @param 	iState 订单状态
	 * @param	sOrderId 订单号
	 * @throws 	Exception
	 */
	void updateStateById(int iState,String sOrderId) throws Exception;

}
