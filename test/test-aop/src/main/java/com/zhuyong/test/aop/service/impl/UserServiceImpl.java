package com.zhuyong.test.aop.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuyong.test.aop.mapper.UserMapper;
import com.zhuyong.test.aop.service.IUserService;
import com.zhuyong.test.common.base.annotation.DataSource;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	@DataSource("write")
	public List<Map<String, Object>> queryUserList() {
		return userMapper.queryUserList();
	}
	
	@Override
	@DataSource("read")
	public List<Map<String, Object>> queryUserLocalDataSourceList() {
		return userMapper.queryUserList();
	}
}
