package com.luoamin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.druid.pool.DruidDataSource;
import com.luoamin.bean.AminPamas;
import com.luoamin.bean.User;
import com.luoamin.dao.user.IUserMapper;
@RunWith(SpringJUnit4ClassRunner.class)//这两行代码的意思是可以使用注解注入的方式将bean注入进行测试，如果没有这两行代码则不能引入外来类
@ContextConfiguration("classpath:applicationContext.xml")
public class DataSourceTest {
	@Autowired
	private IUserMapper  usermap;
	
	@Test
	public void testData(){
		ApplicationContext  con=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		DruidDataSource ss=con.getBean("dataSource",DruidDataSource.class);
		DruidDataSource ss1=con.getBean(DruidDataSource.class);
		System.out.println(ss);
		System.out.println(ss1);
		
		AminPamas  aaa=new AminPamas();
		aaa.setAccount("amin");
		aaa.setPassword("111");
		User user=usermap.login(aaa);
		System.out.println(user.getId());
	}
	
}
