package com.niit;

public class Exam5 {

	/**
	 * ����ָ�����ַ����ֵĴ�������ȡ���ַ���������
	 * @param sourceStr Դ�ַ���
	 * @param searchStr ��Ҫ�������ַ���
	 * @param time ���ֵĴ���
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
		
		//indexOf��������������������Դ�ַ����е�����λ�ã�������0��ʼ
//		String str = "hello niit";
//		//�ַ����������ַ����������ַ����ĳ��ȼ�1
//		//������������ַ�����ֵΪ-1
//		int index = str.indexOf("z");
//		System.out.println(index);
		
		
		//�ж�����������Ƿ��Ǵ���С��λ
//		str = ".10";
//		//��ȡС�����λ��
//		index = str.indexOf(".");
//		//����Ҫ��С����
//		if(index == -1){
//			System.out.println("����Ҫ��С���㣡");
//			return;
//		}
//		//С���㲻������βλ��
//		if(index == 0 || index == str.length()-1){
//			System.out.println("С���㲻������β");
//			return;
//		}
//		System.out.println("����һ��С��");
		
		
		//indexOf(String,int)�����ط������Ը���ָ����������������
//		String str = "wellcome";
//		int index = str.indexOf("l",3);
//		System.out.println(index);
		
		String str = "taobao";
		//�����ڶ���a��o���ڵ�����
		//System.out.println(str.indexOf("o",str.indexOf("o")+1));
		
		//lastIndexOf��ʾ���������ַ����ڵ�λ��
		//��indexOf�������������ķ���
		System.out.println(str.lastIndexOf("a"));
		
//		Exam5 ex = new Exam5();
//		System.out.println(ex.search("abcabcabca", "a", 5));
		
		
		
	}

}
