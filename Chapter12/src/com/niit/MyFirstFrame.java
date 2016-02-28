package com.niit;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFirstFrame {

	public static void main(String[] args) {
		
		//��������
		JFrame frame = new JFrame();
		//���ô����Ƿ�ɼ�
		frame.setVisible(true);
		//���ô���ı���
		frame.setTitle("�ҵĵ�һ������");
		//��ȡ����
		System.out.println(frame.getTitle());
		//���ô���Ĵ�С ��λ������
		//frame.setSize(800, 500);
		//Dimension�Ƿ�װ�˿��ֵ�Ķ���
		//frame.setSize(new Dimension(500, 300));
		//��ȡ����Ŀ��
		System.out.println(frame.getWidth()+","+frame.getHeight());
		//����Ĭ�������Ͻ�λ�ó��֣�ͨ��setLocation�������ж�λ
		//frame.setLocation(500, 600);
		//poiont�����װ������ֵ
		frame.setLocation(new Point(300, 200));
		//��ȡ���������
		Point point = frame.getLocation();
		System.out.println(point.getX()+","+point.getY());
		//setBounds�����setSize��setLocation����
		frame.setBounds(400, 150, 400, 400);
		//frame.setBounds(new Rectangle(new Point(400, 200), new Dimension(400, 400)));
		//ʹ�����������ǰ��
		frame.setAlwaysOnTop(true);
		//���ô���ı���ɫǰ��Ҫ��ȡ�������
		//frame.getContentPane().setBackground(Color.yellow);
		//ֱ�����ô�����ɫ�����ɼ�����������帲��
		//frame.setBackground(Color.orange);
		//�����������
		//frame.getContentPane().setVisible(false);
		//���ô����С�Ƿ�ɱ�
		//frame.setResizable(false);
		//�������߰�
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		//��ȡ��Ļ�ĳߴ�
		Dimension screenSize = toolKit.getScreenSize();
		System.out.println(screenSize.getWidth()+"*"+screenSize.getHeight());
		//�ô������
		frame.setLocationRelativeTo(null);
		//���ô����״̬,��������Ϊ���
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//��ȡͼƬ
		//���ڹ��߰���ȡͼƬ
		//Image image = toolKit.getImage("d:/image/edit.gif");
		//����ImageIcon�����ȡͼƬ
		ImageIcon imageIcon = new ImageIcon("d:/image/edit.gif");
		//���ñ���ͼƬ
		frame.setIconImage(imageIcon.getImage());
		//���ô���Ĺرղ���  �ڴ����������������ڶ�������ʱ�����Զ�����
		//����һ���رմ����ͬʱ��������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���Զ����رմ���ʱ�ͷŴ�����Դ
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//���������رմ���ʱʲô������
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
