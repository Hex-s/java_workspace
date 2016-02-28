

public class Tax {
	
	//最终工资
	double money;
	
	//是否缴纳公积金 true表示缴纳 false表示不缴纳
	boolean fundChoose = false;


	
	/**
	 * 
	 * @param salary 输入的税前工资
	 * @return 返回最后工资
	 */
	public double getSalary(double salary,double old,int fundInt,double fund,double startSalary){

		//扣除个人所得税
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
		//养老保险金需要缴纳的前
		double moneyOld = money * old;
		
		//公积金需要缴纳的钱
		double moneyFund = 0;
		if(fundChoose == true){
			moneyFund = money * fund;
		}
		//扣除养老金和公积金后的最终的工资
		money = money - moneyOld - moneyFund;
		
		return money;
	}

}
