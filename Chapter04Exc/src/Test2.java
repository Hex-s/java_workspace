
public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//��ӡ5��5��*���ɵ�ͼ��
		
		//����ѭ����ӡ������
//		for(int j = 1; j <= 5; j++){
//			//�ظ���ÿһ���У�����һ��
//			for(int i = 1; i <= 5; i++){
//				System.out.print("*");
//			}
//			//����
//			System.out.println();
//		}
		
		//*
		//**
		//***
		//****
		//*****
		//���ѭ����������
//		for(int i = 1; i <= 5; i++){
//			//���ѭ������
//			for(int j = 1; j <= i; j++){
//				System.out.print("*");
//			}
//			//����
//			System.out.println();
//		}
		
		//1*1=1
		//2*1=2 2*2=4
		//3*1=3 3*2=6 3*3=9
		//....................
//		for(int i = 1; i <= 9; i++){
//			for(int j = 1; j <= i; j++){
//				System.out.print(i+"*"+j+"="+i*j+"\t");
//			}
//			System.out.println();
//		}
		
		//*****
		//#*****
		//##*****
		//###*****
		//####*****
		//��������
//		for(int i = 1; i <= 5; i++){
//			//ÿһ��
//			//���ƴ�ӡ�Ŀո�
//			for(int j = 1; j < i; j++){
//				System.out.print(" ");
//			}
//			//���ƴ�ӡ��*
//			for(int k = 1; k <= 5; k++){
//				System.out.print("*");
//			}
//			//����
//			System.out.println();
//		}
		
		//*****
		//****
		//***
		//**
		//*
//		for(int i = 1; i <= 5; i++){
//			for(int j = 5; j >= i; j--){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for(int i = 5; i >=1; i--){
//			for(int j = 1; j <= i; j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		for(int i = 1; i <= 5; i++){
//			for(int j = 0; j <= 5-i; j++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//    *
		//   ***
		//  *****
		// *******
		//*********
//		for(int i = 1; i <= 5; i++){
//			//���ƴ�ӡ�Ŀո�
//			for(int j = 1; j <= 5-i; j++){
//				System.out.print(" ");
//			}
//			//���ƴ�ӡ��*
//			for(int k = 1; k <= 2*i-1; k++){
//				System.out.print("*");
//			}
//			//����
//			System.out.println();
//		}
		
		//	  *
		//   ***
		//  *****
		// *******
		//*********
		// *******
		//  *****
		//   ***
		//    *
		//��ӡ�ϰ벿��
//		for(int i = 1; i <= 5; i++){
//			//���ƴ�ӡ�Ŀո�
//			for(int j = 1; j <= 5-i; j++){
//				System.out.print(" ");
//			}
//			//���ƴ�ӡ��*
//			for(int k = 1; k <= 2*i-1; k++){
//				System.out.print("*");
//			}
//			//����
//			System.out.println();
//		}
//		//��ӡ�°벿��
//		for(int i = 1; i <= 4; i++){
//			for(int j = 1; j <= i; j++){
//				System.out.print(" ");
//			}
//			for(int k = 1; k <= 9-2*i; k++){
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		//���̽������ε��������ж����������������������������룩����ӡһ�����ĵ�����
//		for(int i = 1; i <= 5; i++){
//			//�ж���β������
//			if(i == 1 || i == 5){
//				System.out.print("*");
//			}
//			else{
//				System.out.print(" ");
//			}
//		}
//		for(int i = 1; i <= 5; i++){
//			//���ƴ�ӡ�Ŀո�
//			for(int j = 1; j <= 5-i; j++){
//				System.out.print(" ");
//			}
//			//���ƴ�ӡ��*
//			for(int k = 1; k <= 2*i-1; k++){
//				//�ж�*����βλ��
//				if(k == 1 || k == 2*i-1){
//					System.out.print("*");
//				}
//				else{
//					System.out.print(" ");
//				}
//			}
//			//����
//			System.out.println();
//		}
//		//��ӡ�°벿��
//		for(int i = 1; i <= 4; i++){
//			for(int j = 1; j <= i; j++){
//				System.out.print(" ");
//			}
//			for(int k = 1; k <= 9-2*i; k++){
//				if(k == 1 || k == 9-2*i){
//					System.out.print("*");
//				}
//				else{
//					System.out.print(" ");
//				}
//			}
//			System.out.println();
//		}
		
		//��ӡ��ʾ1-100�ڵ���������
		//˼·��
		//3 3%2!=0 
		//5 5%2 5%3 5%4
		//6 6%2
		//7 7%2 7%3 7%4 7%5 7%6
		//��ʾ�Ƿ������� Ĭ��������
//		boolean flag = true;
//		for(int i = 2; i <= 100; i++){
//			flag = true;
//			for(int j = 2; j < i; j++){
//				//mod�������ж��Ƿ����
//				if(i%j == 0){
//					//�޸ı�ʾ
//					flag = false;
//					break;
//				}
//			}
//			//�����ʾΪtrue����������
//			if(flag){
//				System.out.println(i);
//			}
//		}
		
		
	}

}
