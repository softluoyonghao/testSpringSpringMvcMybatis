package com.luoamin.dao.user;

import org.springframework.stereotype.Repository;

import com.luoamin.bean.AminPamas;
import com.luoamin.bean.User;
@Repository("usermap")
public interface IUserMapper {
	public User login(AminPamas amin);

}
