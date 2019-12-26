package pers.sakurasora.onlinestore.service.impl;

import java.util.List;

import pers.sakurasora.onlinestore.dao.OrderDao;
import pers.sakurasora.onlinestore.dao.impl.OrderDaoImpl;
import pers.sakurasora.onlinestore.entity.Order;
import pers.sakurasora.onlinestore.entity.OrderDetail;
import pers.sakurasora.onlinestore.entity.PageBean;
import pers.sakurasora.onlinestore.service.OrderService;
import pers.sakurasora.onlinestore.utils.DataSourceUtil_C3P0;

/**
 * 
 * 
 * @Description
 *				业务逻辑层实现类--订单模块
 */
public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao = new OrderDaoImpl();

	@Override
	public void saveOrder(Order order) throws Exception{
		/**
		 * 1. 开始事务<br>
		 * 2. 向order表中插入一条数据<br>
		 * 3. 向orderDetail中插入n条数据<br>
		 * 4. 提交事务并释放连接
		 */
		try {
			DataSourceUtil_C3P0.startTransaction();
			
			orderDao.add(order);
			
			for (OrderDetail orderDetail : order.getItems()) {
				orderDao.saveItem(orderDetail);
			}
			
			DataSourceUtil_C3P0.commitTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			DataSourceUtil_C3P0.rollbackTransaction(); // 回滚事务并释放连接
			throw e;
		}
	}

	@Override
	public PageBean<Order> findMyOrdersByPage(int iPageNumber, int iPageSize, int iUserId) throws Exception {
		/**
		 * 1. 创建pagebean<br>
		 * 2. 查询总条数  设置总条数 <br>
		 * 3. 查询当前页数据 设置当前页数据
		 */
		PageBean<Order> OrderPageBean = new PageBean<>(iPageNumber, iPageSize);
		
		int totalRecord = orderDao.getTotalRecord(iUserId);
		OrderPageBean.setTotalRecord(totalRecord);
		
		List<Order> data = orderDao.findMyOrdersByPage(OrderPageBean,iUserId);
		OrderPageBean.setData(data);
		return OrderPageBean;
	}

	@Override
	public Order getOrderById(String sOrderId) throws Exception {
		return orderDao.getOrderById(sOrderId);
	}

	@Override
	public void updateOrder(Order order) throws Exception {
		orderDao.update(order);
	}

	@Override
	public List<Order> findAllByState(String state) throws Exception {
		return orderDao.findAllByState(state);
	}

	@Override
	public void updateStateById(int iState, String sOrderId) throws Exception {
		orderDao.updateStateById(iState, sOrderId);
	}

}
