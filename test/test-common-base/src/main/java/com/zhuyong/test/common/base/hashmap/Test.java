package com.zhuyong.test.common.base.hashmap;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		ZYMap<String, String> zyMap = new ZYHashMap<String, String>();
		for (int i = 0; i < 1000; i++) {
			zyMap.put("key"+i, "value"+i);
		}
		System.out.println("=================一下是我们对上面存值 get===============");
		for (int i = 0; i < 1000; i++) {
			System.out.println("key:"+"key"+i+"             value:"+zyMap.get("key"+i));
		}
//		TreeMap<K, V>
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
//		linkedHashMap.put(key, value)
	}

}
