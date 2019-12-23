package cn.tedu.store.mapper;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	
	@Autowired
	UserMapper mapper;
	
	@Test
	public void insert() {
		User user = new User();
		user.setUsername("root1");
		user.setPassword("1234");
		Integer r = mapper.insert(user);
		System.out.println(user);
		System.err.println(r);
		System.err.println("Ok");
	}
	
	@Test
	public void updatePasswordByUid() {
		Integer uid = 7;
		String password = "root";
		String modifiedUser = "aaa";
		Date modifiedTime = new Date();
		Integer result = mapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
		System.out.println(result);
	}
	
	@Test
	public void updateInfoByUid() {
		User user = new User();
		user.setUid(2);
		user.setPassword("1234");
		user.setPhone("110120119");
		user.setEmail("10086@163.com");
		user.setGender(1);
		user.setModifiedUser("root1");
		user.setCreatedTime(new Date());
		Integer result = mapper.updateInfoByUid(user);
		System.err.println(result);
	}
	
	@Test
	public void updateAvatarByUid() {
		Integer uid = 3;
		String avatar = "bbb";
		String modifiedUser = "ccc";
		Date modifiedTime = new Date();
		Integer result = mapper.updateAvatarByUid(uid, avatar, modifiedUser, modifiedTime);
		System.err.println(result);
	}
	
	@Test
	public void findByUid() {
		Integer uid = 7;
		User result = mapper.findByUid(uid);
		System.err.println(result);
	}
	
	@Test
	public void findByUsername() {
		String username = "root";
		User r = mapper.findByUsername(username);
		System.err.println(r);
	}
	

}
