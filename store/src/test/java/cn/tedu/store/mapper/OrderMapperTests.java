package cn.tedu.store.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTests {
	
	@Autowired
	private OrderMapper mapper;
	
	@Test
	public void insertOrder() {
		
		Order order = new Order();
		order.setUid(1);
		order.setRecvName("a");
		order.setRecvPhone("b");
		order.setRecvProvince("c");
		order.setRecvCity("d");
		order.setRecvArea("e");
		order.setRecvAddress("f");
		order.setTotalPrice(12L);
		order.setModifiedUser("g");
		order.setCreatedTime(new Date());
		Integer rows = mapper.insertOrder(order);
		System.err.println(rows);
		
	}
	
	@Test
	public void insertOrderItem() {
		
		OrderItem orderItem = new OrderItem();
		orderItem.setOid(2);
		orderItem.setPid(3);
		orderItem.setTitle("h");
		orderItem.setImage("i");
		orderItem.setPrice(33333L);
		orderItem.setNum(4);
		orderItem.setModifiedUser("j");
		orderItem.setCreatedTime(new Date());
		Integer rows = mapper.insertOrderItem(orderItem);
		System.err.println(rows);
		
	}
	
}
