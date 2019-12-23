package cn.tedu.store.service;

import cn.tedu.store.entity.Order;

/**
 * 处理订单数据和订单商品数据的业务层接口
 * @author JAVA
 *
 */
public interface IOrderService{
	
	
	/**
	 * 创建订单
	 * @param uid 当前登录的用户的id
	 * @param username 当前登录的用户名
	 * @param aid 收货地址id
	 * @param cids 购物车数据id的数组
	 * @return 新创建的订单对象 
	 */
	Order create(Integer uid, String username, Integer aid, Integer[] cids);
	
}
