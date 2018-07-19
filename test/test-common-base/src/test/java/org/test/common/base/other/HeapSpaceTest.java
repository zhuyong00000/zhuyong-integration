package org.test.common.base.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhuyong
 * @date: 2018年7月3日 下午5:44:48
 * @description: 
 * @signature: 回家吃饭
 */
public class HeapSpaceTest {
	
	public static void main(String[] args) {
		 List<HeapSpaceTest> list = new ArrayList<HeapSpaceTest>();
		 int count = 0;
		 try {
			while (true) {
				 count++;
				 list.add(new HeapSpaceTest());   //不断创建线程
			}
		} catch (Throwable e) {
			System.out.println("创建实例个数：" + count);
            e.printStackTrace();
		}
	}
}
