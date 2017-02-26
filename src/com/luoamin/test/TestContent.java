package com.luoamin.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luoamin.bean.AminPamas;
import com.luoamin.bean.Content;
import com.luoamin.service.content.ContentService;

@RunWith(SpringJUnit4ClassRunner.class)//这两行代码的意思是可以使用注解注入的方式将bean注入进行测试，如果没有这两行代码则不能引入外来类
@ContextConfiguration("classpath:applicationContext.xml")
public class TestContent {
	@Autowired
	private ContentService service;
	
	@Test
	public void test1(){
		AminPamas amin=new AminPamas();
		List<Content>list=service.getContentList(amin);
		for (Content content : list) {
			System.out.println(content.getTitle());
		}
	} 
}
