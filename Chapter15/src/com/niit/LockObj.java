package com.niit;
/**
 * ����߳�����Ҫ��ͬ�������Ķ���
 * @author Administrator
 *
 */
public class LockObj {
	private int count = 100;
	//��ʶ�߳̽�Ҫ��ӡ����ĸ
	private String word = "A";
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
}
