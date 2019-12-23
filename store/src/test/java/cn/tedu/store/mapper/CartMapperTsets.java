package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTsets {
	
	@Autowired
	private CartMapper mapper;
	
	@Test
	public void insert() {
		Cart cart = new Cart();
		cart.setUid(1);
		cart.setPid(2);
		cart.setNum(3);
		Integer rows = mapper.insert(cart);
		System.err.println(rows);
		System.err.println();
		System.err.println("Ok");
	}
		
	@Test
	public void updateNumByCid() {
		
		Integer cid = 1;
		Integer num = 10;
		String modifiedUser = "ABCDE";
		Date modifiedTime = new Date();
		Integer rows = mapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);
		System.err.println(rows);
		
	}
	
	@Test
	public void findByCid() {
		
		Integer cid = 1;
		Cart t = mapper.findByCid(cid);
		System.err.println(t);
				
	}
	
	@Test
	public void findByUidAndPid() {
		Integer uid = 1;
		Integer pid = 2;
		Cart result = mapper.findByUidAndPid(uid, pid);
		System.err.println(result);
	}
	
	@Test
	public void findVOByUid() {
		Integer uid = 18;
		List<CartVO> list = mapper.findVOByUid(uid);
		System.err.println("count=" + list.size());
		for (CartVO item : list) {
			System.err.println(item);
		}
	}
	
	@Test
	public void findVOByCids() {
		
		Integer[] cids = {4,7,9};
		List<CartVO> list = mapper.findVOByCids(cids);
		System.err.println(list.size());
		for (CartVO cartVO : list) {
			System.err.println(cartVO);
		}
		
	}
	
	@Test
	public void deleteByCids() {
		
		Integer[] cids = {4,7,9};
		Integer rows = mapper.deleteByCids(cids);
		System.err.println(rows);
		
	}
	
}
