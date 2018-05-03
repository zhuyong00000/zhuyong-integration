package com.zhuyong.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try {
			//创建一个ServerSocket监听8080端口
			ServerSocket server = new ServerSocket(8080);
			//等待请求
			Socket socket = server.accept();                         
			//接收到请求后使用socket进行通信，创建BufferedReader用户读取数据
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = is.readLine();
			System.out.println("received from client : " + line );
			//创建PrintWriter，用户发送数据
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("received data: "+line);
			pw.flush();
			//关闭资源
			pw.close();
			socket.close();
			socket.close();
			server.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
