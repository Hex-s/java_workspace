package com.niit;
/**
 * 多个线程中需要被同步锁定的对象
 * @author Administrator
 *
 */
public class LockObj {
	private int count = 100;
	//标识线程将要打印的字母
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
