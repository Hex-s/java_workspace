package com.niit.exam1;
/**
 * ˮԪ�� �����ڲ�ͬ�Ļ������ݱ��ˮ��ˮ�����ͱ�
 * @author Administrator
 *
 */
public class H2O {
	//�¶�
	private int temp;

	/**
	 * ���췽�� 
	 * @param temp �¶�
	 */
	public H2O(int temp){
		this.temp = temp;
	}
	public H2O(){
		
	}
	
	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}
	public void details(){
		System.out.println("����ˮԪ��");
	}
}
