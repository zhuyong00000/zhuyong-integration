package com.zhuyong.test.common.base.datasource;

public class HandleDataSource {
	
	// 数据源名称线程池
	private static final ThreadLocal<String> holder = new ThreadLocal<>();
			
	/**
	 * 设置数据源
	 * @param datasource 数据源名称
	 */
	public static void setDataSource(String datasource) {
		holder.set(datasource);
	}
	
	/**
	 * 获取数据源
	 * @return 数据源名称
	 */
	public static String getDataSource() {
		 return holder.get();
	}
	
	
	/**
	 * 清空数据源
	 */
	public static void clearDataSource() {
		holder.remove();
	}
}
