import java.util.Scanner;

public class HomeWork6 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// ����˵���
		System.out.println("/*************�齱ϵͳ****************/");
		System.out.println();
		System.out.println("\t1. ��½");
		System.out.println("\t2. ע��");
		System.out.println("\t3. �˳�");
		System.out.print("\t��ѡ��");

		// ����ѡ����
		Scanner sc = new Scanner(System.in);
		int choice1 = sc.nextInt();

		if (choice1 == 1) {
			// ģ���½����
			// �����û���
			System.out.print("�������û�����");
			String name = sc.next();
			// ��������
			System.out.print("���������룺");
			String password = sc.next();
			// ȷ������
			System.out.print("���ٴ��������룺");
			String confirmPassword = sc.next();
			// ������֤�� 1000-9999
			int securityCode = (int) (Math.random() * 9000) + 1000;
			System.out.print("��������֤�루" + securityCode + "����");
			int securityCodeInput = sc.nextInt();

			// ȷ���������������һ����
			if (password.equals(confirmPassword)) {
				// ����һ�£���֤��������ȷ��ע��ɹ�
				if (securityCodeInput == securityCode) {
					System.out.println("ע��ɹ���");
					// ���˵�
					System.out.println();
					System.out.println(">>���˵�");
					System.out.println("\t1. ���˳齱");
					System.out.println("\t2. �������");
					System.out.println("\t3. �˳�ϵͳ");
					System.out.print("\t��ѡ��");
					// �������˵�ѡ����
					int choice2 = sc.nextInt();
					if (choice2 == 1) {

						// ��������
						int luckyNum = (int) (Math.random() * 10);
						// �����˺�
						System.out.print("�����������˺ţ�");
						int account = sc.nextInt();
						// ��ȡ�˺ŵİ�λ��
						int accountHun = account / 100 % 10;
						// �Ƚ��˺Ű�λ��������������
						if (luckyNum == accountHun) {
							System.out.println("��ϲ�����н��ˣ����MP3һ����");
						} else {
							System.out.println("���ź�����û���н���");
						}
					} else {
						System.out.println("���Ѿ��˳�ϵͳ");
					}
				} else {
					System.out.println("��֤���������");
				}
			} else {
				System.out.println("���벻һ�£�������ע�ᣡ");
			}
		} else {
			System.out.println("���Ѿ��˳�ϵͳ");
		}
	}

}
