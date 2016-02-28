package com.niit.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleTypes;

import com.niit.entity.User;

/**
 * DAO数据操作辅助类
 * @author Administrator
 *
 */
public class DaoHandle {

	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	/**
	 * 执行增删改操作
	 * @param sql
	 * @param params 注入的参数数组
	 */
	public static void executeUpdate(String sql, Object[] params){
		//获取数据库连接
		con = DaoUtil.getConnection();
		if(con != null){
			try {
				//获取处理器
				pstmt = con.prepareStatement(sql);
				//注入参数
				if(params != null){
					//注入参数
					for(int i = 0; i < params.length; i++){
						pstmt.setObject(i+1, params[i]);
					}
				}
				//执行SQL语句
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DaoUtil.closeAll(con, pstmt, null);
			}
		}
	}
	
	/**
	 * 
	 * @param <T> 局部泛型的声明，只能在当前方法中使用该泛型
	 * @param sql
	 * @param params
	 * @param objClass
	 * @return
	 */
	public static <T> ArrayList<T> executeQuery(String sql, Object[] params, Class<T> objClass){
		//创建集合
		ArrayList<T> list = new ArrayList<T>();
		//获取连接
		con = DaoUtil.getConnection();
		if(con != null){
			try {
				//获取处理器
				pstmt = con.prepareStatement(sql);
				if(params != null){
					//注入参数
					for(int i = 0; i < params.length; i++){
						pstmt.setObject(i+1, params[i]);
					}
				}
				//执行查询
				rs = pstmt.executeQuery();
				//获取元数据
				ResultSetMetaData metaData = rs.getMetaData();
				//获取所有列的类型
				int[] types = getColumnType(metaData);
				//获取所有列的名称
				String[] names = getColumnName(metaData);
				//反射获取类的所有方法
				Method[] methods = objClass.getDeclaredMethods();
				//遍历结果集
				while(rs.next()){
					//创建集合存储的每一个对象，通过反射获取对象的实例
					Object obj = objClass.newInstance();
					//循环遍历所有列的数据类型
					for(int i = 0; i < types.length; i++){
						//每列的值
						Object value = null;
						//判断列的数据类型，根据类型决定调用的 ResultSet.getXX方法
						//数值类型
						if(types[i] == OracleTypes.NUMBER){
							BigDecimal decimal = rs.getBigDecimal(i+1);
							//System.out.println(decimal);
							if(CommonUtil.isDouble(decimal)){
								value = rs.getDouble(i+1);
							}
							else{
								value = rs.getInt(i+1);
							}
						}
						//日期
						else if(types[i] == OracleTypes.DATE){
							value = rs.getTimestamp(i+1);
						}
						//字符大对象
						else if(types[i] == OracleTypes.CLOB){
							String str = "";
							String data = "";
							BufferedReader reader = new BufferedReader(rs.getClob(i+1).getCharacterStream());
							try {
								while((data = reader.readLine()) != null){
									str+=data;
								}
								reader.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							value = str;
						}
						//其余情况
						else{
							value = rs.getObject(i+1);
						}
						//遍历所有的方法，如果set+当前列的名称等于指定的 setter方法，则对该方法进行调用
						for(Method method : methods){
							
							if(method.getName().equalsIgnoreCase("set"+names[i])){
								//调用该方法,将每列的数据添加至对象的属性中
								method.invoke(obj, value);
							}
						}
					}	
					//将对象添加至集合
					T t = (T)obj;
					list.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DaoUtil.closeAll(con, pstmt, rs);
			}
		}
		return list;
		
	}
	/**
	 * 获取查询结果的所有列的数据类型
	 * @param metaDa
	 * @return
	 * @throws SQLException 
	 */
	public static int[] getColumnType(ResultSetMetaData metaData) throws SQLException{
		//获取列的数量
		int count = metaData.getColumnCount();
		int[] types = new int[count];
		//遍历所有的列
		for(int i = 1; i <= count; i++){
			//将获取列的数据类型写入数组
			types[i-1] = metaData.getColumnType(i);
		}
		return types;
	}
	/**
	 * 获取查询结果所有列的列名
	 * @param metaDa
	 * @return
	 * @throws SQLException 
	 */
	public static String[] getColumnName(ResultSetMetaData metaData) throws SQLException{
		//获取列的数量
		int count = metaData.getColumnCount();
		String[] names = new String[count];
		for(int i = 1; i <= count; i++){
			names[i-1] = metaData.getColumnName(i);
		}
		return names;
	}
	
}
