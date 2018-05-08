package com.zhuyong.test.common.base.thread;

/**
 * 多线程实现，模拟三个售票窗口同时出售20张票
 * @author zhuyong
 *
 */
public class StationTicket extends Thread {
	
	// 通过构造方法给线程赋值
	public StationTicket(String name) {
		super(name);
	}
	
	// 为了保持票数的一致，票数要静态
	private static int tick = 20;
	
	// 创建一个静态钥匙
	private static Object ob = "aa";  // 值是任意的

	// 重写run方法
	@Override
	public void run() {
		while (tick > 0) {
			// 使用一个锁
			synchronized (ob) {
				if (tick > 0) {
					System.out.println(getName()+"卖出了第"+tick+"张票");
					tick--;
				} else {
					System.out.println("票卖完了");
				}
			}
			try {
				sleep(1000); // 休息一秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * java 多线程同步锁的使用
	 * 示例：三个售票窗口同时出售20张票
	 * @param args
	 */
	public static void main(String[] args) {
		// 实例化站台对象，并为每一个站台取名字
		StationTicket stationTicket1 = new StationTicket("窗口1");
		StationTicket stationTicket2 = new StationTicket("窗口2");
		StationTicket stationTicket3 = new StationTicket("窗口3");
		
		// 让每一个站台对象各自开始工作
		stationTicket1.start();
		stationTicket2.start();
		stationTicket3.start();
	}
}
