package com.niit.exam1;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//ʵ������������
//		Water water = new Water();
//		Ice ice = new Ice();
//		Vapour vapour = new Vapour();
		
		//��̬�ԣ������ø�����������ʵ��
		//H2O������ˮ
//		H2O h1 = water;
//		//H2O�����Ǳ�
//		H2O h2 = ice;
//		//H2O������ˮ����
//		H2O h3 = vapour;
		
		//��̬�Կ���ʹԭ����һ�����������ڲ�ͬ���������Ÿ�ǿ�Ļ�����Ӧ��
		//ʵ����ˮԪ��
		H2O h2o = new H2O(-170);
		//ˮԪ�ظ��ݻ����ı�������
		H2O newH2o;
		//�ж�ˮԪ�ص��¶�
		//����¶ȵ���0�ȣ�ˮԪ�ؽ����ɱ�
		if(h2o.getTemp() < 0){
			newH2o = new Ice();
		}
		//����¶ȸ���100�ȣ�ˮԪ�ػ���ˮ����
		else if(h2o.getTemp() > 100){
			newH2o = new Vapour();
		}
		//����������ڳ�����ˮԪ�ػ���Һ̬��ˮ
		else{
			newH2o = new Water();
		}
		//ˮԪ�ظ��ݻ��������ĸı�
		h2o = newH2o;
		//������ǰ��ˮԪ��
		//��Ȼ���ö�̬�ԣ��ø����������ʱ�����õķ��������Զ������������
		h2o.details();
	}

}
