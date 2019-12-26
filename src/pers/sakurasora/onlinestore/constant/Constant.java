package pers.sakurasora.onlinestore.constant;
/**
 * 
 * 
 * @Description
 *				存放常量的接口
 */
public interface Constant {
	 
	/**
	 * 查询 热门商品/最新商品 limit ?
	 */
	int LIMIT_NUM = 9;
	
	/**
	 * 记住用户名
	 */
	String SAVE_NAME = "ok";
	
	/**
	 * 订单未付款
	 */
	int ORDER_NON_PAYMENT = 0;
	
	/**
	 * 订单已付款
	 */
	int ORDER_IS_PAYMENT = 1;
	
	/**
	 * 订单已发货
	 */
	int ORDER_IS_DELIVERED = 2;
	
	/**
	 * 订单已完成
	 */
	int ORDER_IS_FINISH = 3;
	
	/**
	 * 不热门商品
	 */
	int PRODUCT_IS_NOT_HOT = 0;
	
	/**
	 * 热门商品
	 */
	int PRODUCT_IS_HOT = 1;
	
	/**
	 * 上架商品
	 */
	int PRODUCT_IS_NOT_DOWN = 0;
	
	/**
	 * 下架商品
	 */
	int PRODUCT_IS_DOWN = 1;
}
