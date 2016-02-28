package com.niit;

public class Exam3 {

	/**
	 * ��д�������ж������������Ƿ����ĳһ��Ԫ�� 
	 */
	public int hasNumber(int[] array, int num){
		//���������е�Ԫ��
		for(int i = 0; i < array.length; i++){
			//�ж�ÿ��Ԫ���Ƿ��Ҫ�Ƚϵ�num��ͬ
			if(array[i] == num){
				return i;
			}
		}
		return -1;
	}
	/**
	 * ��ָ����˳�����������в�������
	 * @param array
	 * @param num
	 * @return
	 */
	public int[] insert(int[] array, int num){
		//��ȡҪ�����������������е�����λ��
		int index = -1;
		for(int i = 0; i < array.length; i++){
			//���Ԫ�ص�ֵ��Ҫ�����ֵ�����¼����
			if(array[i] > num){
				index = i;
				break;
			}
		}
		//����������һ��Ԫ�ؿ�ʼ���κ�ǰһ��Ԫ�ص�ֵ���н���
		for(int i = array.length-1; i > index; i--){
			//��ǰԪ�ؽ���ǰһ��Ԫ��
			array[i] = array[i-1];
		}
		//��Ҫ�����ֵ��������Ӧ������
		array[index] = num;
		return array;
	}
	/**
	 * ɾ��ָ����Ԫ��
	 * @param array
	 * @param num
	 * @return
	 */
	public int[] delete(int[] array, int num){
		//�ж�Ҫɾ�������Ƿ����
		int index = hasNumber(array, num);
		//������ڸ���
		if(index != -1){
			//��ɾ�������±꿪ʼѭ��������һλ��
			for(int i = index; i < array.length-1; i++){
				//��ǰԪ�ؽ�����һλԪ��
				array[i] = array[i+1];
			}
		}
		return array;
	}
	
	public void showArray(int[] array, int length){
		for(int i = 0; i < length; i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam3 ex = new Exam3();
//		int[] array = new int[]{56,73,45};
//		if(ex.hasNumber(array, 56)){
//			System.out.println("��������");
//		}
//		else{
//			System.out.println("Ҫ���������ݲ�����");
//		}
		int[] array = new int[]{10,20,30,40,50,60};
		//����
		//ex.insert(array, 65);
		//ɾ��
		ex.delete(array, 30);
		ex.showArray(array, array.length-1);

	}

}
