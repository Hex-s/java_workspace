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
			//������������
			ServerSocket server = new ServerSocket(9090);
			System.out.println("������������");
			//�������ķ�ʽ�����Ƿ��пͻ������������,���ؿͻ���Socket����
			Socket client = server.accept();
			System.out.println("�ͻ����Ѿ����ӷ�����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
