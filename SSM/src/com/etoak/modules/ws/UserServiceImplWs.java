package com.etoak.modules.ws;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.modules.user.mapper.UserMapper;

@Service
@WebService
public class UserServiceImplWs implements UserServiceWs{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public String login(String username, String password) {
		//userMapper.login(username,password);
		System.out.println("服务端接收：" + username + "|" + password);
		return username + "|" + password;
	}

}
