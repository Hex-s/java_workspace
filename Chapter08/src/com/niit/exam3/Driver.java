package com.niit.exam3;
/**
 * ��ʻԱ��
 * @author Administrator
 *
 */
public class Driver {

	private String userName;
	/**
	 * ���ι��췽���������ʻԱ������
	 * @param userName
	 */
	public Driver(String userName){
		this.userName = userName;
	}
	/**
	 * ���췽��Ҳ������
	 */
	public Driver(){
		
	}
	
	/**
	 * ��ʻ�ķ���
	 * ��ͬһ�����У���������ͬ�����ǲ����б�ͬ(����������������)���ṹ�ɷ���������
	 * ������Ҫ���ڷ������ĸ���
	 */
	public void drive(){
		System.out.println("��ʻԱ�߱���ʻ����");
	}
	/**
	 * ��ʻ�ɻ��ķ���
	 * @param plane
	 */
	public void drive(Plane plane){
		System.out.println(userName+"���ڼ�ʻ"+plane.getPlaneName());
	}
	/**
	 * ��ʻ�����ķ���
	 * @param car
	 */
	public void drive(Car car){
		System.out.println(userName+"���ڼ�ʻ"+car.getCarName());
	}
	/**
	 * ��ʻ�ִ��ķ���
	 * @param ship
	 */
	public void drive(Ship ship){
		System.out.println(userName+"���ڼ�ʻ"+ship.getShipName());
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
//	public void driveCar(Car car){
//		System.out.println(userName+"���ڼ�ʻ"+car.getCarName());
//	}
//	public void driveShip(Ship ship){
//		System.out.println(userName+"���ڼ�ʻ"+ship.getShipName());
//	}
//	public void drivePlane(Plane plane){
//		System.out.println(userName+"���ڼ�ʻ"+plane.getPlaneName());
//	}
}
