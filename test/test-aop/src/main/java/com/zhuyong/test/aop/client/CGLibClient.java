package com.zhuyong.test.aop.client;

import com.zhuyong.test.aop.model.Person;
import com.zhuyong.test.common.base.util.json.JSONUtils;


public class CGLibClient {
	
	public static void main(String[] args) {
		
		Person person = new Person();
		System.out.println(JSONUtils.converterToString(person));
	}
	
}
