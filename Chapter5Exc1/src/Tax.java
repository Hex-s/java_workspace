

public class Tax {
	
	//���չ���
	double money;
	
	//�Ƿ���ɹ����� true��ʾ���� false��ʾ������
	boolean fundChoose = false;


	
	/**
	 * 
	 * @param salary �����˰ǰ����
	 * @return ���������
	 */
	public double getSalary(double salary,double old,int fundInt,double fund,double startSalary){

		//�۳���������˰
		if(salary <= startSalary){
			money = salary;
		}
		else if(salary <= 8000){
			money = salary - (salary - startSalary) * 0.1;
		}
		else if(salary <= 15000){
			money = salary - (salary - 8000) * 0.15 - (8000 - startSalary) * 0.1;
		}
		else{
			money = salary- (salary - 15000)* 0.2 - (15000 - 8000) * 0.15 - (8000 - startSalary) * 0.1;
		}
		//���ϱ��ս���Ҫ���ɵ�ǰ
		double moneyOld = money * old;
		
		//��������Ҫ���ɵ�Ǯ
		double moneyFund = 0;
		if(fundChoose == true){
			moneyFund = money * fund;
		}
		//�۳����Ͻ�͹����������յĹ���
		money = money - moneyOld - moneyFund;
		
		return money;
	}

}
