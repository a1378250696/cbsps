package cn.tedu.store.service;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTsets {
	
	@Autowired
	private ICartService service;
		
	@Test
	public void addToCart() {
		try {
			Integer uid = 2;
			String username = "root";
			Integer pid = 10000032;
			Integer amount = 3;
			service.addToCart(uid, username, pid, amount);
			System.err.println("OK");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getVOByUid() {
		Integer uid = 9;
		List<CartVO> list = service.getVOByUid(uid);
		System.err.println(list);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}
	
	@Test
	public void addNum() {
		try {
		Integer uid = 2;
		Integer cid = 2;
		String username = "root";
		Integer num = service.addNum(cid, uid, username);
		System.err.println("OK" + num);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getVOByCids() {
		Integer[] cids = {1,2,3,4,5};
		Integer uid = 2;
		List<CartVO> list = service.getVOByCids(cids,uid );
		System.err.println(list);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}
	
	@Test
	public void delete() {
		try {
		Integer[] cids = {3,4,5};
		Integer uid = 9;
		service.delete(cids, uid);
		System.err.println("OK");
	} catch (ServiceException e) {
		System.err.println(e.getClass().getSimpleName());
		System.err.println(e.getMessage());
	}
	}
}
