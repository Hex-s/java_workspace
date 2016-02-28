package com.niit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Exam2 extends JFrame {

	private JTextField txtTime;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnSuspend;
	private JButton btnResume;
	private TimeThread timeThread;
	private boolean isStart = true;
	private boolean isResume = true;
	
	public Exam2(){
		this.setBounds(200, 200, 460, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		initComponent();
		bindListener();
	}
	private void initComponent(){
		txtTime = new JTextField();
		txtTime.setBounds( 130, 50, 200, 25);
		
		btnStart = new JButton("start");
		btnStop = new JButton("stop");
		btnSuspend = new JButton("suspend");
		btnResume = new JButton("resume");
		
		btnStart.setBounds(50, 105, 80, 25);
		btnStop.setBounds(150, 105, 80, 25);
		btnSuspend.setBounds(250, 105, 80, 25);
		btnResume.setBounds(350, 105, 80, 25);
	
		//实例化线程
		timeThread = new TimeThread();
		
		this.add(txtTime);
		this.add(btnStart);
		this.add(btnStop);
		this.add(btnSuspend);
		this.add(btnResume);
	}
	/**
	 * 控制时间的线程
	 * @author Administrator
	 *
	 */
	private class TimeThread extends Thread{

		@Override
		public void run() {
			//while(isStart){
			//如果通过interrupt方法打断线程则需要通过下述代码来判断是否打断了线程
			while(!this.isInterrupted()){
				//通过标识来控制是否暂停
				if(isResume){
					//获取当前的系统时间
					Date date = new Date();
					//将时间显示在文本款内
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					String time = format.format(date);
					txtTime.setText(time);
					//间隔1秒
					try {
						//sleep方法表示当前线程暂停若干毫秒值，线程进入阻塞状态，当指定的时间过去后线程将会自动恢复
						//该方法是静态方法，该方法不能在线程外部，通过线程对象来调用
						//该方法只能在线程内部进行调用
						//sleep方法会锁住当前线程占用的对象，其他线程无法将访问处于sleep阻塞线程中的数据内容
						//任何试图将处于sleep状态的线程打断或唤醒都将导致异常
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						this.interrupt();
					}
				}
				
			}
			
		}
		
	}
	private void bindListener(){
		ButtonListener btnListener = new ButtonListener();
		btnStart.addActionListener(btnListener);
		btnStop.addActionListener(btnListener);
		btnSuspend.addActionListener(btnListener);
		btnResume.addActionListener(btnListener);
	}
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//判断按钮
			Object obj = e.getSource();
			//开启
			if(obj == btnStart){
				//判断线程的状态
				if(timeThread.getState() == State.NEW){
					//修改标识
					isStart = true;
					timeThread.start();
				}
				
			}
			//结束
			else if(obj == btnStop){
				//结束当前线程
				//stop在多线程并发访问数据时会造成数据的紊乱
				//主要原因在于stop关闭线程时会将该线程的对象数据提前释放，导致访问该线程数据的其他线程提前获取，得到不正确的数据
				//如果是单线程程序或者是不会形成数据并发访问的多线程程序，那么stop方法和suspend方法使用都没有问题
//				timeThread.stop();
//				timeThread = null;
//				timeThread = new TimeThread();
				
				//使用标识来控制线程的开关
//				isStart = false;
//				timeThread = null;
//				timeThread = new TimeThread();
				
				//通过打断方法终止线程的执行
				timeThread.interrupt();
			}
			//暂停
			else if(obj == btnSuspend){
				//暂停线程（挂起线程），使线程进入阻塞状态
				//suspend在多线程并发访问数据时会造成线程的死锁
				//主要原因在于suspend阻塞线程时并没有释放对象锁，导致其他线程始终获取不到该线程中需要访问的数据
				//timeThread.suspend();
				
				//使用标识来控制
				isResume = false;
				
			}
			//恢复暂停
			else{
				//只能对使用suspend方法暂停的线程使用
				//timeThread.resume();
				
				//isResume = true;
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam2 frm = new Exam2();
		frm.setVisible(true);

	}

}
