import java.util.Scanner;


public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*******1 2,2 3,3 5,5 8,8 13.......��12�����ݷֱ��Ƕ���******/
//		int a = 1;
//		int b = 2;
//		int c;
//		int d;
//		for(int i = 1; i < 12; i++){
//			//��ʱ����a��ֵ
////			c = a;
////			a = b;
////			b = c+b;
//			
//			//��ʱ����b��ֵ
//			c = b;
//			b = a+c;
//			a = c; 
//		}
		//System.out.println(a+":"+b);
		
		
		/**ͨ����������2�����������һ����Ϊ2���ڶ�������4
		���ռ���2+22+222+2222=?
		�����һ������3,�ڶ�������5
		���ռ���3+33+333+3333+33333=?*/
		
		//0*10+2
		//2*10+2
		//22*10+2
		//222*10+2
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ����λ����ʾ��ʼֵ");
		int a = sc.nextInt();
		System.out.println("��������һ����λ����ʾ�ۼӵĴ���");
		int n = sc.nextInt();
		//��ʱ����������������һ������Ľ��
		int temp = 0;
		//����ĺ�
		int sum = 0;
		//�����ۼ�
//		for(int i = 1; i <= n; i++){
//			temp+=a;
//			//�����
//			sum+=temp;
//			//ÿ������10��
//			temp = temp*10;
//		}
		
		
		//��һ��˼·
		//0+2
		//2*10+2
		//2*100+22
		//2*1000+222
		for(int i = 1; i <= n; i++){
			temp+=a;
			//�ۼӺ�
			sum+=temp;
			//a����10��
			a = a*10;
		}
		System.out.println(sum);
	}

}
