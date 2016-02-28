package com.niit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

public class Exam7 {

	//�����ļ����ֵĴ���
	private Integer count = 0;
	
	public Exam7(){
		//�����л���ȡ����
		//����ǵ�һ�λ�ȡ���ݣ������л��ļ����������
		File file = new File("d:/count.temp");
		if(!file.exists()){
			//���л�д��
			try {
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("d:/count.temp")));
				output.writeObject(count);
				output.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//����ļ��������ȡ�ļ���ȡ����
		else{
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
				count = (Integer)input.readObject();
				input.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void createTxtFile(){
		File file = new File("d:/�½����±�.txt");
		//����ļ�����
		if(file.exists()){
			count++;
			//��count�������л�����
			try {
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("d:/count.temp")));
				output.writeObject(count);
				output.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			file = new File("d:/���� �½����±�"+count+".txt");
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			String s;
			while(!(s = reader.readLine()).equals("#")){
				writer.write(s);
			}
			reader.close();
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam7 ex = new Exam7();
		ex.createTxtFile();

	}

}
