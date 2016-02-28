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
		//����������
		btnPress.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��갴���ɿ�");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��갴��");
				
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("����뿪������");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("������������");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����");
				//�ж��Ƿ������˫��
				if(e.getClickCount() == 2){
					System.out.println("������˫������");
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
