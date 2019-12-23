package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private IUserService service;
	
	@Test
	public void reg() {
		
		try {
			User user = new User();
			user.setUsername("root1");
			user.setPassword("1234");
			//user.setPassword("1234");
			service.reg(user);
			System.err.println("OK");
		} catch (Exception e) {
			System.err.println(e.getClass());
		}
	}
	
	@Test
	public void login() {
		try {
			String username = "root1";
			String password = "1234";
			User user = service.login(username, password);
			System.err.println(user);
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
		
	}
	
	@Test
	public void changeAvatar() {
		try {
			Integer uid = 3;
			String username = "root1";
			String avatar = "img26.jpg";
			service.changeAvatar(uid, username, avatar);
			System.err.println("ok");
		} catch (Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void changePassword() {
		try {
			Integer uid = 1;
			String username = "系统测试";
			String oldPassword = "1234";
			String newPassword = "6666";
			service.changePassword(uid, username, oldPassword, newPassword);
			System.err.println("ok");
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
		
	}
	
	@Test
	public void changeInfo() {
		try {
			Integer uid = 3;
			String username = "root1";
			User user = new User();
			user.setEmail("2@163.com");
			user.setPhone("10086");
			user.setGender(1);
			service.changeInfo(uid, username, user);
			System.err.println("ok");
		} catch (Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void getInfo() {
		try {
			Integer uid = 1;
			User result = service.getInfo(uid);
			System.out.println(result);
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
		
	}
	
}
