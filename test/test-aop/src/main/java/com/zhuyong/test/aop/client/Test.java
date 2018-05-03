package com.zhuyong.test.aop.client;

import java.util.HashMap;

import com.zhuyong.test.aop.service.TestInterface;
import com.zhuyong.test.aop.service.impl.TestInteface1Impl;

public class Test {
	
	private static TestInterface testInterface;
	
	
	public static TestInterface getTestInterface() {
		return testInterface;
	}


	public static void setTestInterface(TestInterface testInterface) {
		Test.testInterface = testInterface;
	}


	public static void main(String[] args) {
		
		Object arg = "";
		if (Integer.class.isAssignableFrom(arg.getClass())) {
			
		}
		TestInterface testInterface1 = new TestInteface1Impl();
		testInterface1.testInteface();
//		HashMap<K, V>
	}
	
}
