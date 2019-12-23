package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {
	
	@Autowired
	private IOrderService orderService;
	
	@Test
	public void create() {
		try {
			Integer uid = 9;
			String username = "soso";
			Integer aid = 18;
			Integer[] cids = {3,4,5,6,7};
			orderService.create(uid, username, aid, cids);
			System.err.println("OK");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
	}
	
}
