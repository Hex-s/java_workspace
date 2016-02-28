package com.niit.reflect;

import java.beans.FeatureDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.util.Date;

import com.niit.entity.User;

/**
 * 反射的使用
 * @author Administrator
 *
 */
public class Exam {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		
		//Class是类的模板，封装了类的结构信息
		//Class.forName表示动态加载某个Java类，并获取其模板
		
		Class objClass = Class.forName("com.niit.entity.User");
		//获取类的完整名称
//		System.out.println(objClass.getName());
		//获取类名
//		System.out.println(objClass.getSimpleName());
		//根据模板对象获取类的实例
		Object obj = objClass.newInstance();
		//判断对象的类型
//		if(obj instanceof User){
//			//拆箱
//			User user = (User)obj;
//			System.out.println(user.getUserName());
//		}
		//通过类的模板判断类的类型
//		if(objClass == User.class){
//			//拆箱
//			User user = (User)obj;
//			System.out.println(user.getUserName());
//		}
		
		//通过模板获取该类的所有构造方法，包含父类的内容
		//Constructor<User>[] cons = objClass.getConstructors();
		//getDeclaredConstructors获取类自身的构造方法
		//Constructor<User>[] cons = objClass.getDeclaredConstructors();
		//获取指定参数的构造方法
//		Constructor<User> con = objClass.getDeclaredConstructor(int.class,String.class,String.class,Timestamp.class);
//		//通过构造方法获取类的实例对象
//		Object obj = con.newInstance(1,"jack","123",new Timestamp(new Date().getTime()));
//		
		
		//反射类的所有属性
//		Field[] fields = objClass.getDeclaredFields();
//		for(Field f : fields){
//			System.out.println(f.getName());
//		}
		
		//反射类的所有方法
		//Method[] methods = objClass.getMethods();
		Method[] methods = objClass.getDeclaredMethods();
		for(Method m : methods){
			//获取方法的名称
			System.out.println(m.getName());
			//获取方法的访问修饰符
//			System.out.println(m.getModifiers());
//			System.out.println(Modifier.STATIC);
			//获取方法的参数类型
			Class[] paramTypes = m.getParameterTypes();
			for(Class paramType : paramTypes){
				System.out.print(paramType.getSimpleName()+"\t");
			}
			System.out.println();
			//执行方法setUserName方法
			if(m.getName() == "setUserName"){
				//invoke用来通过method方法对象反射执行该方法动作
				//第一个参数表示方法执行依赖的对象，第二个参数表示方法传入的参数值，返回值表示method方法运行后返回的结果，如果方法没有返回值则为null
				Object returnValue = m.invoke(obj, "tony");
				System.out.println(returnValue);
			}
		}
		if(obj instanceof User){
			User user = (User)obj;
			System.out.println(user.getUserName());
		}
			
		//System.out.println(obj);
	}
}
