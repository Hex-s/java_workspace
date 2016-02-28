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
		
		//创建窗体
		JFrame frame = new JFrame();
		//设置窗体是否可见
		frame.setVisible(true);
		//设置窗体的标题
		frame.setTitle("我的第一个窗体");
		//获取标题
		System.out.println(frame.getTitle());
		//设置窗体的大小 单位是像素
		//frame.setSize(800, 500);
		//Dimension是封装了宽高值的对象
		//frame.setSize(new Dimension(500, 300));
		//获取窗体的宽高
		System.out.println(frame.getWidth()+","+frame.getHeight());
		//窗体默认在左上角位置呈现，通过setLocation方法进行定位
		//frame.setLocation(500, 600);
		//poiont对象封装了坐标值
		frame.setLocation(new Point(300, 200));
		//获取窗体的坐标
		Point point = frame.getLocation();
		System.out.println(point.getX()+","+point.getY());
		//setBounds替代了setSize和setLocation方法
		frame.setBounds(400, 150, 400, 400);
		//frame.setBounds(new Rectangle(new Point(400, 200), new Dimension(400, 400)));
		//使窗体呈现在最前端
		frame.setAlwaysOnTop(true);
		//设置窗体的背景色前先要获取内容面板
		//frame.getContentPane().setBackground(Color.yellow);
		//直接设置窗体颜色将不可见，被内容面板覆盖
		//frame.setBackground(Color.orange);
		//隐藏内容面板
		//frame.getContentPane().setVisible(false);
		//设置窗体大小是否可变
		//frame.setResizable(false);
		//创建工具包
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		//获取屏幕的尺寸
		Dimension screenSize = toolKit.getScreenSize();
		System.out.println(screenSize.getWidth()+"*"+screenSize.getHeight());
		//让窗体居中
		frame.setLocationRelativeTo(null);
		//设置窗体的状态,将窗体设为最大化
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//获取图片
		//基于工具包获取图片
		//Image image = toolKit.getImage("d:/image/edit.gif");
		//基于ImageIcon对象获取图片
		ImageIcon imageIcon = new ImageIcon("d:/image/edit.gif");
		//设置标题图片
		frame.setIconImage(imageIcon.getImage());
		//设置窗体的关闭策略  在窗体程序中如果不存在顶级容器时程序将自动销毁
		//策略一：关闭窗体的同时结束程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//策略二：关闭窗体时释放窗体资源
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//策略三：关闭窗体时什么都不做
		//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
