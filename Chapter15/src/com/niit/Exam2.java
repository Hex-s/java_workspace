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
	
		//ʵ�����߳�
		timeThread = new TimeThread();
		
		this.add(txtTime);
		this.add(btnStart);
		this.add(btnStop);
		this.add(btnSuspend);
		this.add(btnResume);
	}
	/**
	 * ����ʱ����߳�
	 * @author Administrator
	 *
	 */
	private class TimeThread extends Thread{

		@Override
		public void run() {
			//while(isStart){
			//���ͨ��interrupt��������߳�����Ҫͨ�������������ж��Ƿ������߳�
			while(!this.isInterrupted()){
				//ͨ����ʶ�������Ƿ���ͣ
				if(isResume){
					//��ȡ��ǰ��ϵͳʱ��
					Date date = new Date();
					//��ʱ����ʾ���ı�����
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					String time = format.format(date);
					txtTime.setText(time);
					//���1��
					try {
						//sleep������ʾ��ǰ�߳���ͣ���ɺ���ֵ���߳̽�������״̬����ָ����ʱ���ȥ���߳̽����Զ��ָ�
						//�÷����Ǿ�̬�������÷����������߳��ⲿ��ͨ���̶߳���������
						//�÷���ֻ�����߳��ڲ����е���
						//sleep��������ס��ǰ�߳�ռ�õĶ��������߳��޷������ʴ���sleep�����߳��е���������
						//�κ���ͼ������sleep״̬���̴߳�ϻ��Ѷ��������쳣
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
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//�жϰ�ť
			Object obj = e.getSource();
			//����
			if(obj == btnStart){
				//�ж��̵߳�״̬
				if(timeThread.getState() == State.NEW){
					//�޸ı�ʶ
					isStart = true;
					timeThread.start();
				}
				
			}
			//����
			else if(obj == btnStop){
				//������ǰ�߳�
				//stop�ڶ��̲߳�����������ʱ��������ݵ�����
				//��Ҫԭ������stop�ر��߳�ʱ�Ὣ���̵߳Ķ���������ǰ�ͷţ����·��ʸ��߳����ݵ������߳���ǰ��ȡ���õ�����ȷ������
				//����ǵ��̳߳�������ǲ����γ����ݲ������ʵĶ��̳߳�����ôstop������suspend����ʹ�ö�û������
//				timeThread.stop();
//				timeThread = null;
//				timeThread = new TimeThread();
				
				//ʹ�ñ�ʶ�������̵߳Ŀ���
//				isStart = false;
//				timeThread = null;
//				timeThread = new TimeThread();
				
				//ͨ����Ϸ�����ֹ�̵߳�ִ��
				timeThread.interrupt();
			}
			//��ͣ
			else if(obj == btnSuspend){
				//��ͣ�̣߳������̣߳���ʹ�߳̽�������״̬
				//suspend�ڶ��̲߳�����������ʱ������̵߳�����
				//��Ҫԭ������suspend�����߳�ʱ��û���ͷŶ����������������߳�ʼ�ջ�ȡ�������߳�����Ҫ���ʵ�����
				//timeThread.suspend();
				
				//ʹ�ñ�ʶ������
				isResume = false;
				
			}
			//�ָ���ͣ
			else{
				//ֻ�ܶ�ʹ��suspend������ͣ���߳�ʹ��
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
