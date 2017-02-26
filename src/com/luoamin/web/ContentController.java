package com.luoamin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.luoamin.bean.AminPamas;
import com.luoamin.bean.Content;
import com.luoamin.service.content.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService service;
	
	@RequestMapping("/list")
	public ModelAndView  getContents(AminPamas amin){
		ModelAndView  view =new ModelAndView();
		List<Content>list=service.getContentList(amin);
		int count=service.countContentList(amin);
		view.setViewName("content/list");
		view.addObject("datas",list);
		view.addObject("count",count);
		return view;
	}
	
	@RequestMapping("/templete")
	public ModelAndView  contentsTleplete(AminPamas amin){
		ModelAndView  view =new ModelAndView();
		List<Content>list=service.getContentList(amin);
		int count=service.countContentList(amin);
		view.setViewName("content/templete");
		view.addObject("datas",list);
		view.addObject("count",count);
		return view;
	}
}
