package com.niit.onetomany;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

/**
 * �����ͻ�����Ϣ���߳�
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
			//��ȡ�ͻ��˵�������
			input = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ȡ�ͻ��˵�����
		clientName = client.getInetAddress().getHostName();
	}
	public void run(){
		//������ȡ�ͻ��˵���Ϣ����
		while(true){
			try {
				String msg = input.readUTF();
				//������Ϣ
				txtMsg.append(clientName+" ˵��"+msg+"\n");
				//�ı������Զ�����
				txtMsg.setCaretPosition(txtMsg.getText().length());
				//�ӳ�
				Thread.sleep(500);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				txtMsg.append(clientName+" �ѶϿ�������\n");
				this.stop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
