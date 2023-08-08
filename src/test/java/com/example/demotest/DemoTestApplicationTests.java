package com.example.demotest;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demotest.entity.User;
import com.example.demotest.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

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
	//添加
	public void testAdd(){
		User user = new User();
		user.setAge(25);
		user.setEmail("2469245827@qq.com");
		user.setName("驴的华");
		System.out.println(userMapper.insert(user));
	}

	@Test
	//修改
	public void testUpdate(){
		User user = new User();
		user.setId(1688555716994740226L);
		user.setAge(310);
		System.out.println(userMapper.updateById(user));
	}

	@Test
	//乐观锁
	public void optimisticTest(){
		User user = userMapper.selectById(1);
		user.setName("小余");
		userMapper.updateById(user);
		user = userMapper.selectById((1));
		System.out.println(user.getVersion());

	}

	@Test
	//批量查询
	public void testSelectMore(){
		List<User> userList = userMapper.selectBatchIds(Arrays.asList(1,2,3));
		System.out.println(userList);
	}

	@Test
	//简单条件查询
	public void testConditionalSelect(){
		HashMap<String,Object> columnMap = new HashMap<String,Object>();
		columnMap.put("name","jack");
		columnMap.put("age",20);
		List<User> userList =  userMapper.selectByMap(columnMap);
		System.out.println(userList);
	}

	@Test
	//分页查询
	public void testSelectPage(){
		Page<User> page = new Page<>(1,3);
		Page<User> userPage = userMapper.selectPage(page,null);
		Long pages = userPage.getPages();//总页数
		long current = userPage.getCurrent();//获取当前页
		long total = userPage.getTotal();//获取总记录数
		boolean hasNext = userPage.hasNext();//下一页
		boolean hasPrevious = userPage.hasPrevious();//上一页
		List<User> records = userPage.getRecords();
		List<OrderItem> orders = userPage.getOrders();
		System.out.println(pages);
		System.out.println(current);
		System.out.println(total);
		System.out.println(hasNext);
		System.out.println(hasPrevious);
		System.out.println(records);
		System.out.println(orders);
		System.out.println(userPage.getSize());
	}

	@Test
	public void testSelectMapsPage() {
		Page<Map<String, Object>> page = new Page<>(1, 5);
		Page<Map<String, Object>> pageParam = userMapper.selectMapsPage(page, null);
		List<Map<String, Object>> records = pageParam.getRecords();
		records.forEach(System.out::println);
		System.out.println(pageParam.getPages());
		System.out.println(pageParam.getCurrent());
		System.out.println(pageParam.getTotal());
		System.out.println(pageParam.getSize());
		System.out.println(pageParam.hasNext());
		System.out.println(pageParam.hasPrevious());
	}

	@Test
	public void testDeleteById(){
		System.out.println(userMapper.deleteById(1688555716994740242L));
	}

	@Test
	public void testDeleteBatchIds(){
		int result = userMapper.deleteBatchIds(Arrays.asList(1688555716994740239L
				,1688555716994740240L,1688555716994740241L));
		System.out.println(result);
	}

	@Test
	//条件删除
	public void testDeleteByMap(){
		HashMap<String,Object> map = new HashMap<>();
		map.put("name","驴的华");
		System.out.println(userMapper.deleteByMap(map));
	}

	@Test
	//逻辑删除
	public void testLogicDelete(){
		System.out.println(userMapper.deleteById(1L));
		System.out.println(userMapper.selectById(1L));
	}

}
