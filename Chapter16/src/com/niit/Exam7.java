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

	//保存文件出现的次数
	private Integer count = 0;
	
	public Exam7(){
		//反序列化获取次数
		//如果是第一次获取数据，该序列化文件将不会存在
		File file = new File("d:/count.temp");
		if(!file.exists()){
			//序列化写入
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
		//如果文件存在则读取文件获取数据
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
		File file = new File("d:/新建记事本.txt");
		//如果文件存在
		if(file.exists()){
			count++;
			//对count进行序列化保存
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
			file = new File("d:/复件 新建记事本"+count+".txt");
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
