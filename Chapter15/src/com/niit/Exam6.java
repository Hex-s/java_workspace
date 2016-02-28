package com.niit;
/**
 * ������ӡ4��ABCD,ÿ���̷ֱ߳��ӡ���и�һ����ĸ���磺��һ���̸߳����ӡA���ڶ����̴߳�ӡB
 * @author Administrator
 *
 */
public class Exam6 extends Thread{
	//�̵߳����ƣ�Ҳ��ʾ��ǰ�߳�Ҫ��ӡ����ĸ
	//private String name;
	private LockObj obj;
	
	//��ǰ�̴߳�ӡ�Ĵ���
	private int count = 0;
	
	public Exam6(String name, LockObj obj){
		super(name);
		this.obj = obj;
	}
	public void run(){
		while(count < 4){
			//��������
			synchronized (obj) {
				if(count < 4){
					//�жϵ�ǰ�߳��Ƿ�����Ҫ��ӡ���߳�
					if(this.getName().equals(obj.getWord())){
						//�ۼӵ�ǰ�̴߳�ӡ�Ĵ���
						count++;
						//��ǰ�߳���ָ����ӡ���̶߳���
						System.out.println(this.getName());
						//���ݵ�ǰ���߳����ƾ���һ�¸�Ҫ��ӡ����ĸ
						if(this.getName().equals("A")){
							obj.setWord("B");
						}
						else if(this.getName().equals("B")){
							obj.setWord("C");
						}
						else if(this.getName().equals("C")){
							obj.setWord("D");
							
						}
						else{
							obj.setWord("A");
						}
						//���������������߳�
						obj.notifyAll();
					}
					//��һ�δ�ӡ��ֵӦΪA�������ʱB,C,D�߳̾߱����ȼ��ȱ���������סobj��Ӧ������ͣ
					
					else{
						//�����ǰ�̲߳���Ҫ��ӡ���̣߳���ͣ��ǰ���߳�
						try {
							obj.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LockObj obj = new LockObj();
		Exam6 th1 = new Exam6("A", obj);
		Exam6 th2 = new Exam6("B", obj);
		Exam6 th3 = new Exam6("C", obj);
		Exam6 th4 = new Exam6("D", obj);
		
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}

}
