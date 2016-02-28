package com.niit.onetomany;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * �������������
 * @author Administrator
 *
 */
public class ClientChatFrame extends JFrame {
	private JSplitPane spnl;
	private JScrollPane scrollPnl;
	private JTextArea txtMsg;
	private JPanel pnl;
	private JTextField txtSend;
	private JButton btnSend;
	private Socket client;
	private ServerListenerThread thread;
	//�ͻ��˵������
	private DataOutputStream output;
	//������
	private DataInputStream input;
	private String serverName;
	//������������Ϣ�߳�
	private ServerMessageListenerThread msgThread;
	
	public ClientChatFrame(){
		this.setTitle("�ͻ���");
		this.setBounds(300, 200, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
		bindListener();
		runClient();
	}
	/**
	 * ���пͻ���
	 */
	private void runClient(){
		thread = new ServerListenerThread();
		thread.start();
	}
	/**
	 * �������������߳�
	 * @author Administrator
	 *
	 */
	private class ServerListenerThread extends Thread{
		public void run(){
			int count = 0;
			while(count < 3){
				count++;
				try {
					client = new Socket("192.168.3.100",9090);
					txtMsg.append("�ͻ���������\n");
					btnSend.setEnabled(true);
					//��ȡ�ͻ������ӵ�Զ�̷������ĵ�ַ����
					InetSocketAddress address = (InetSocketAddress)client.getRemoteSocketAddress();
					serverName = address.getHostName();
					//��ȡ�����
					output = new DataOutputStream(client.getOutputStream());
					//��ȡ������
					input = new DataInputStream(client.getInputStream());
					//��������������������������Ϣ���߳�
					msgThread = new ServerMessageListenerThread();
					msgThread.start();
					//�ͻ���������ر��߳�
					this.stop();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					txtMsg.append("���ӳ�ʱ��3����������ӷ�����\n");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			txtMsg.append("����������ʧ�ܣ�\n");
		}
	}
	/**
	 * ����������������Ϣ���߳�
	 * @author Administrator
	 *
	 */
	private class ServerMessageListenerThread extends Thread{
		public void run(){
			//������ȡ�ͻ��˵���Ϣ����
			while(true){
				try {
					String msg = input.readUTF();
					//������Ϣ
					txtMsg.append(serverName+" ˵��"+msg+"\n");
					//�ӳ�
					Thread.sleep(500);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					txtMsg.append(serverName+" �ѶϿ�������");
					this.stop();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
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
		btnSend.setEnabled(false);
		pnl.setLayout(new FlowLayout());
		//��������
		pnl.add(txtSend);
		pnl.add(btnSend);
		
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		ClientChatFrame frm = new ClientChatFrame();
	}
}
