import java.util.Scanner;


/**
 * ��������
 * @author Administrator
 *
 */
public class Calculator {
	//�����е�ĳ��������Ҫ�ڶ���������ܷ���
	//�������Ӧ��Ϊ�������
//	double num1;
//	double num2;
	
	/**
	 * ����ķ���
	 * @return
	 */
	public double calculate(){
		//������
		double result = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("�������һ������");
		double num1 = sc.nextDouble();
		System.out.println("������ڶ�������");
		double num2 = sc.nextDouble();
		System.out.println("�������������1.+ 2.- 3.* 4./");
		int opt = sc.nextInt();
		
		//�ж������
		switch(opt){
		case 1:
			result = addition(num1,num2);
			break;
		case 2:
			result = substraction(num1,num2);
			break;
		case 3:
			result = multiplication(num1,num2);
			break;
		case 4:
			result = divition(num1,num2);
			break;
		default:
			System.out.println("��Ч���������");
			break;
		}
		return result;
	}
	/**
	 * �ӷ�����
	 * @return
	 */
	public double addition(double num1, double num2){
		
		double result = num1+num2;
		return result;
	}
	/**
	 * ����
	 * @return
	 */
	public double substraction(double num1, double num2){
		double result = num1-num2;
		return result;
	}
	/**
	 * �˷�
	 * @return
	 */
	public double multiplication(double num1, double num2){
		double result = num1*num2;
		return result;
	}
	/**
	 * ����
	 * @return
	 */
	public double divition(double num1, double num2){
		double result = num1/num2;
		return result;
	}
}
