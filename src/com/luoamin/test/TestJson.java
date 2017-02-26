package com.luoamin.test;

import com.luoamin.bean.AminPamas;

import net.sf.json.JSONArray;

public class TestJson {

	public static void main(String[] args) {
		AminPamas aaa=new AminPamas();
		aaa.setAccount("ddd");
		aaa.setEmail("ggg");
		JSONArray arr=JSONArray.fromObject(aaa);
		System.out.println("womenaini");
		System.out.println("womenaini");
		System.out.println("womenaini");
	}
}
