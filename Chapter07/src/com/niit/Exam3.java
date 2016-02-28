package com.niit;

public class Exam3 {

	/**
	 * 编写方法，判断整型数组中是否包含某一个元素 
	 */
	public int hasNumber(int[] array, int num){
		//遍历数组中的元素
		for(int i = 0; i < array.length; i++){
			//判断每个元素是否和要比较的num相同
			if(array[i] == num){
				return i;
			}
		}
		return -1;
	}
	/**
	 * 在指定的顺序排列数组中插入数据
	 * @param array
	 * @param num
	 * @return
	 */
	public int[] insert(int[] array, int num){
		//获取要新增的数据在数组中的索引位置
		int index = -1;
		for(int i = 0; i < array.length; i++){
			//如果元素的值比要插入的值大，则记录索引
			if(array[i] > num){
				index = i;
				break;
			}
		}
		//从数组的最后一个元素开始依次和前一个元素的值进行交换
		for(int i = array.length-1; i > index; i--){
			//当前元素交换前一个元素
			array[i] = array[i-1];
		}
		//将要插入的值更改至对应的索引
		array[index] = num;
		return array;
	}
	/**
	 * 删除指定的元素
	 * @param array
	 * @param num
	 * @return
	 */
	public int[] delete(int[] array, int num){
		//判断要删除的数是否存在
		int index = hasNumber(array, num);
		//如果存在该数
		if(index != -1){
			//从删除数的下标开始循环交换后一位数
			for(int i = index; i < array.length-1; i++){
				//当前元素交换后一位元素
				array[i] = array[i+1];
			}
		}
		return array;
	}
	
	public void showArray(int[] array, int length){
		for(int i = 0; i < length; i++){
			System.out.print(array[i]+"\t");
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam3 ex = new Exam3();
//		int[] array = new int[]{56,73,45};
//		if(ex.hasNumber(array, 56)){
//			System.out.println("包含此数");
//		}
//		else{
//			System.out.println("要搜索的数据不存在");
//		}
		int[] array = new int[]{10,20,30,40,50,60};
		//插入
		//ex.insert(array, 65);
		//删除
		ex.delete(array, 30);
		ex.showArray(array, array.length-1);

	}

}
