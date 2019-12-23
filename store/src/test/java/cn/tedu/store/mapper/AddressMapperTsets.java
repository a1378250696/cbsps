package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTsets {
	
	@Autowired
	AddressMapper mapper;
	
	@Test
	public void insert() {
		Address address = new Address();
		address.setUid(2);
		address.setName("东莞市东城区君豪大厦20层");
		Integer rows = mapper.insert(address);
		System.err.println(rows);
		System.err.println();
		System.err.println("Ok");

	}
	
	@Test
	public void countByUid() {
		
		Integer uid = 1;
		Integer count = mapper.countByUid(uid);
		System.err.println(count);
		
	}
	
	@Test
	public void findByUid() {
		
		Integer uid = 5;
		List<Address> list = mapper.findByUid(uid);
		System.err.println(list.size());
		for (Address address : list) {
			System.err.println(address);
		}
		
	}
	
	@Test
	public void findByAid() {
		Integer aid = 5;
		Address list = mapper.findByAid(aid);
		System.err.println(list);
	}
	
	@Test
	public void findLastModified() {
		Integer uid = 7;
		Address row = mapper.findLastModified(uid);
		System.err.println(row);
	}
	
	@Test
	public void updateDefultByAid() {
		Integer aid = 5;
		String modifedUser = "root";
		Date modifiedTime = new Date();
		Integer rows = mapper.updateDefultByAid(aid, modifedUser, modifiedTime);
		System.err.println(rows);
	}
	
	@Test
	public void updateNonDefaultByUid() {
		Integer uid =7;
		Integer row =  mapper.updateNonDefaultByUid(uid);
		System.err.println(row);
	}
	
	
	@Test
	public void deleteByAid() {
		Integer aid = 8;
		Integer row = mapper.deleteByAid(aid);
		System.err.println(row);
	}
	
}
