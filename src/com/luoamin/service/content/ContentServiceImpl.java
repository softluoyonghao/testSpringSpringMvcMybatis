package com.luoamin.service.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luoamin.bean.AminPamas;
import com.luoamin.bean.Content;
import com.luoamin.dao.content.ContentDao;
@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentDao dao;
	@Override
	public List<Content> getContentList(AminPamas amin) {
		amin.setOrder(" create_time desc ");
		return dao.getContentList(amin);
	}
	@Override
	public int countContentList(AminPamas amin) {
		return dao.countContentList(amin);
	}

}
