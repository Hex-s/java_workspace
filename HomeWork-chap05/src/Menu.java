/**
 * �˵���
 * @author Administrator
 *
 */
import java.util.Scanner;

public class Menu {

	// �Ӽ��̽�������
	Scanner sc;
	// ϵͳ����
	Data data;
	// ��֤��
	Code code;
	// ѡ����
	int choice;
	// ��������֤��
	String codeStr;
	// �Ӽ��̽�������
	String name;
	// �Ӽ��̽�������
	String pwd;
	// �Ӽ��̽���ȷ������
	String pwdAffirm;

	/**
	 * ϵͳ��ʼ��
	 */
	public void init() {
		sc = new Scanner(System.in);
		data = new Data();
		code = new Code();
	}

	/**
	 * ��ʼ�������ֿ�ʼ�˵� ��½ ע�� �˳�
	 */
	public void start() {
		System.out.println("---------------����ϵͳ---------------");
		System.out.println("1. ��½");
		System.out.println("2. ע��");
		System.out.println("3. �˳�");
		System.out.print("��ѡ��");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			// ��¼
			login();
			break;
		case 2:
			// ע��
			register();
			break;
		case 3:
			// �˳�
			System.out.println("���Ѿ��˳�ϵͳ����ӭ�ٴ�ʹ�ã�");
			break;
		default:
			// �������
			System.out.println("��Ч�����룬������ѡ��");
			back(1,1);
			break;
		}

	}

	/**
	 * ��¼
	 */
	public void login() {
		// ѡ���½�������û������룬ȷ���������֤��
		System.out.print("�������û�����");
		name = sc.next();
		System.out.print("���������룺");
		pwd = sc.next();
		System.out.print("���ٴ��������룺");
		pwdAffirm = sc.next();
		// ������֤��
		codeStr = code.testCode();
		System.out.print("��������֤��" + codeStr + "��");
		String code = sc.next();

		// ��֤�û���,�������֤�����ȷ��
		if (validate(pwd,pwdAffirm,code)&&validateLogin(name, pwd)) {
			System.out.println("��½�ɹ���");
			mainMenu();
		} else {
			back(1, 2);
		}

	}

	
	/**
	 * ��֤��������������Ƿ�һ�£���֤���Ƿ���ȷ
	 * @param pwd ���������
	 * @param pwdAffirm  ȷ�ϵ�����
	 * @param code �������֤��
	 * @return
	 */
	public boolean validate(String pwd, String pwdAffirm,
			String code) {
		// ��֤��֤�����ȷ��
		if (!code.equals(codeStr)) {
			System.out.println("��֤�����");
			return false;
		}
		if (!pwdAffirm.equals(pwd)) {
			System.out.println("�����������벻һ�£�");
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param name ������û���
	 * @param pwd ���������
	 * @return У��Ľ��
	 */ 
	public boolean validateLogin(String name, String pwd) {

		// ��֤�û�������ȷ��
		if (!name.equals(data.name)) {
			System.out.println("�û�������");
			return false;
		}
		// ��֤�������ȷ��
		if (!pwd.equals(data.pwd)) {
			System.out.println("�������");
			return false;
		}

		return true;
	}

	/**
	 * ���ز˵���ѡ��ķ���
	 * 
	 * @param menuId
	 *            �ϼ��˵��ı�� 1��ʾ���˵� 2��ʾ���˵�����
	 * @param optId
	 *            ��ǰ�����ı�� 1��ʾ���˵���ѡ�� 2��ʾ��¼ 3��ʾע�� 4��ʾ���˵�����
	 */
	public void back(int menuId, int optId) {
		System.out.println("����0�����ϼ��˵�������1����ִ��");
		choice = sc.nextInt();
		switch (choice) {
		case 0:
			if (menuId == 1) {
				start();
				break;
			}
			else if(menuId == 2){
				mainMenu();
				break;
			}
			break;
		default:
			// �жϵ�ǰ�����ı��
			switch (optId) {
			case 1:
				start();
				break;
			case 2:
				login();
				break;
			case 3:
				register();
				break;
			case 4:
				mainMenu();
				break;
			case 5:
				sweepstake();
				break;

			}

		}
	}

	/**
	 * ע��
	 */
	public void register() {
		System.out.print("��������Ҫע����û�����");
		name = sc.next();
		System.out.print("��������Ҫע������룺");
		pwd = sc.next();
		System.out.print("���ٴ�������Ҫע������룺");
		pwdAffirm = sc.next();
		// ������֤��
		codeStr = code.testCode();
		System.out.print("��������֤��" + codeStr + "��");
		String code = sc.next();

		// ��֤�û��������룬ȷ���������֤��
		if (validateRegistr(name)&&validate(pwd,pwdAffirm,code)) {
			
			// ���µ��û��������븳ֵ��Data
			data.name = name;
			data.pwd = pwd;
			System.out.println("ע��ɹ���");
			// ע��ɹ��˻ؿ�ʼ�˵�
			start();		
		}	
		// ע��ʧ��
		else {
			back(1, 3);
		}

	}

	/**
	 * ��֤ע��ʱ���û����Ƿ����Ѿ����ڵ��û����ظ�
	 * 
	 * @param name ������û���
	 */
	public boolean validateRegistr(String name) {

		// ��֤�û����Ƿ��ظ�
		if (name.equals(data.name)) {
			System.out.println("�û����Ѵ��ڣ�");
			return false;
		}
		return true;
	}

	/**
	 * ���˵�����
	 */
	public void mainMenu() {
		System.out.println("-------------���˵�����-----------------");
		System.out.println("1. ���˳齱");
		System.out.println("2. �������");
		System.out.println("3. ��Ʒ����");
		System.out.println("4. �������");
		System.out.print("��ѡ��");
		choice = sc.nextInt();
		switch(choice){
		case 1:
			//���˳齱
			sweepstake();
			back(2,5);
			break;
		case 2:
			//2. �������
			break;
		case 3:
			//3. ��Ʒ����
			break;
		case 4:
			//4. �������
			break;
		default:
			// �������
			System.out.println("��Ч�����룬������ѡ��");
			back(1,4);	
			break;
		}
	}
	
	//���˳齱
	public void sweepstake(){
		// ��������
		int luckyNum = (int) (Math.random() * 10);
		// ��������
		System.out.print("�����������������֣�");
		int num = sc.nextInt();
		// �Ƚ���������������
		if (luckyNum == num) {
			System.out.println("��ϲ�����н��ˣ����MP3һ����");
		} else {
			System.out.println("���ź�����û���н���");
		}
		back(2,5);
	}
	
}
