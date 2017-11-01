package com.etoak.modules.test;

import java.util.Date;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etoak.modules.user.bean.User;
import com.etoak.modules.user.service.UserService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac
		= new 
		ClassPathXmlApplicationContext("spring/applicationContext*.xml");
		UserService us = (UserService)ac.getBean("userServiceImpl");
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		user.setUsername("ay2853");
		user.setPassword("123456");
		user.setNickname("взЭО");
		user.setEmail("etoak@et.com");
		user.setTel("110");
		user.setCreateTime(new Date());
		us.add(user);
	}

}
