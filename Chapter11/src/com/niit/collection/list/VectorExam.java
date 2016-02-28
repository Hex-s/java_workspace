package com.niit.collection.list;

import java.util.Vector;

public class VectorExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Vector称为向量，是早期的动态数组集合，现已被ArrayList所替代，使用方式和ArrayList完全相同，
		//区别在于Vector是线程安全的集合，ArrayList是非线程安全的集合
		
		Vector<String> list = new Vector<String>();
		list.add("a");
		list.add("b");
	}

}
