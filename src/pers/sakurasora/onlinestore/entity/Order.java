package pers.sakurasora.onlinestore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @Description
 *				订单信息表实体类	t_order
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单号
	 */
	private String id;

//	/**
//	 * 用户编号
//	 */
//	private Integer user_id;
	
	/**
	 * 表示当前订单属于哪个用户
	 */
	private User user;
	
	/**
	 * 下单时间
	 */
	private Date order_time;
	
	/**
	 * 金额
	 */
	private Double total;
	
	/**
	 * 订单状态<br>
	 * 0-未付款，1-已付款，2-已发货，3-已完成
	 */
	private Integer state;
	
	/**
	 * 收货人姓名
	 */
	private String name;
	
	/**
	 * 收货人手机号
	 */
	private String telephone;
	
	/**
	 * 收货人地址
	 */
	private String address;
	
	/**
	 * 表示当前订单包含的订单项
	 */
	private List<OrderDetail> items = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public Integer getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(Integer user_id) {
//		this.user_id = user_id;
//	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderDetail> getItems() {
		return items;
	}

	public void setItems(List<OrderDetail> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", order_time=" + order_time + ", total=" + total + ", state="
				+ state + ", name=" + name + ", telephone=" + telephone + ", address=" + address + ", items=" + items
				+ "]";
	}
	
}
