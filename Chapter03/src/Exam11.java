import java.util.Scanner;


public class Exam11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("-------------ϵͳ�˵�-------------");
		System.out.println("1. ��½");
		System.out.println("2. ע��");
		System.out.println("3. �˳�");
		System.out.println("��ѡ��");
		Scanner sc = new Scanner(System.in);
		int chooice = sc.nextInt();
		//�ж�ѡ��
//		if(chooice == 1){
//			System.out.println("ѡ���˵�½");
//		}
//		else if(chooice == 2){
//			System.out.println("ѡ����ע��");
//		}
//		else{
//			System.out.println("ѡ�����˳�");
//		}

		int n = 1;
		//ʹ��switch����д
		switch(chooice){
		//case��ֻ��д��ֵ
		case 1:
			//��������ִ�еĴ���
			System.out.println("��½");
			//������ǰ��switch�ṹ
			break;
		//ÿһ��case��ֵ�����ظ�
		case 2:
			System.out.println("ע��");
			break;
		case 3:
			System.out.println("�˳�");
			break;
		//default��ʾû���������е�case�������൱��if�����е�else
		default:
			System.out.println("������Ч��");
			break;
		}
	}

}
