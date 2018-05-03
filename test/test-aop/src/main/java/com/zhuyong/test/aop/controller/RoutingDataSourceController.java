package com.zhuyong.test.aop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuyong.test.aop.service.IUserService;

/**
 * 读写库分段调用
 * @author zhuyong
 *
 */
@Controller
@RequestMapping("/dataSource")
public class RoutingDataSourceController {
	
	@Autowired
	IUserService userServiceImpl;
	
	/**
	 * 调用 @DataSource("write") 写库
	 * @return
	 */
	@RequestMapping(value = "/get", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Object getRoutingDataSourceTest() {
		// 写库
		List<Map<String, Object>> queryUserList = userServiceImpl.queryUserList();
		return queryUserList;
	}
	
	/**
	 * 调用 @DataSource("read") 读库
	 * @return
	 */
	@RequestMapping(value = "/getLocalDataSource", method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Object getLocalDataSource() {
		// 读库
		List<Map<String, Object>> queryUserList = userServiceImpl.queryUserLocalDataSourceList();
		return queryUserList;
	}
}
