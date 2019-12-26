package pers.sakurasora.onlinestore.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import pers.sakurasora.onlinestore.dao.OrderDao;
import pers.sakurasora.onlinestore.entity.Order;
import pers.sakurasora.onlinestore.entity.OrderDetail;
import pers.sakurasora.onlinestore.entity.PageBean;
import pers.sakurasora.onlinestore.entity.Product;
import pers.sakurasora.onlinestore.utils.DataSourceUtil_C3P0;

/**
 * 
 * 
 * @Description
 *				Dao层实现类--操作t_order表
 */
public class OrderDaoImpl implements OrderDao {

	@Override
	public void add(Order order) throws Exception {
		/*
		 * 业务层涉及到事务，
		 * 不能使用QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		 * 使用无参的queryRunner
		 */
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into t_order values(?,?,?,?,?,?,?,?)";
		queryRunner.update(DataSourceUtil_C3P0.getConnection(),sql, order.getId(),order.getUser().getId(),order.getOrder_time(),order.getTotal(),order.getState(),order.getName(),order.getTelephone(),order.getAddress());
	}

	@Override
	public void saveItem(OrderDetail orderDetail) throws Exception {
		/*
		 * 业务层涉及到事务，
		 * 不能使用QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		 * 使用无参的queryRunner
		 */
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into t_order_detail(order_id,product_id,count,subtotal) values(?,?,?,?)";
		queryRunner.update(DataSourceUtil_C3P0.getConnection(),sql, orderDetail.getOrder().getId(),orderDetail.getProduct().getId(),orderDetail.getCount(),orderDetail.getSubtotal());
	}

	@Override
	public int getTotalRecord(int iUserId) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select count(*) from t_order where user_id = ?";
		/*
		 * ScalarHandler：	将单个值封装（例如select count(*)，求内容的条数）
		 * Long.intValue()：	将Long转为int
		 */
		return ((Long)queryRunner.query(sql, new ScalarHandler(), iUserId)).intValue();
	}

	@Override
	public List<Order> findMyOrdersByPage(PageBean<Order> orderPageBean, int iUserId) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		/**
		 * 1. 根据用户编号查询所有订单(基本信息)_分页<br>
		 * 2. 遍历订单集合 获取每一个订单,查询每个订单订单项<br>
		 * 3. 将orderDetail放入order的订单项列表
		 */
		String sql="select * from t_order where user_id = ? order by order_time desc limit ?,?";
		List<Order> orderLis = queryRunner.query(sql, new BeanListHandler<>(Order.class), iUserId,orderPageBean.getStartIndex(),orderPageBean.getPageSize());
		
		for (Order order : orderLis) {
			sql="select * from t_order_detail od,t_product p where od.product_id = p.id and od.order_id = ?";
			List<Map<String, Object>> maplist = queryRunner.query(sql, new MapListHandler(), order.getId());
			
			for (Map<String, Object> map : maplist) { //遍历maplist 获取每一个订单项详情,封装成orderDetail,将其加入当前订单的订单项列表中
				OrderDetail orderDetail = new OrderDetail();
				/*BeanUtils.populate(Object bean,Map properties)，这个方法会遍历map<key,value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。*/
				BeanUtils.populate(orderDetail, map); // 封装orderDetail
				
				Product p = new Product(); 
				BeanUtils.populate(p, map); // 封装product
				
				orderDetail.setProduct(p); // 包含哪个商品
				
				order.getItems().add(orderDetail);
			}
		}
		return orderLis;
	}

	@Override
	public Order getOrderById(String sOrderId) throws Exception {
		/**
		 * 1. 根据订单号查询订单基本信息<br>
		 * 2. 查询该订单所有订单项<br>
		 * 3. 将orderDetail加入到订单的items中
		 */
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql = "select * from t_order where id = ?";
		Order order = queryRunner.query(sql, new BeanHandler<>(Order.class), sOrderId);

		sql = "select * from t_order_detail od,t_product p where od.product_id = p.id and od.order_id = ?";
		List<Map<String, Object>> maplist = queryRunner.query(sql, new MapListHandler(), sOrderId); // 所有的订单项详情

		for (Map<String, Object> map : maplist) { // 遍历 获取每一个订单项详情 封装成orderDetail 加入到当前订单的items中
			OrderDetail orderDetail = new OrderDetail();
			/*BeanUtils.populate(Object bean,Map properties)，这个方法会遍历map<key,value>中的key，如果bean中有这个属性，就把这个key对应的value值赋给bean的属性。*/
			BeanUtils.populate(orderDetail, map); // 封装orderDetail

			Product product = new Product();
			BeanUtils.populate(product, map); // 封装product

			orderDetail.setProduct(product);
			
			order.getItems().add(orderDetail);
		}
		return order;
	}

	@Override
	public void update(Order order) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql="update t_order set state = ?,name = ?,telephone = ?,address = ? where id = ?";
		queryRunner.update(sql,order.getState(),order.getName(),order.getTelephone(),order.getAddress(),order.getId());
	}

	@Override
	public List<Order> findAllByState(String state) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		
		String sql = "select * from t_order ";
		
		//判断state是否为空
		if(null == state || state.trim().length() == 0){
			sql += " order by order_time desc";
			return queryRunner.query(sql, new BeanListHandler<>(Order.class));
		}
		
		sql += " where state = ? order by order_time desc";
		return queryRunner.query(sql, new BeanListHandler<>(Order.class),state);
	}

	@Override
	public void updateStateById(int iState,String sOrderId) throws Exception {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtil_C3P0.getDataSource());
		String sql="update t_order set state = ? where id = ?";
		queryRunner.update(sql,iState,sOrderId);
	}

}
