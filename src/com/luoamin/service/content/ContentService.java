package com.luoamin.service.content;

import java.util.List;

import com.luoamin.bean.AminPamas;
import com.luoamin.bean.Content;

public interface ContentService {
	public List<Content> getContentList(AminPamas amin);
	public int countContentList(AminPamas amin) ;
}
