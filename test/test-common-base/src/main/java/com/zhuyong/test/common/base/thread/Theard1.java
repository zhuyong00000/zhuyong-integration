package com.zhuyong.test.common.base.thread;

/**
 * 当两个并发线程访问同一个对象object中的这个synchronized(this)，一个时间内只能有一个线程得到执行。另一个线程
 * 必须等待当前线程执行完这个代码块以后才能执行改代码块
 * @author zhuyong
 *
 */
public class Theard1 implements Runnable {

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName()+ " synchronized loop "+i);
			}
		}
	}
	
	public static void main(String[] args) {
		Theard1 t1 = new Theard1();
		Thread ta = new Thread(t1, "A");
		Thread tb = new Thread(t1, "B");
		ta.start();
		System.out.println(111);
		tb.start();
	}
}
