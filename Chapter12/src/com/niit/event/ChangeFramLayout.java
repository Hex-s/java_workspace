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
		//设置边框线
		lblLeft.setBorder(BorderFactory.createLineBorder(Color.red));
		lblRight = new JLabel();
		lblRight.setBounds(250, 20, 100, 50);
		//设置边框线
		lblRight.setBorder(BorderFactory.createLineBorder(Color.yellow));
		
		pnlRed = new JPanel();
		pnlRed.setBackground(Color.red);
		pnlRed.setBounds(50, 100, 250, 250);
		
		pnlYellow = new JPanel();
		pnlYellow.setBackground(Color.yellow);
		pnlYellow.setBounds(50, 100, 400, 100);
		
		//隐藏所有面板
		pnlRed.setVisible(false);
		pnlYellow.setVisible(false);
		
		//绑定监听器
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
			
			//获取事件源对象
			JLabel lbl = (JLabel)e.getSource();
			//判断当前鼠标进入的是哪个事件源对象
			if(lbl == lblLeft){
				//使红色面板可见
				pnlRed.setVisible(true);
				//隐藏黄色面板
				pnlYellow.setVisible(false);
				//调整窗体的宽高
				ChangeFramLayout.this.setSize(400, 400);
			}
			else{
				//使黄色面板可见
				pnlYellow.setVisible(true);
				//红色面板隐藏
				pnlRed.setVisible(false);
				//调整窗体的宽高
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
