package com.niit.dao.util;

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


/**
 * DAO���ݲ���������
 * @author Administrator
 *
 */
public class DaoHandle {

	
	/**
	 * ��ѯ����
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int executeQueryForCount(String sql, Object[] params){
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = DaoUtil.getConnection();
		if(con != null){
			try {
				pstmt = con.prepareStatement(sql);
				//ע�����
				if(params != null){
					//ע�����
					for(int i = 0; i < params.length; i++){
						pstmt.setObject(i+1, params[i]);
					}
				}
				rs = pstmt.executeQuery();
				while(rs.next()){
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				DaoUtil.closeAll(con, pstmt, rs);
			}
		}
		return count;
		
	}
	/**
	 * ִ����ɾ�Ĳ���
	 * @param sql
	 * @param params ע��Ĳ�������
	 */
	public static void executeUpdate(String sql, Object[] params){
		Connection con = null;
		PreparedStatement pstmt = null;
		//��ȡ���ݿ�����
		con = DaoUtil.getConnection();
		if(con != null){
			try {
				//��ȡ������
				pstmt = con.prepareStatement(sql);
				//ע�����
				if(params != null){
					//ע�����
					for(int i = 0; i < params.length; i++){
						pstmt.setObject(i+1, params[i]);
					}
				}
				//ִ��SQL���
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
	 * @param <T> �ֲ����͵�������ֻ���ڵ�ǰ������ʹ�ø÷���
	 * @param sql
	 * @param params
	 * @param objClass
	 * @return
	 */
	public static <T> ArrayList<T> executeQuery(String sql, Object[] params, Class<T> objClass){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//��������
		ArrayList<T> list = new ArrayList<T>();
		//��ȡ����
		con = DaoUtil.getConnection();
		if(con != null){
			try {
				//��ȡ������
				pstmt = con.prepareStatement(sql);
				if(params != null){
					//ע�����
					for(int i = 0; i < params.length; i++){
						pstmt.setObject(i+1, params[i]);
					}
				}
				//ִ�в�ѯ
				rs = pstmt.executeQuery();
				//��ȡԪ����
				ResultSetMetaData metaData = rs.getMetaData();
				//��ȡ�����е�����
				int[] types = getColumnType(metaData);
				//��ȡ�����е�����
				String[] names = getColumnName(metaData);
				//�����ȡ������з���
				Method[] methods = objClass.getDeclaredMethods();
				//���������
				while(rs.next()){
					//�������ϴ洢��ÿһ������ͨ�������ȡ�����ʵ��
					Object obj = objClass.newInstance();
					//ѭ�����������е���������
					for(int i = 0; i < types.length; i++){
						//ÿ�е�ֵ
						Object value = null;
						//�ж��е��������ͣ��������;������õ� ResultSet.getXX����
						//��ֵ����
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
						//����
						else if(types[i] == OracleTypes.DATE){
							value = rs.getTimestamp(i+1);
						}
						//�ַ������
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
						//�������
						else{
							value = rs.getObject(i+1);
						}
						//�������еķ��������set+��ǰ�е����Ƶ���ָ���� setter��������Ը÷������е���
						for(Method method : methods){
							
							if(method.getName().equalsIgnoreCase("set"+names[i])){
								//���ø÷���,��ÿ�е���������������������
								method.invoke(obj, value);
							}
						}
					}	
					//���������������
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
	 * ��ȡ��ѯ����������е���������
	 * @param metaDa
	 * @return
	 * @throws SQLException 
	 */
	public static int[] getColumnType(ResultSetMetaData metaData) throws SQLException{
		//��ȡ�е�����
		int count = metaData.getColumnCount();
		int[] types = new int[count];
		//�������е���
		for(int i = 1; i <= count; i++){
			//����ȡ�е���������д������
			types[i-1] = metaData.getColumnType(i);
		}
		return types;
	}
	/**
	 * ��ȡ��ѯ��������е�����
	 * @param metaDa
	 * @return
	 * @throws SQLException 
	 */
	public static String[] getColumnName(ResultSetMetaData metaData) throws SQLException{
		//��ȡ�е�����
		int count = metaData.getColumnCount();
		String[] names = new String[count];
		for(int i = 1; i <= count; i++){
			names[i-1] = metaData.getColumnName(i);
		}
		return names;
	}
	
}
