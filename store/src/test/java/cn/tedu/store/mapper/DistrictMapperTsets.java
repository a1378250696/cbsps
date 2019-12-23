package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictMapperTsets {
	
	@Autowired
	DistrictMapper mapper;
		
	@Test
	public void findByParent() {
		String parent = "621000";
		List<District> list = mapper.findByParent(parent);
		System.err.println(list.size());
		for (District district : list) {
			System.err.println(district);
		}

	}
	
	@Test
	public void findNameByCode() {
		String code = "440000";
		String name = mapper.findNameByCode(code);
		System.err.println(name);
	}
	
}
