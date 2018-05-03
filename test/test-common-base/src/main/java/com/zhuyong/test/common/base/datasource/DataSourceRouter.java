package com.zhuyong.test.common.base.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * AbstractRoutingDataSource 是spring提供的一个多数据源抽象类
 * @author zhuyong
 * spring会在使用事务的地方来调用此类的determineCurrentLookupKey()方法来获取数据源的key值
 * 继承此抽象类并实现此方法
 */
public class DataSourceRouter extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		
		return HandleDataSource.getDataSource();
	}
	
	
	
}
