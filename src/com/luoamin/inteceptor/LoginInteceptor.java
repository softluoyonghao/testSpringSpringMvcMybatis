package com.luoamin.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.luoamin.bean.User;

public class LoginInteceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest re, HttpServletResponse res,
			Object arg2) throws Exception {
		User user=(User) re.getSession().getAttribute("user");
		if(user!=null){
			return true;
		}else{
			res.sendRedirect(re.getContextPath()+"/toLogin");
			return false;
		}
		
	}

}
