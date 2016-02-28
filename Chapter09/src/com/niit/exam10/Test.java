package com.niit.exam10;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//建造一个学校
		School school = new School();
		//获取彩色打印机
		ColorPrinter colorPrinter = new ColorPrinter();
		//获取黑白打印机
		BlackPrinter blackPrinter = new BlackPrinter();
		//为学校配备一台黑白打印机
		//school.setPrinter(blackPrinter);
		//学校配备彩色打印机
		school.setPrinter(colorPrinter);
		//创建一个老师
		Teacher teacher = new Teacher();
		//创建一份试卷
		Paper paper = new Paper();
		//老师使用学校配备的打印机打印试卷信息
		//teacher.usePrinter(school.getPrinter(), paper);
		//创建一个学生
		Student stu = new Student();
		//学生打印自己的个人信息
		stu.usePrinter(school.getPrinter(), stu);
	}

}
