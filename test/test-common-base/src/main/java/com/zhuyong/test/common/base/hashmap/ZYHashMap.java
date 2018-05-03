package com.zhuyong.test.common.base.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhuyong
 *
 * @param <K>
 * @param <V>
 */
public class ZYHashMap<K, V> implements ZYMap<K, V> {
	// 定义默认数组大小
	private static int defaultLenth = 16;
	// 扩容标准 所使用的数组数量/数组长度 > 0.75 的就会扩容
	private static double defaultAddSizeFactor = 0.75;
	// 使用数组位置的总数
	private int userSize;
	// 定义Map 骨架只要 数组之一
	private Entry<K, V>[] table = null; // 存放对象的表
	
	public int userSize() {
		return userSize;
	}
	public ZYHashMap() {
		this(defaultLenth, defaultAddSizeFactor);
	}
	public ZYHashMap(int length, double defaultAddSizeFactor) {
		if (length < 0) {
			throw new IllegalArgumentException("数组参数不能为负数"+length);
		}
		if (defaultAddSizeFactor <=0 || Double.isNaN(defaultAddSizeFactor)) {
			throw new IllegalArgumentException("扩容标准必须是大于0的数字"+defaultAddSizeFactor);
		}
		this.defaultLenth = length;
		this.defaultAddSizeFactor = defaultAddSizeFactor;
		table = new Entry[defaultLenth];
	}
	
	// 快速存蓄，hash 算法
	@Override
	public V put(K k, V v) {
		// 13 > 16 * 0.75 = 12 (表示要扩容)
		if (userSize > defaultLenth * defaultAddSizeFactor) {
			up2Size();
		}
		// 通过key 来存储位置
		int index = getIndex(k, defaultLenth);
		Entry<K, V> entry = table[index];
		if (entry == null) {
			table[index] = new Entry(k, v, null);
			// 使用的位置总数 +1
			userSize ++;
		} else if (entry != null) {
			// entry != null
			table[index] = new Entry(k, v, entry);
		}
		return table[index].getValue();
	}
	// 就是用来通过自身数据长度和 key 来确定存储位置
	private int getIndex(K k, int length){
		// hashcode 与运算
		int m = length - 1;
		int index = hash(k.hashCode()) & m;
		// 三元运算符做一个处理，
		return index >= 0 ? index : -index;
	}
	// 创建自己的 hash 算法
	private int hash(int hashCode) {
		// 位与算法，主要用于二进制的计算 >>>
		hashCode = hashCode^((hashCode >>> 20)^(hashCode >>> 12));
		return hashCode^((hashCode >>> 7)^(hashCode >>> 4));
	}
	// 徐徐增大容量 这里扩容 2 倍
	private void up2Size() {
		Entry<K, V>[] newTable = new Entry[2*defaultLenth];
		
	}
	
	private void againHash(ZYHashMap<K, V>.Entry<K, V>[] newTble){
		// 数组里面对象封装List
		List<Entry<K,V>> entryList = new ArrayList<Entry<K,V>>();
		for (int i = 0; i < table.length; i++) {
			if (table[i] == null) {
				continue;
			}
			foundEntryByNext(table[i],entryList);
		}
		if (entryList.size() > 0) {
			// 重新分配
			userSize = 0;
			defaultLenth = 2*defaultLenth;
			table = newTble;
			for (Entry<K, V> entry : entryList) {
				if (entry.next != null) {
					// 形成链表关系取消掉，打断链表，重新分配
					entry.next = null;
				}
				put(entry.getKey(), entry.getValue());
			}
		}
	}

	private void foundEntryByNext(ZYHashMap<K, V>.Entry<K, V> entry, List<ZYHashMap<K, V>.Entry<K, V>> entryList) {
		if (entry != null && entry.next != null) {
			// 这个entry对象已经形成链表结构
			entryList.add(entry);
			// 递归
			foundEntryByNext(entry.next, entryList);
		} else {
			entryList.add(entry);
		}
		
	}
	
	// 快取
	@Override
	public V get(K k) {
		int index = getIndex(k, table.length);
		if (table[index] == null) {
			throw new NullPointerException();
		}
		return findValueByEqualKey(k, table[index]);
	}
	
	private V findValueByEqualKey(K k, ZYHashMap<K, V>.Entry<K, V> entry) {
		if (k == entry.getKey() || k.equals(entry.getKey())) {
			return entry.getValue();
		} else if (entry.next != null) {
			return findValueByEqualKey(k, entry.next);
		}
		return null;
	}

	
	public static int getDefaultLenth() {
		return defaultLenth;
	}
	public static void setDefaultLenth(int defaultLenth) {
		ZYHashMap.defaultLenth = defaultLenth;
	}
	public static double getDefaultAddSizeFactor() {
		return defaultAddSizeFactor;
	}
	public static void setDefaultAddSizeFactor(double defaultAddSizeFactor) {
		ZYHashMap.defaultAddSizeFactor = defaultAddSizeFactor;
	}
	public int getUserSize() {
		return userSize;
	}
	public void setUserSize(int userSize) {
		this.userSize = userSize;
	}
	public Entry<K, V>[] getTable() {
		return table;
	}
	public void setTable(Entry<K, V>[] table) {
		this.table = table;
	}


	class Entry<K, V> implements ZYMap.Entry<K, V>{
		K k;
		V v;
		// 指向被 this 挤压下去的 Entry 对象
		Entry<K, V> next;
		public Entry(K k, V v, Entry<K, V> next) {
			this.k = k;
			this.v = v;
			this.next = next;
		}
		@Override
		public K getKey() {
			return k;
		}

		@Override
		public V getValue() {
			return v;
		}
		
	}
}
