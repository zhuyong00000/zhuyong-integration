package com.zhuyong.test.aop.client;

import com.zhuyong.test.aop.service.Greeting;
import com.zhuyong.test.aop.service.impl.GreetingImpl;
import com.zhuyong.test.aop.service.impl.GreetingProxy;

public class ProxyClient {
	
	 public static void main(String[] args) {
//	    	用这个 GreetingProxy 去代理 GreetingImpl
			Greeting greetingProxy = new GreetingProxy(new GreetingImpl());
			greetingProxy.sayHello("zhuyong");
	    }
	
}
