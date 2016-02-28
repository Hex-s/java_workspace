package com.niit.event;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MouseListenerExam extends JFrame {

	private JButton btnPress;
	
	public MouseListenerExam(){
		this.setBounds(200, 200, 400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		btnPress = new JButton("press");
		this.add(btnPress);
		//绑定鼠标监听器
		btnPress.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标按键松开");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标按下");
				
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("鼠标离开了区域");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("鼠标进入了区域");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标点击");
				//判断是否进行了双击
				if(e.getClickCount() == 2){
					System.out.println("进行了双击动作");
				}
			}
		});
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseListenerExam frm = new MouseListenerExam();
		frm.setVisible(true);

	}

}
