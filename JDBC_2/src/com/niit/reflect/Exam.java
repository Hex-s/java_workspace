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
 * �����ʹ��
 * @author Administrator
 *
 */
public class Exam {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
		
		//Class�����ģ�壬��װ����Ľṹ��Ϣ
		//Class.forName��ʾ��̬����ĳ��Java�࣬����ȡ��ģ��
		
		Class objClass = Class.forName("com.niit.entity.User");
		//��ȡ�����������
//		System.out.println(objClass.getName());
		//��ȡ����
//		System.out.println(objClass.getSimpleName());
		//����ģ������ȡ���ʵ��
		Object obj = objClass.newInstance();
		//�ж϶��������
//		if(obj instanceof User){
//			//����
//			User user = (User)obj;
//			System.out.println(user.getUserName());
//		}
		//ͨ�����ģ���ж��������
//		if(objClass == User.class){
//			//����
//			User user = (User)obj;
//			System.out.println(user.getUserName());
//		}
		
		//ͨ��ģ���ȡ��������й��췽�����������������
		//Constructor<User>[] cons = objClass.getConstructors();
		//getDeclaredConstructors��ȡ������Ĺ��췽��
		//Constructor<User>[] cons = objClass.getDeclaredConstructors();
		//��ȡָ�������Ĺ��췽��
//		Constructor<User> con = objClass.getDeclaredConstructor(int.class,String.class,String.class,Timestamp.class);
//		//ͨ�����췽����ȡ���ʵ������
//		Object obj = con.newInstance(1,"jack","123",new Timestamp(new Date().getTime()));
//		
		
		//���������������
//		Field[] fields = objClass.getDeclaredFields();
//		for(Field f : fields){
//			System.out.println(f.getName());
//		}
		
		//����������з���
		//Method[] methods = objClass.getMethods();
		Method[] methods = objClass.getDeclaredMethods();
		for(Method m : methods){
			//��ȡ����������
			System.out.println(m.getName());
			//��ȡ�����ķ������η�
//			System.out.println(m.getModifiers());
//			System.out.println(Modifier.STATIC);
			//��ȡ�����Ĳ�������
			Class[] paramTypes = m.getParameterTypes();
			for(Class paramType : paramTypes){
				System.out.print(paramType.getSimpleName()+"\t");
			}
			System.out.println();
			//ִ�з���setUserName����
			if(m.getName() == "setUserName"){
				//invoke����ͨ��method����������ִ�и÷�������
				//��һ��������ʾ����ִ�������Ķ��󣬵ڶ���������ʾ��������Ĳ���ֵ������ֵ��ʾmethod�������к󷵻صĽ�����������û�з���ֵ��Ϊnull
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
