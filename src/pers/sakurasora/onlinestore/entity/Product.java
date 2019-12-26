package pers.sakurasora.onlinestore.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @Description
 *				商品信息实体类	t_product
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 商品编号<br>
	 * 自增长
	 */
	private Integer id;
	
//	/**
//	 * 类别编号
//	 */
//	private Integer category_id;
	
	/**
	 * 类别对象<br>
	 * 在多的一方放入一个一的一方的对象	用来表示属于哪个分类
	 */
	private Category category;
	
	/**
	 * 商品名称
	 */
	private String product_name;
	
	/**
	 * 市场价
	 */
	private Double market_price;
	
	/**
	 * 商城价
	 */
	private Double mall_price;
	
	/**
	 * 商品图片
	 */
	private String image;
	
	/**
	 * 商品描述
	 */
	private String description;
	
	/**
	 * 上架时间
	 */
	private Date shelf_time;
	
	/**
	 * 是否热门<br>
	 * 0-否，1-是
	 */
	private Integer is_hot;
	
	/**
	 * 是否下架<br>
	 * 0-否，1-是
	 */
	private Integer is_down;
	
	/**
	 * 库存
	 */
	private Integer stock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Integer getCategory_id() {
//		return category_id;
//	}
//
//	public void setCategory_id(Integer category_id) {
//		this.category_id = category_id;
//	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	public Double getMall_price() {
		return mall_price;
	}

	public void setMall_price(Double mall_price) {
		this.mall_price = mall_price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getShelf_time() {
		return shelf_time;
	}

	public void setShelf_time(Date shelf_time) {
		this.shelf_time = shelf_time;
	}

	public Integer getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}

	public Integer getIs_down() {
		return is_down;
	}

	public void setIs_down(Integer is_down) {
		this.is_down = is_down;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category_id=" + category.getId() + ", category_name=" + category.getName() + ", product_name=" + product_name + ", market_price="
				+ market_price + ", mall_price=" + mall_price + ", image=" + image + ", description=" + description
				+ ", shelf_time=" + shelf_time + ", is_hot=" + is_hot + ", is_down=" + is_down + ", stock=" + stock
				+ "]";
	}
	
}
