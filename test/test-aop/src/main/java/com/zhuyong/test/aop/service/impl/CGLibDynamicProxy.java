package com.zhuyong.test.aop.service.impl;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CGLibDynamicProxy implements MethodInterceptor{

	@SuppressWarnings("unused")
	private static CGLibDynamicProxy instance = new CGLibDynamicProxy();
	
	
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
