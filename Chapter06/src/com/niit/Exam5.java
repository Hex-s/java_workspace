package com.niit;

public class Exam5 {

	/**
	 * 根据指定的字符出现的次数，获取该字符所在索引
	 * @param sourceStr 源字符串
	 * @param searchStr 需要搜索的字符串
	 * @param time 出现的次数
	 * @return
	 */
	public int search(String sourceStr, String searchStr, int time){
		int index = 0;
		for(int i = 1; i <= time; i++){
			index = sourceStr.indexOf(searchStr,index);
			index++;
		}
		return index-1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//indexOf方法用来检索参数所在源字符串中的索引位置，索引从0开始
//		String str = "hello niit";
//		//字符串中最后个字符的索引是字符串的长度减1
//		//如果搜索不到字符返回值为-1
//		int index = str.indexOf("z");
//		System.out.println(index);
		
		
		//判断输入的数字是否是带有小数位
//		str = ".10";
//		//获取小数点的位置
//		index = str.indexOf(".");
//		//必须要有小数点
//		if(index == -1){
//			System.out.println("必须要有小数点！");
//			return;
//		}
//		//小数点不能在首尾位置
//		if(index == 0 || index == str.length()-1){
//			System.out.println("小数点不能在首尾");
//			return;
//		}
//		System.out.println("这是一个小数");
		
		
		//indexOf(String,int)的重载方法可以根据指定的索引进行搜索
//		String str = "wellcome";
//		int index = str.indexOf("l",3);
//		System.out.println(index);
		
		String str = "taobao";
		//搜索第二个a和o所在的索引
		//System.out.println(str.indexOf("o",str.indexOf("o")+1));
		
		//lastIndexOf表示搜索最后次字符所在的位置
		//和indexOf的区别在搜索的方向
		System.out.println(str.lastIndexOf("a"));
		
//		Exam5 ex = new Exam5();
//		System.out.println(ex.search("abcabcabca", "a", 5));
		
		
		
	}

}
