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
 * 服务器聊天界面
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
	//客户端的输出流
	private DataOutputStream output;
	//输入流
	private DataInputStream input;
	private String serverName;
	//监听服务器信息线程
	private ServerMessageListenerThread msgThread;
	
	public ClientChatFrame(){
		this.setTitle("客户端");
		this.setBounds(300, 200, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
		bindListener();
		runClient();
	}
	/**
	 * 运行客户端
	 */
	private void runClient(){
		thread = new ServerListenerThread();
		thread.start();
	}
	/**
	 * 监听服务器的线程
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
					txtMsg.append("客户端已启动\n");
					btnSend.setEnabled(true);
					//获取客户端连接的远程服务器的地址对象
					InetSocketAddress address = (InetSocketAddress)client.getRemoteSocketAddress();
					serverName = address.getHostName();
					//获取输出流
					output = new DataOutputStream(client.getOutputStream());
					//获取输入流
					input = new DataInputStream(client.getInputStream());
					//创建并开启监听服务器发送信息的线程
					msgThread = new ServerMessageListenerThread();
					msgThread.start();
					//客户端启动后关闭线程
					this.stop();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					txtMsg.append("连接超时，3秒后将重新连接服务器\n");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			txtMsg.append("服务器连接失败！\n");
		}
	}
	/**
	 * 监听服务器发送信息的线程
	 * @author Administrator
	 *
	 */
	private class ServerMessageListenerThread extends Thread{
		public void run(){
			//反复读取客户端的信息内容
			while(true){
				try {
					String msg = input.readUTF();
					//呈现信息
					txtMsg.append(serverName+" 说："+msg+"\n");
					//延迟
					Thread.sleep(500);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					txtMsg.append(serverName+" 已断开了连接");
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
			//获取文本框的输入内容
			String msg = txtSend.getText().trim();
			if(msg.equals("")){
				JOptionPane.showMessageDialog(null, "请输入内容！");
				return;
			}
			try {
				txtMsg.append("我说："+msg+"\n");
				//使用输出流写入发送信息至socket客户端中
				output.writeUTF(msg);
				//清空缓冲流
				output.flush();
				//清空文本框信息
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
	 *  初始化组件
	 */
	private void initComponent(){
		//创建滚动面板
		scrollPnl = new JScrollPane();
		//创建面板
		pnl = new JPanel();
		//创建分割面板
		spnl = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPnl, pnl);
		spnl.setDividerLocation(220);
		spnl.setDividerSize(2);
		this.add(spnl);
		//创建文本域
		txtMsg = new JTextArea();
		txtMsg.setEditable(false);
		//添加文本域至滚动面板
		scrollPnl.getViewport().add(txtMsg);
		//创建发送文本框
		txtSend = new JTextField();
		txtSend.setColumns(20);
		//创建按钮
		btnSend = new JButton("send");
		btnSend.setEnabled(false);
		pnl.setLayout(new FlowLayout());
		//添加至面板
		pnl.add(txtSend);
		pnl.add(btnSend);
		
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		ClientChatFrame frm = new ClientChatFrame();
	}
}
