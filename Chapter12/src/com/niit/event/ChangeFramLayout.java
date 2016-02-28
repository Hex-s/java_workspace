package com.niit.event;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangeFramLayout extends JFrame {

	private JLabel lblLeft;
	private JLabel lblRight;
	private JPanel pnlRed;
	private JPanel pnlYellow;
	
	public ChangeFramLayout(){
		this.setBounds(200, 200, 400, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		lblLeft = new JLabel();
		lblLeft.setBounds(50, 20, 100, 50);
		//���ñ߿���
		lblLeft.setBorder(BorderFactory.createLineBorder(Color.red));
		lblRight = new JLabel();
		lblRight.setBounds(250, 20, 100, 50);
		//���ñ߿���
		lblRight.setBorder(BorderFactory.createLineBorder(Color.yellow));
		
		pnlRed = new JPanel();
		pnlRed.setBackground(Color.red);
		pnlRed.setBounds(50, 100, 250, 250);
		
		pnlYellow = new JPanel();
		pnlYellow.setBackground(Color.yellow);
		pnlYellow.setBounds(50, 100, 400, 100);
		
		//�����������
		pnlRed.setVisible(false);
		pnlYellow.setVisible(false);
		
		//�󶨼�����
		PanelEnteredListener listener = new PanelEnteredListener();
		lblLeft.addMouseListener(listener);
		lblRight.addMouseListener(listener);
		
		this.add(lblLeft);
		this.add(lblRight);
		this.add(pnlRed);
		this.add(pnlYellow);
	}
	
	private class PanelEnteredListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			//��ȡ�¼�Դ����
			JLabel lbl = (JLabel)e.getSource();
			//�жϵ�ǰ����������ĸ��¼�Դ����
			if(lbl == lblLeft){
				//ʹ��ɫ���ɼ�
				pnlRed.setVisible(true);
				//���ػ�ɫ���
				pnlYellow.setVisible(false);
				//��������Ŀ��
				ChangeFramLayout.this.setSize(400, 400);
			}
			else{
				//ʹ��ɫ���ɼ�
				pnlYellow.setVisible(true);
				//��ɫ�������
				pnlRed.setVisible(false);
				//��������Ŀ��
				ChangeFramLayout.this.setSize(500, 300);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChangeFramLayout frm = new ChangeFramLayout();
		frm.setVisible(true);

	}

}
