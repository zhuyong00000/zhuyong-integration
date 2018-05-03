package com.zhuyong.test.aop.service;

import java.util.List;
import java.util.Map;

public interface IUserService {

	public List<Map<String, Object>> queryUserList();
	
	public List<Map<String, Object>> queryUserLocalDataSourceList();
}
