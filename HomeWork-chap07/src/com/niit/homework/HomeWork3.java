package com.niit.homework;

public class HomeWork3 {
	
	/**
	 * ≤Â»Î≈≈–Ú∑®
	 */
	public void injectionSort(int[] array){
		for(int i = 1; i < array.length; i++){
			for(int j = 0; j < i; j++){
				if(array[j] < array[i]){
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}

	public void showArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]+"\t");
		}
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HomeWork3 hw = new HomeWork3();
		int[] array = new int[]{12,34,56,43,11,89,14,99};
		System.out.print("≈≈–Ú«∞£∫");
		hw.showArray(array);
		hw.injectionSort(array);
		System.out.println();
		System.out.print("≈≈–Ú∫Û£∫");
		hw.showArray(array);

	}

}
