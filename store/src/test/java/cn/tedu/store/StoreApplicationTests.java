package cn.tedu.store;

import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	DataSource dataSource;

	@Test
	public void getConnection() throws SQLException {
		System.err.println(dataSource.getConnection());
	}

	@Test
	public void md5() {
		
//		String password = "123456";	
//		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
//			System.err.println(md5Password);
			
			String password = "123456";
			String salt = "baidu";
			password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes());
			System.err.println(password);
				
	}

//	@Test
//	public void commonsCodec() {
//
//		String password = "123456";
//
//		password = DigestUtils.md5DigestAsHex(password);
//
//				System.err.println(password);
//
//	}

	@Test
	public void uuid() {
		for (int i = 0; i < 5; i++) {
			String salt = UUID.randomUUID().toString();
			System.err.println(salt);
		}
	}

}
