package com.zhuyong.test.aop.client;

import com.zhuyong.test.aop.service.Greeting;
import com.zhuyong.test.aop.service.impl.GreetingImpl;
import com.zhuyong.test.aop.service.impl.JDKDynamicProxy;

public class JDKProxyClient {
	
	public static void main(String[] args) {
		Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
		greeting.sayHello("zhuyong");
	}
	
}
