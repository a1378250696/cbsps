package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTsets {
	
	@Autowired
	private IAddressService service;
	
	@Value("${project.address.max-count}")
	private Integer maxCount;
	
	@Test
	public void addnew() {
		try {
			Integer uid = 2;
			String username = "东莞东城区";
			Address address = new Address();
			address.setName("游客");
			service.addnew(uid, username, address);
			System.err.println("OK");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByUid() {
		
		Integer uid = 5;
		List<Address> list = service.getByUid(uid);
		System.err.println(list.size());
		for (Address address : list) {
			System.err.println(address);
		}
		
	}
	
	@Test
	public void setDefault() {
		try {
			Integer uid = 5;
			Integer aid = 3;
			String username = "东莞东城区";
			service.setDefault(aid, uid, username);
			System.err.println("OK");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void delete() {
		try {
			Integer uid = 7;
			Integer aid = 7;
			String username = "东莞东城区";
			service.delete(aid, uid, username);
			System.err.println("OK");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByAid() {
		try {
			Integer aid = 18;
			Integer uid = 9;
			Address result = service.getbyAid(aid, uid);
			System.err.println(result);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getSimpleName());
			System.err.println(e.getMessage());
		}
	}
	
}
