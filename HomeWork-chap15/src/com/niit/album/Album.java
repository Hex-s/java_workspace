package com.niit.album;

import java.awt.Color;
import java.awt.dnd.Autoscroll;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class Album extends JFrame{
	
	private JLabel lblPhoto;
	private JButton btnBack;
	private JButton btnAutoPlay;
	private JButton btnNext;
	private ImageIcon[] photos;
	private boolean aotoState = false;
	private TimeThread timeThread;
	private int i = 0;
	
	public Album(){
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		initComponent();
		bindListener();
	}

	private void initComponent(){

		lblPhoto = new JLabel();
		btnBack = new JButton("��һ��");
		btnAutoPlay = new JButton("�Զ�����");
		btnNext = new JButton("��һ��");
		
		lblPhoto.setBounds(150, 10, 81, 100);
		lblPhoto.setBorder(BorderFactory.createLineBorder(Color.red));
		btnBack.setBounds(25, 150, 100, 30);
		btnAutoPlay.setBounds(150, 150, 100, 30);
		btnNext.setBounds(275, 150, 100, 30);
		
		photos = new ImageIcon[8];
		photos[0] = new ImageIcon("image/ya1.gif");
		photos[1] = new ImageIcon("image/ya2.gif");
		photos[2] = new ImageIcon("image/ya3.gif");
		photos[3] = new ImageIcon("image/ya4.gif");
		photos[4] = new ImageIcon("image/ya5.gif");
		photos[5] = new ImageIcon("image/ya6.gif");
		photos[6] = new ImageIcon("image/ya7.gif");
		photos[7] = new ImageIcon("image/ya8.gif");
		
		lblPhoto.setIcon(photos[0]);
		btnBack.setEnabled(false);
		
		//ʵ�����߳�
		timeThread = new TimeThread();
		
		this.add(lblPhoto);
		this.add(btnBack);
		this.add(btnAutoPlay);
		this.add(btnNext);
	}
	
	
	
	/**
	 * �󶨼�����
	 */
	private void bindListener(){
		ButtonListener btnListener = new ButtonListener();
		btnBack.addActionListener(btnListener);
		btnAutoPlay.addActionListener(btnListener);
		btnNext.addActionListener(btnListener);
	}
	/**
	 * ��ť������
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			JButton btn = (JButton)e.getSource();
			//��һ��
			if(btn == btnBack){
				timeThread.stop();
				timeThread = null;
				timeThread = new TimeThread();
				btnAutoPlay.setText("�Զ�����");
				aotoState = false;
				//ȡ����һ�Ű�ť�Ļһ�
				btnNext.setEnabled(true);
				//��ȡ��ᵱǰ��ʾ��Ƭ�ǵڼ�����Ƭ
				int index = photoIndex();
				//�����ǰ��Ƭ���ǵ�һ�ž���ʾǰ��һ��
				if(index > 0){
					lblPhoto.setIcon(photos[index-1]);
				}
				//������һ�Ű�ť�һ�
				else{
					btnBack.setEnabled(false);
				}
			}
			//�Զ�����
			if(btn == btnAutoPlay){
				//�Զ�����
				if(aotoState == false){
					//���Զ����Ű�ť��ֵ��Ϊ��ͣ
					btnAutoPlay.setText("��ͣ");
					//�Զ�����״̬��Ϊtrue;
					aotoState = true;
					//�����߳�
					if(timeThread.getState() == State.NEW){
						timeThread.start();
					}
					
				}
				else{
					//���Զ����Ű�ť��ֵ��Ϊ�Զ�����
					btnAutoPlay.setText("�Զ�����");
					//�Զ�����״̬��Ϊfalse;
					aotoState = false;
					timeThread.stop();
					System.out.println(timeThread.getState());
					timeThread = null;
					timeThread = new TimeThread();
				}
				
			}
			//��һ��
			if(btn == btnNext){
				timeThread.stop();
				timeThread = null;
				timeThread = new TimeThread();
				btnAutoPlay.setText("�Զ�����");
				aotoState = false;
				//ȡ����һ�Ű�ť�Ļһ�
				btnBack.setEnabled(true);
				//��ȡ��ᵱǰ��ʾ��Ƭ�ǵڼ�����Ƭ
				int index = photoIndex();
				//�����ǰ��Ƭ�������һ�ž���ʾ����һ��
				if(index < 7){
					lblPhoto.setIcon(photos[index+1]);
				}
				//������һ�Ű�ť�һ�
				else{
					btnNext.setEnabled(false);
				}
			}
		}
		
	}
	
	/**
	 * ��ȡ��ǰ������Ƭ����
	 * @return
	 */
	private int photoIndex(){
		int index = -1;
		Icon icon = lblPhoto.getIcon();
		for(int i = 0; i < photos.length; i++){
			if(icon.equals(photos[i])){
				index = i;
				break;
			}
		}
		return index;
	}
	/**
	 * ����ʱ����߳�
	 * @author Administrator
	 *
	 */
	public class TimeThread extends Thread{
		
		@Override
		public void run() {
			
			synchronized (lblPhoto) {
				while(!this.isInterrupted()){
					if(aotoState){
						i = photoIndex();
						i++;
						i %= 8;
						lblPhoto.setIcon(photos[i]);				
						try {
							sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					
					
					}
				}
			}
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Album frm = new Album();
		frm.setVisible(true);

	}

}
