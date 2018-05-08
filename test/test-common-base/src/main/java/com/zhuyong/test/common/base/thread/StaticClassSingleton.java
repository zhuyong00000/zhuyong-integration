package com.zhuyong.test.common.base.thread;

/**
 * 静态内部类实现单例模式
 * @author zhuyong
 *
 */
public class StaticClassSingleton {

	// 私有构造方法，防止 new
	private StaticClassSingleton() {
		
	}
	
	private static StaticClassSingleton getInstance() {
		return StaticClassSingletonHolder.instance;
	}
	
	/**
	 * 静态内部类
	 */
	private static class StaticClassSingletonHolder {
		// 第一次加载内部类的时候，实例化单例对象
		private static final StaticClassSingleton instance = new StaticClassSingleton();
	}
}
