package com.niit.component;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JLabel;

/**
 * �Զ��峬���ӱ�ǩ
 * @author Administrator
 *
 */
public class LinkLabel extends JLabel{
	//��ת��URL·��
	private String url;
	/**
	 * ���촫�볬������ʾ���ݺ�������ת��ַ
	 * @param labelName
	 * @param url
	 */
	public LinkLabel(String labelName, String url){
		super("<html><a href='#'>"+labelName+"</a>");
		this.url = url;
		//��������ƶ�����ǩ����ʽ
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//ֱ�Ӱ󶨼�����
		this.addMouseListener(new Listener());
		
	}
	private class Listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//��ȡ�������
			Desktop desktop = Desktop.getDesktop();
			//�������
			try {
				desktop.browse(new URI(url));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
}
