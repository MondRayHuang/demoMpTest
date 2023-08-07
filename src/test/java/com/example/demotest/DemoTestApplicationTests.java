package com.example.demotest;

import com.example.demotest.entity.User;
import com.example.demotest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoTestApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAll(){
		List<User> userList = userMapper.selectList(null);
		userList.forEach(System.out::println);
	}

	@Test
	public void testAdd(){
		User user = new User();
		user.setAge(25);
		user.setEmail("2469245827@qq.com");
		user.setName("驴的华");
		System.out.println(userMapper.insert(user));
	}

	@Test
	public void testUpdate(){
		User user = new User();
		user.setId(1688555716994740226L);
		user.setAge(310);
		System.out.println(userMapper.updateById(user));
	}


}
