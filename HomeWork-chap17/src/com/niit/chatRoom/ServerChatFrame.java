package com.niit.chatRoom;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ServerChatFrame extends JFrame{

	private JSplitPane spnl;
	private JScrollPane scrollPnl;
	private JTextArea txtMsg;
	private JPanel pnl;
	private JTextField txtSend;
	private JButton btnSend;
	
	//�����
	private ServerSocket server;
	//�ͻ���
	private Socket client;
	//�ͻ���������
	private DataInputStream input;
	//�ͻ��������
	private DataOutputStream output;
	
	//�û���¼�߳�
	private ClientThread clientThread;
	private ClientMessageListenerThread thread;
	
	private String clientName = "";
	
	public ServerChatFrame(){
		this.setTitle("������");
		this.setBounds(300, 200, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
		//���ô����Ĭ�ϻس���ť
		this.getRootPane().setDefaultButton(btnSend);
		bindListener();
		runServer();
	}
	
	/**
	 * ���з�����
	 */
	private void runServer(){
		//����������
		try {
			server = new ServerSocket(9090);
			txtMsg.append("��������������\n");
			btnSend.setEnabled(true);
			//�����û���¼�߳�
			clientThread = new ClientThread();
			clientThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * �û��߳�
	 * @author Administrator
	 *
	 */
	private class ClientThread extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					//�����ͻ��˵�����
					client = server.accept();
					//��ȡ�ͻ�������
					clientName = client.getInetAddress().getHostName();
					txtMsg.append(clientName +"�����ӷ�������\n");
					//��ȡ�ͻ���������
					input = new DataInputStream(client.getInputStream());
					//��ȡ�ͻ��������
					output = new DataOutputStream(client.getOutputStream());
					//������ӷ��������������ͻ�����Ϣ���߳�
					thread = new ClientMessageListenerThread();
					thread.start();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	/**
	 * �����ͻ��˷�����Ϣ���߳�
	 * @author Administrator
	 *
	 */
	private class ClientMessageListenerThread extends Thread{
		public void run(){
			//������ȡ�ͻ��˵���Ϣ����
			while(true){
				try {
					String msg = input.readUTF();
					//������Ϣ
					txtMsg.append(clientName+" ˵��"+msg+"\n");
					//�ӳ�
					Thread.sleep(500);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					txtMsg.append(clientName+" �ѶϿ�������");
					this.stop();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 
	 * @author Administrator
	 *
	 */
	private class SendListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//��ȡ�ı������������
			String msg = txtSend.getText().trim();
			if(msg.equals("")){
				JOptionPane.showMessageDialog(null, "���������ݣ�");
				return;
			}
			try {
				txtMsg.append("��˵��"+msg+"\n");
				//ʹ�������д�뷢����Ϣ��socket�ͻ�����
				output.writeUTF(msg);
				//��ջ�����
				output.flush();
				//����ı�����Ϣ
				txtSend.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	/**
	 * ������Ϣ������
	 */
	private void bindListener(){
		btnSend.addActionListener(new SendListener());
	}
	/**
	 *  ��ʼ�����
	 */
	private void initComponent(){
		//�����������
		scrollPnl = new JScrollPane();
		//�������
		pnl = new JPanel();
		//�����ָ����
		spnl = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPnl, pnl);
		spnl.setDividerLocation(220);
		spnl.setDividerSize(2);
		this.add(spnl);
		//�����ı���
		txtMsg = new JTextArea();
		txtMsg.setEditable(false);
		//����ı������������
		scrollPnl.getViewport().add(txtMsg);
		//���������ı���
		txtSend = new JTextField();
		txtSend.setColumns(20);
		//������ť
		btnSend = new JButton("send");
		pnl.setLayout(new FlowLayout());
		//��������
		pnl.add(txtSend);
		pnl.add(btnSend);
		
		this.setVisible(true);
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ServerChatFrame frm = new ServerChatFrame();
	}

}
