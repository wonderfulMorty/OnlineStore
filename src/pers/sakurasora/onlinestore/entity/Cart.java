package pers.sakurasora.onlinestore.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @Description
 *				购物车
 */
public class Cart {
	
	/**
	 * 购物项<br>
	 * Map<商品编号,购物项>
	 */
	private Map<Integer, CartItem> itemMap = new HashMap<>();
	
	/**
	 * 金额
	 */
	private Double total=0.0;
	
	/**
	 * 获取所有的购物项
	 * @return
	 */
	public  Collection<CartItem> getCartItems(){
		return itemMap.values();
	}
	
	public Map<Integer, CartItem> getItemMap() {
		return itemMap;
	}
	
	public void setItemMap(Map<Integer, CartItem> itemMap) {
		this.itemMap = itemMap;
	}
	
	public Double getTotal() {
		return total;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}
	
	/**
	 * 把购物项加入到购物车
	 * @param item 购物项
	 */
	public void addToCart(CartItem item){
		int iProductId = item.getProduct().getId(); // 获取商品编号
		int iStock = item.getProduct().getStock(); // 获取商品库存
		
		/**
		 * 1. 判断购物车中是否有该商品:<br>
		 * 						有 修改数量  = 原来数量+新加的数量<br>
		 * 						无 直接放入购物车<br>
		 * 				如果数量大于库存，修改数量为库存量<br>
		 * 2. 修改总金额
		 */
		if(itemMap.containsKey(iProductId)){ 
			CartItem oItem = itemMap.get(iProductId); // 原有的购物项
			int count = oItem.getCount() + item.getCount();
			if (count > iStock) {
				count = iStock; // 数量大于库存，修改数量为库存量
			} 
			oItem.setCount(count);
		}else{
			if (item.getCount() > iStock) {
				item.setCount(iStock); // 数量大于库存，修改数量为库存量
			}
			itemMap.put(iProductId, item);
		}
		total += item.getSubtotal();
	}
	
	/**
	 * 从购物车移除一个购物项
	 * @param iProductId 商品编号
	 */
	public void removeFromCart(int iProductId){
		/**
		 * 1. 从购物车(map)移除 购物项<br>
		 * 2. 修改总金额
		 */
		CartItem item = itemMap.remove(iProductId);
		total -= item.getSubtotal();
	}
	
	/**
	 * 清空购物车
	 */
	public void clearCart(){
		/**
		 * 1. 清空map<br>
		 * 2. 修改总金额 = 0
		 */
		itemMap.clear();
		total = 0.0;
	}
}
