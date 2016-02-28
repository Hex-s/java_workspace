import java.util.Scanner;


/**
 * ˰ǰ���ʣ������������ʣ����˹��ʣ��Ӱ�ѵȵȣ�������µ��������룩
 *ÿ������Ҫ���ɸ�������˰����������˰����������3500��
 *�����������8000���ڽ�˰10%�������������8000-15000��˰������15%��15000������20%
 *��������˰�������Ҫ�������Ͻ�͹�����
 *������ɽ��ɲ�������������������Ͻ𣨰���������ʧҵ���ս�ȣ������λ8%�������11%��
 *����н���������߱�����11%�����������ܱ������Ϊ22%
 * @author Administrator
 *
 */
public class CalculateSalary {

	/**
	 * ����˰���ʵķ���
	 * @param beforeSalary ˰ǰ����
	 * @param flag �Ƿ񽻹�����ı�ʶ
	 * @param rate1 ������Ľ��ɱ���
	 * @param rate2���Ͻ�Ľ��ɱ���
	 * @return
	 */
	public double getSalary(double beforeSalary, boolean flag, double rate1, double rate2){
		//˰����
		double afterSalary = 0;
		//��������������˰��Ĺ���
		//����3500
		if(beforeSalary < 3500){
			//����Ҫ���ɸ�˰
			afterSalary = beforeSalary;
		}
		//����8000
		else if(beforeSalary < 8000){
			afterSalary = 3500+(beforeSalary-3500)*(1-0.1);
		}
		//����15000
		else if(beforeSalary < 15000){
			afterSalary = 3500+(8000-3500)*(1-0.1)+(beforeSalary-8000)*(1-0.15);
		}
		//15000���ϵ�
		else{
			afterSalary = 3500+(8000-3500)*(1-0.1)+(15000-8000)*(1-0.15)+(beforeSalary-15000)*(1-0.2);
		}
		//��˰��Ĺ��ʼ������ڽ��ɹ���������Ͻ�
		//�۳��Ĺ�����
		double money = 0;
		//�жϹ������Ƿ���Ҫ����
		if(flag){
			//��Ҫ���ɹ�����,���㹫����Ľ��
			money = afterSalary*rate1;
		}
		//���۹������Ƿ���Ҫ���ɣ����Ͻ𶼱ȼ�������
		afterSalary = afterSalary-afterSalary*rate2-money;
		return afterSalary;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CalculateSalary ex = new CalculateSalary();
		Scanner sc = new Scanner(System.in);
		System.out.println("���������˰ǰ���ʣ�");
		double beforeSalary = sc.nextDouble();
		System.out.println("�Ƿ���Ҫ���ɹ�����");
		boolean flag = sc.nextBoolean();
		double rate1 = 0;
		if(flag){
			System.out.println("���ɵĹ����������");
			rate1 = sc.nextDouble();
			if(rate1 < 0 || rate1 > 0.11){
				System.out.println("�Ƿ��Ĺ��������");
				return;
			}
		}
		System.out.println("���ɵ����Ͻ�ı�����");
		double rate2 = sc.nextDouble();
		if(rate2 < 0 || rate2 > 0.11 ){
			System.out.println("�Ƿ������Ͻ����");
			return;
		}
		
		double afterSalary = ex.getSalary(beforeSalary, flag, rate1, rate2);
		System.out.println("˰�����ǣ�"+afterSalary);

	}

}
