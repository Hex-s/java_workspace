/**
 * ��������
 * @author Administrator
 *
 */
public class Proxyer {

	//��Ʒ���ԣ���ʾ�����̷���������
	//���е�java���Ĭ��ֵ��Ϊnull
	Ware ware;
	//�����̵�Ʒ��
	String band = "XXƷ��";
	/**
	 * ������Ʒ�ķ���
	 */
	public void getProxyWare(Ware ware){
		System.out.println("��������Ʒ����Ʒ�����ǣ�"+ware.wareName);
		//�����ȡ����Ʒ
		this.ware = ware;
	}
	
	/**
	 * ������Ʒ�ķ���
	 */
	public void sellWare(){
		
	}
}
