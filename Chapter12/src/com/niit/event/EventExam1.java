package com.niit.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class EventExam1 extends JFrame {

	public EventExam1(){
		System.out.println(this.hashCode());
		this.setBounds(200, 200, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//绑定监听器的方法，被绑定监听器的对象称为事件源
		//该方法的参数即为监听器对象，监听器接口中会有各式各样的方法，这写方法称为事件动作，
		//事件动作表示监听所监听的动作，一旦事件源执行了事件动作则会触发该方法中的代码
		this.addMouseMotionListener(new MouseMotionListener() {	
			/**
			 * 鼠标移动事件
			 * 参数表示事件对象参数，事件参数封装了事件源对象，包括和当前事件有关的所有信息
			 */
			@Override
			public void mouseMoved(MouseEvent e) {
				//在事件中可以获取事件源对象
				Object obj = e.getSource();
				//将事件源对象拆箱成具体的对象
				EventExam1 frm = (EventExam1)obj;
				System.out.println(frm.hashCode());
				
				EventExam1.this.setTitle(e.getX()+","+e.getY());
			}
			/**
			 *  鼠标拖拽事件
			 */
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
			
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventExam1 frm = new EventExam1();
		frm.setVisible(true);
	}

}
