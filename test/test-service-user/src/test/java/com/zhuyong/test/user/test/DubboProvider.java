package com.zhuyong.test.user.test;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动dubbo用 MainClass
 * @author zhuyong
 *
 */
public class DubboProvider {
	
	static Logger logger = Logger.getLogger(DubboProvider.class);
	
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springLocalContext.xml");
			context.start();
			logger.info("...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		synchronized (DubboProvider.class) {
			while (true) {
				try {
					DubboProvider.class.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
