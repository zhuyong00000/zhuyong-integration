package com.zhuyong.test.common.base.hashmap;

/**
 * 面向接口编程思想
 * 双列集合接口
 * @author zhuyong
 *
 */
public interface ZYMap<K,V> {

	// 基本功能是 快速存 快速取
	public V put(K k, V v);
	// 快速取
	public V get(K k);
	// 定义一个内部接口
	public interface Entry<K,V>{
		public K getKey();
		public V getValue();
	}
}
