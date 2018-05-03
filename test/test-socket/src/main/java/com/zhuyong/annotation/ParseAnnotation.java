package com.zhuyong.annotation;

import java.lang.annotation.Annotation;

public class ParseAnnotation {

	
	@SuppressWarnings("rawtypes")
	public static void parseTypeAnnotation() throws ClassNotFoundException {
		
		Class clazz = Class.forName("com.zhuyong.annotation.UserAnnotation");
		
		Annotation[] annotations = clazz.getAnnotations();
		
		for (Annotation annotation : annotations) {
			TestA testA = (TestA) annotation;
			System.out.println("id = "+testA.id()+";name="+testA.name()+";gid="+testA.gid());
		}
		
		
	}
	
	public static void main(String []args) throws ClassNotFoundException{
		parseTypeAnnotation();
	}
 	
}
