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
		btnBack = new JButton("上一张");
		btnAutoPlay = new JButton("自动播放");
		btnNext = new JButton("下一张");
		
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
		
		//实例化线程
		timeThread = new TimeThread();
		
		this.add(lblPhoto);
		this.add(btnBack);
		this.add(btnAutoPlay);
		this.add(btnNext);
	}
	
	
	
	/**
	 * 绑定监听器
	 */
	private void bindListener(){
		ButtonListener btnListener = new ButtonListener();
		btnBack.addActionListener(btnListener);
		btnAutoPlay.addActionListener(btnListener);
		btnNext.addActionListener(btnListener);
	}
	/**
	 * 按钮监听器
	 * @author Administrator
	 *
	 */
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			JButton btn = (JButton)e.getSource();
			//上一张
			if(btn == btnBack){
				timeThread.stop();
				timeThread = null;
				timeThread = new TimeThread();
				btnAutoPlay.setText("自动播放");
				aotoState = false;
				//取消下一张按钮的灰化
				btnNext.setEnabled(true);
				//获取相册当前显示照片是第几张照片
				int index = photoIndex();
				//如果当前照片不是第一张就显示前面一张
				if(index > 0){
					lblPhoto.setIcon(photos[index-1]);
				}
				//否则上一张按钮灰化
				else{
					btnBack.setEnabled(false);
				}
			}
			//自动播放
			if(btn == btnAutoPlay){
				//自动播放
				if(aotoState == false){
					//将自动播放按钮的值改为暂停
					btnAutoPlay.setText("暂停");
					//自动播放状态改为true;
					aotoState = true;
					//启动线程
					if(timeThread.getState() == State.NEW){
						timeThread.start();
					}
					
				}
				else{
					//将自动播放按钮的值改为自动播放
					btnAutoPlay.setText("自动播放");
					//自动播放状态改为false;
					aotoState = false;
					timeThread.stop();
					System.out.println(timeThread.getState());
					timeThread = null;
					timeThread = new TimeThread();
				}
				
			}
			//下一张
			if(btn == btnNext){
				timeThread.stop();
				timeThread = null;
				timeThread = new TimeThread();
				btnAutoPlay.setText("自动播放");
				aotoState = false;
				//取消上一张按钮的灰化
				btnBack.setEnabled(true);
				//获取相册当前显示照片是第几张照片
				int index = photoIndex();
				//如果当前照片不是最后一张就显示后面一张
				if(index < 7){
					lblPhoto.setIcon(photos[index+1]);
				}
				//否则下一张按钮灰化
				else{
					btnNext.setEnabled(false);
				}
			}
		}
		
	}
	
	/**
	 * 获取当前相册的照片索引
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
	 * 控制时间的线程
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
