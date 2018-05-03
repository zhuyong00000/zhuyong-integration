package com.zhuyong.test.common.base.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class EnvironmentContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		// 侦测jvm环境，并缓存到全局变量中
		String env = System.getProperty("spring.profiles.active");
		System.out.println("全局变量的值 ： "+env);
		if (env == null) {
//			Environment.currentEnvironment = "development";
			System.out.println("jvm环境的 profiles ："+env);
		} else {
			System.out.println("jvm的环境为null");
//			Environment.currentEnvironment = env;
		}
	}

}
