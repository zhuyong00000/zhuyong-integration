package org.test.common.base.other;
/**
 * @author: zhuyong
 * @date: 2018年7月3日 下午5:17:03
 * @description: 
 * @signature: 回家吃饭
 */
public class StackOverflowTest {
	
	private static int count = 0;
	
	public static void main(String[] args) {
		StackOverflowTest sof = new StackOverflowTest();
		sof.test();
	}
	
	private void test() {
        try {
            count++;
            test();
        } catch (Throwable e) {     //Exception已经捕获不了JVM抛出的StackOverflowError
            System.out.println("递归调用次数" + count);
            e.printStackTrace();
        }
    }
}
