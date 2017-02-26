package com.luoamin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luoamin.bean.AminPamas;
import com.luoamin.bean.User;
import com.luoamin.dao.user.IUserMapper;

@Service("userServiceImpl")
public class UserServiceImpl {

	@Autowired
	private IUserMapper mapper;
	public User login(AminPamas amin){
		return mapper.login(amin);
	}
}
