import java.util.Scanner;

/**
 * ������
 * @author Administrator
 *
 */
public class Factory {
	
	/**
	 * ������Ʒ�ķ�����ÿһ�ε��ø÷�������ʾ����һ����Ʒ����
	 * @return
	 */
	public Ware buildWare(){
		System.out.println("������������.......");
		//ͨ����������˲�Ʒ
		Ware ware = new Ware();
		ware.wareName = "�ֻ�";
		System.out.println("ͨ�����������"+ware.wareName);
		//������������Ʒ
		return ware;
	}
}
