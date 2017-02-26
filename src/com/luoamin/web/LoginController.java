package com.luoamin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luoamin.bean.AminPamas;
import com.luoamin.bean.User;
import com.luoamin.service.UserServiceImpl;

@Controller
public class LoginController {
	@Autowired
	private UserServiceImpl  service;
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login";
	}
	
	@ResponseBody//阿加科四提交要加上这个注解，加上这个后，方法返回的字符串就是data
	//使用@ResponseBody将会跳过视图处理部分，调用合适的HttpMessageConverter，将返回值写入输出流
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String email,String password,HttpServletRequest request){
		AminPamas  amin=new AminPamas();
		amin.setEmail(email);
		amin.setPassword(password);
		User user=service.login(amin);
		if(user!=null){
			HttpSession  session=request.getSession();
			session.setAttribute("user", user);
			return "index";
		}else{
			return "error";
		}
	}
	
	@RequestMapping(value="/logOut",method=RequestMethod.GET)
	public String logout(HttpServletRequest re){
		HttpSession  session =re.getSession();
		User  user=(User) session.getAttribute("user");
		if(user!=null){
			session.setAttribute("user", "");
		}
		return "redirect:toLogin";
	}
}
