package com.zhuyong.test.common.base.proxy;

import java.lang.reflect.Method;


public class ProxyTest {
	
	
	public void testProxy() throws Throwable {
		// 实例化目标对象
		UserService userService = new UserServiceImpl();
		
		// 实例化InvocationHandler
		MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
		
		// 根据目标对象生成代理对象
		UserService proxy = (UserService) invocationHandler.getProxy();
		
		// 调用代理对象的方法
		proxy.add();
	}
	
	
	public void setValue1(String sss) {
		System.out.println("sss="+sss);
		System.out.println("setValue1");
	}
	public void setValue2() {
		System.out.println("setValue2");
	}
	public static void main(String[] args) throws Exception {
		try {
			Method method = ProxyTest.class.getMethod("setValue1", String.class);
			System.out.println("method.getDeclaringClass="+method.getDeclaringClass());
			method.invoke(new ProxyTest(), "我是传入的参数string");
			System.out.println(method);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
