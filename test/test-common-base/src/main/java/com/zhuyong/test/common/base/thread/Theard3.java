package com.zhuyong.test.common.base.thread;


/**
 * 当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其他synchronized(this)同步代码块的
 * 访问将被阻塞
 * @author zhuyong
 */
public class Theard3 {

	public void m4t1() {
		synchronized (this) {
			int i = 5;
			while(i-- > 0) {
				System.out.println(Thread.currentThread().getName()+" : "+i);
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void m4t2() {
		synchronized (this) {
			int i = 5;
			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName()+" : "+i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		final Theard3 theard2 = new Theard3();
		Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					theard2.m4t1();
				}
			}, "t1"
		);
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				theard2.m4t2();
			}
		}, "t2");
		
		t1.start();
		t2.start();
	}
	
	
}
