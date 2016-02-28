package com.niit.exam3;
/**
 * 驾驶员类
 * @author Administrator
 *
 */
public class Driver {

	private String userName;
	/**
	 * 带参构造方法，传入驾驶员的姓名
	 * @param userName
	 */
	public Driver(String userName){
		this.userName = userName;
	}
	/**
	 * 构造方法也能重载
	 */
	public Driver(){
		
	}
	
	/**
	 * 驾驶的方法
	 * 在同一个类中，方法名相同，但是参数列表不同(参数的数量，类型)将会构成方法的重载
	 * 重载主要用于方法名的复用
	 */
	public void drive(){
		System.out.println("驾驶员具备驾驶方法");
	}
	/**
	 * 驾驶飞机的方法
	 * @param plane
	 */
	public void drive(Plane plane){
		System.out.println(userName+"正在驾驶"+plane.getPlaneName());
	}
	/**
	 * 驾驶汽车的方法
	 * @param car
	 */
	public void drive(Car car){
		System.out.println(userName+"正在驾驶"+car.getCarName());
	}
	/**
	 * 驾驶轮船的方法
	 * @param ship
	 */
	public void drive(Ship ship){
		System.out.println(userName+"正在驾驶"+ship.getShipName());
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
//	public void driveCar(Car car){
//		System.out.println(userName+"正在驾驶"+car.getCarName());
//	}
//	public void driveShip(Ship ship){
//		System.out.println(userName+"正在驾驶"+ship.getShipName());
//	}
//	public void drivePlane(Plane plane){
//		System.out.println(userName+"正在驾驶"+plane.getPlaneName());
//	}
}
