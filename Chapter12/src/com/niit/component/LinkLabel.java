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
 * 自定义超链接标签
 * @author Administrator
 *
 */
public class LinkLabel extends JLabel{
	//跳转的URL路径
	private String url;
	/**
	 * 构造传入超链接显示内容和链接跳转地址
	 * @param labelName
	 * @param url
	 */
	public LinkLabel(String labelName, String url){
		super("<html><a href='#'>"+labelName+"</a>");
		this.url = url;
		//设置鼠标移动至标签的样式
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//直接绑定监听器
		this.addMouseListener(new Listener());
		
	}
	private class Listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			//获取桌面对象
			Desktop desktop = Desktop.getDesktop();
			//打开浏览器
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
