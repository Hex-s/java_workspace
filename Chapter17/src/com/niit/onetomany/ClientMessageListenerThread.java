package com.niit.onetomany;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

/**
 * 监听客户端信息的线程
 * @author Administrator
 *
 */
public class ClientMessageListenerThread extends Thread {
	
	private Socket client;
	private JTextArea txtMsg;
	private DataInputStream input;
	private String clientName;
	
	public ClientMessageListenerThread(Socket client, JTextArea txtMsg){
		this.client = client;
		this.txtMsg = txtMsg;
		try {
			//获取客户端的输入流
			input = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取客户端的名称
		clientName = client.getInetAddress().getHostName();
	}
	public void run(){
		//反复读取客户端的信息内容
		while(true){
			try {
				String msg = input.readUTF();
				//呈现信息
				txtMsg.append(clientName+" 说："+msg+"\n");
				//文本内容自动滚动
				txtMsg.setCaretPosition(txtMsg.getText().length());
				//延迟
				Thread.sleep(500);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				txtMsg.append(clientName+" 已断开了连接\n");
				this.stop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
