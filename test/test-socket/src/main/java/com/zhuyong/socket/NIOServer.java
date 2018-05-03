package com.zhuyong.socket;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NIOServer {
	
	public static void main(String[] args) throws Exception{
		//创建ServerSocketChannel，监听8080端口
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(8080));
		//设置为非阻塞模式
		ssc.configureBlocking(false);
		//为ssc注册选择器
		Selector selector = Selector.open();
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		//创建处理器
//		Handler handler = new Handler(1024);
//		zcxv
		
		
			
	}
}

