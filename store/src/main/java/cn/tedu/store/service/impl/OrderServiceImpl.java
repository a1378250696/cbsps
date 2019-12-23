package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.vo.CartVO;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private IAddressService addressService;
	
	@Autowired
	private ICartService cartService;
	
	@Override
	public Order create(Integer uid,String username, Integer aid, Integer[] cids) {
		
		// 创建当前时间对象now
		Date now = new Date();
			// 调用IAddressService对象的getByAid(Integer aid, Integer uid)方法，根据参数aid和uid查询收货地址数据
		Address address = addressService.getbyAid(aid, uid);
			// 调用ICartService对象的getVOByCids(Integer cids, Integer uid)方法，根据参数cids和uid查询匹配的购物车数据，得到List<CartVO>对象
		List<CartVO> lit = cartService.getVOByCids(cids, uid);
			// 声明变量totalPrice表示订单中商品的总价
		Long totalPrice = 0L;
			// 遍历以上查询到的List<CartVO>对象
		for (CartVO cartVO : lit) {
			// -- 在totalPrice上累加商品的单价与数量的乘积
			totalPrice += cartVO.getRealPrice() * cartVO.getNum();
		}

			// 创建Order对象
		Order order = new Order();
			// 补全数据：uid
		order.setUid(uid);
			// 补全数据：recv_???(通过查询到的收货地址数据)
		order.setRecvName(address.getName());
		order.setRecvPhone(address.getPhone());
		order.setRecvProvince(address.getProvinceName());
		order.setRecvCity(address.getCityName());
		order.setRecvArea(address.getAreaName());
		order.setRecvAddress(address.getAddress());
			// 补全数据：total_price(totalPrice)
		order.setTotalPrice(totalPrice);
			// 补全数据：order_time(now)
		order.setOrderTime(now);
			// 补全数据：pay_time(保留为null)
			// 补全数据：status(0)
		order.setStatus(0);
			// 补全数据：4条日志
		order.setCreatedUser(username);
		order.setCreatedTime(now);
		order.setModifiedUser(username);
		order.setModifiedTime(now);
		
			// 插入订单数据：insertOrder(Order order);
		insertOrder(order);
		
			// 遍历查询到的List<CartVO>对象
		for (CartVO cartVO : lit) {
			// -- 创建OrderItem对象
			OrderItem item = new OrderItem();
			// -- 补全数据：oid(order.getOid())
			item.setOid(order.getOid());
			// -- 补全数据：pid, title, image, price, num(均从CartVO对象中获取)
			item.setPid(cartVO.getPid());
			item.setTitle(cartVO.getTitle());
			item.setImage(cartVO.getImage());
			item.setPrice(cartVO.getPrice());
			item.setNum(cartVO.getNum());
		
			// -- 补全数据：4条日志
		item.setCreatedUser(username);
		item.setCreatedTime(now);
		item.setCreatedUser(username);
		item.setCreatedTime(now);
			// -- 调用insertOrderItem(OrderItem orderItem)插入订单商品数据
		insertOrderItem(item);
		}
		
		//删除购物车中对应的数据
		cartService.delete(cids, uid);
		
		
			// 将Order对象中的4条日志设置为null
		order.setCreatedUser(null);
		order.setCreatedTime(null);
		order.setModifiedUser(null);
		order.setModifiedTime(null);
		// 返回Order对象
		return order;
	
	}
	
	
	
	
	/**
	* 插入订单数据
	 * @param order 订单数据
	 */
	private void insertOrder(Order order) {
		Integer rows = orderMapper.insertOrder(order);
		if(rows != 1) {
			throw new InsertException("插入订单数据时出现未知错误，请联系系统管理员");
		}
	}
	/**
	 * 插入订单商品数据
	 * @param orderItem 订单商品数据
	 */
	private void insertOrderItem(OrderItem orderItem) {
		Integer rows = orderMapper.insertOrderItem(orderItem);
		if(rows != 1) {
		throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
		}
	}
	
	
}
	
