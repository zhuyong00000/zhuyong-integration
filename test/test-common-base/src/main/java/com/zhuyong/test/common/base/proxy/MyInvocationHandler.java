package com.zhuyong.test.common.base.proxy;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

import com.zhuyong.test.common.base.util.JSONUtils;


/**
 * 实现自己的InvocationHandler
 * @author zhuyong
 *
 */
public class MyInvocationHandler implements InvocationHandler {

	// 目标对象
	private Object target;
	
	
	/** 
     * 构造方法 
     * @param target 目标对象  
     */ 
	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}
	
	
	/**
	 * 执行目标对象的方法 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("------------------before------------------");
		Object result = method.invoke(target, args);
		System.out.println("-------------------after------------------");  
		return result;
	}
	
	/**
	 * 获取目标对象的代理对象
	 * @return 代理对象
	 */
	public Object getProxy() {
		Class<?>[] interfaces = target.getClass().getInterfaces();
		System.out.println("clone : "+JSONUtils.converterToString(interfaces.clone()));
		System.out.println("target.interfaces : "+JSONUtils.converterToString(interfaces)+",interfaces.length="+interfaces.length);
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),target.getClass().getInterfaces(),this);
	}
}
