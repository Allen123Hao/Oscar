package com.hao.bigdata;

public class ArrayList_Demo1 {

	public static void main(String[] args) {
		int[] array = {0,1,2,2,3,3,5,5,0};
		new ArrayList_Demo1().prePeat(array);

	}
	public void prePeat(int array[]){
		int max = 0;
		for(int i=0;i<array.length;i++){
			if(max < array[i]){
				max = array[i];
			}
		}
		if(max == 0){
			max = 0;
		}else{
			max += 1;
		}
		byte[] bt = new byte[max];
		for(int i=0;i<array.length;i++){
			System.out.println("array["+i+"]--"+array[i]);
			System.out.println("bt[array["+i+"]]--"+bt[array[i]]);
			if(bt[array[i]] == 1){
				System.out.println(array[i]);
			}
			if(array[i] != 0){
				bt[array[i]] = 1;
			}
			if(array[i] == 0){
				bt[array[i]] = 1;
			}
		}
	}

}
