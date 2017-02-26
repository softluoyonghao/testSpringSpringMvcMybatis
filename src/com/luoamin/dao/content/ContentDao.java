package com.luoamin.dao.content;

import java.util.List;

import com.luoamin.bean.AminPamas;
import com.luoamin.bean.Content;

public interface ContentDao {
	public List<Content> getContentList(AminPamas amin);
	public int countContentList(AminPamas amin) ;
}
