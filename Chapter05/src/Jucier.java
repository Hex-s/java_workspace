import java.io.ObjectInputStream.GetField;

/**
 * ե֭����
 * @author Administrator
 *
 */
public class Jucier {

	/**
	 * ե֭�ķ���
	 * @return
	 */
	public String getJuice(String fruit){
		return fruit+"֭";
	}
	
	public static void main(String[] args) {
		//ʵ����ե֭��
		Jucier jucier = new Jucier();
		//����ե֭
		//���ô������ķ������ⲿ����Ĳ���Ӧ�ͷ�������ʱ���������ͣ�������˳��Ӧƥ��
		String jucie = jucier.getJuice("ƻ��");
		System.out.println("����ˣ�"+jucie);
		
	}
}
