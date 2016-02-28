import java.util.Scanner;

/**
 * ����ϵͳ��
 * @author Administrator
 *
 */
public class ShoppingSystem {
	//���ڼ������������Ҫ�ڶ���������ظ���������˳��������
	Scanner sc;
	//ϵͳ���������
	Data data;
	
	/**
	 * ��ʼ��ϵͳ
	 */
	public void init(){
		sc = new Scanner(System.in);
		data = new Data();
	}
	/**
	 * ����ϵͳ�ķ���
	 */
	public void start(){
		System.out.println("----------------����ϵͳ-------------");
		System.out.println("1. ��½");
		System.out.println("2. ע��");
		System.out.println("3. �˳�");
		System.out.println("��ѡ��");
		int chooice = sc.nextInt();
		switch(chooice){
		case 1:
			//��½
			login();
			break;
		case 2:
			//ע��
			regist();
			break;
		case 3:
			//�˳�
			System.out.println("�����˳�����ӭ�´�ʹ��ϵͳ");
			break;
		default:
			System.out.println("��Ч�����룬������ѡ��");
			//�ݹ�
			//start();
			back(1, 1);
			break;
		}
	}
	/**
	 * ��½����
	 */
	public void login(){
		System.out.println("�������û�����");
		String name = sc.next();
		System.out.println("���������룺");
		String pwd = sc.next();
		//������֤�ķ���
		if(validate(name, pwd)){
			System.out.println("��¼�ɹ�");
		}
		else{
			System.out.println("�û����������������������");
			//�ݹ����login����
			//login();
			back(1, 2);
		}
	}
	
	/**
	 * У��ķ���
	 * @param name ������û���
	 * @param pwd ���������
	 * @return У��Ľ��
	 */
	public boolean validate(String name, String pwd){
		if(!name.equals(data.name)){
			return false;
		}
		if(!pwd.equals(data.pwd)){
			return false;
		}
		return true;
	}
	/**
	 * ע�Ṧ��
	 */
	public void regist(){
		
	}
	/**
	 * ���ز˵���ѡ��ķ���
	 * @param menuId �ϼ��˵��ı�� 1��ʾ���˵�
	 * @param optId ��ǰ�����ı�� 1��ʾ���˵���ѡ��  2��ʾ��¼  3��ʾע��
	 */
	public void back(int menuId, int optId){
		System.out.println("����0�����ϼ��˵����������ּ���ִ��");
		int chooice = sc.nextInt();
		switch(chooice){
		case 0:
			if(menuId == 1){
				start();
			}
			break;
		default:
			//�жϵ�ǰ�����ı��
			switch(optId){
			case 1:
				start();
				break;
			case 2:
				login();
				break;
			case 3:
				regist();
				break;
			}
			
		}
	}
}
