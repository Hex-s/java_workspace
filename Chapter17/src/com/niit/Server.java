package com.niit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try {
			//创建服务器端
			ServerSocket server = new ServerSocket(9090);
			System.out.println("服务器已启动");
			//以阻塞的方式监听是否有客户端连入服务器,返回客户端Socket对象
			Socket client = server.accept();
			System.out.println("客户端已经连接服务器");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
