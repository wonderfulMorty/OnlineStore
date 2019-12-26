package pers.sakurasora.onlinestore.entity;

/**
 * 
 * 
 * @Description
 *				购物项
 */
public class CartItem {
	
	/**
	 * 商品
	 */
	private Product product;
	
	/**
	 * 小计
	 */
	private Double subtotal;
	
	/**
	 * 数量
	 */
	private Integer count;
	
	public CartItem(Product product, Integer count) {
		super();
		this.product = product;
		this.count = count;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * 获取商品小计
	 * @return
	 */
	public Double getSubtotal() {
		return product.getMall_price()*count;
	}

//	public void setSubtotal(Double subtotal) {
//		this.subtotal = subtotal;
//	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", subtotal=" + subtotal + ", count=" + count + "]";
	}
	
}
