package com.niit.onetomany;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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


/**
 * 服务器聊天界面
 * @author Administrator
 *
 */
public class ServerChatFrame extends JFrame {
	private JSplitPane spnl;
	private JScrollPane scrollPnl;
	private JTextArea txtMsg;
	private JPanel pnl;
	private JTextField txtSend;
	private JButton btnSend;
	//服务端
	private ServerSocket server;
	//客户端
	private Socket client;
	private ClientMessageListenerThread thread;
	//客户端输入流
	private DataInputStream input;
	//客户端输出流
	private DataOutputStream output;
	private String clientName;
	
	public ServerChatFrame(){
		this.setTitle("服务器");
		this.setBounds(300, 200, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
		bindListener();
		runServer();
	}
	/**
	 * 运行服务器
	 */
	private void runServer(){
		try {
			//创建服务器
			server = new ServerSocket(9090);
			txtMsg.append("服务器已启动\n");
			//创建并开启反复监听客户端连接的线程用来监听客户端
			ServerAccpetListener mainThread = new ServerAccpetListener();
			mainThread.start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 服务器监听客户端连接的线程
	 * @author Administrator
	 *
	 */
	@SuppressWarnings("unused")
	private class ServerAccpetListener extends Thread{
		public void run(){
			//在线程中反复监听是否有客户端连接服务器
			while(true){
				try {
					//监听客户端连接
					client = server.accept();
					//获取客户端的名称
					clientName = client.getInetAddress().getHostName();
					txtMsg.append(clientName+" 已连接服务器\n");
					//创建并开启监听客户端信息的线程
					ClientMessageListenerThread clientThread = new ClientMessageListenerThread(client, txtMsg);
					clientThread.start();
				} catch (IOException e) {
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
		pnl.setLayout(new FlowLayout());
		//添加至面板
		pnl.add(txtSend);
		pnl.add(btnSend);
		
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		ServerChatFrame frm = new ServerChatFrame();
	}
}
