
public class FactoryTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ʵ����������
		Factory factory = new Factory();
		//������Ʒ
		Ware ware = factory.buildWare();
		//Ware ware = new Ware();
		//System.out.println(ware.wareName);
		//ʵ����������
		Proxyer proxyer = new Proxyer();
		//�����̴����˸���Ʒ
		proxyer.getProxyWare(ware);
		System.out.println(proxyer.ware);
		//ʵ����һ�����
		Human man = new Human();
		//��ҹ����˴����̵���Ʒ
		Ware buyWare = man.shopping(proxyer);
		System.out.println("�������Ʒ�ǣ�"+ware.wareName);
		
	}

}
