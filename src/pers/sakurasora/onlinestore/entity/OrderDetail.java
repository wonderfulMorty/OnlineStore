package pers.sakurasora.onlinestore.entity;

import java.io.Serializable;

/**
 * 
 * 
 * @Description
 *				订单明细实体类	t_order_detail
 */
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单项编号<br>
	 * 自增长
	 */
	private Integer id;
	
//	/**
//	 * 订单号
//	 */
//	private String order_id;
	 
	/**
	 * 表示属于订单
	 */
	private Order order;
	
//	/**
//	 * 商品编号
//	 */
//	private Integer product_id;
	
	/**
	 * 表示包含哪个商品
	 */
	private Product product;
	
	/**
	 * 商品购买数量
	 */
	private Integer count;
	
	/**
	 * 小计
	 */
	private Double subtotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public String getOrder_id() {
//		return order_id;
//	}
//
//	public void setOrder_id(String order_id) {
//		this.order_id = order_id;
//	}
//
//	public Integer getProduct_id() {
//		return product_id;
//	}
//
//	public void setProduct_id(Integer product_id) {
//		this.product_id = product_id;
//	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order=" + order + ", product=" + product + ", count=" + count
				+ ", subtotal=" + subtotal + "]";
	}
	
}
