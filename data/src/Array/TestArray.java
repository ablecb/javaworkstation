package Array;

import java.util.Arrays;

public class TestArray {
//数组元素的添加
	public static void main(String[] args) {
		int [] arr=new int[] {1,2,3,4};
		
		int [] newArr=new int[arr.length+1];
		for(int i=0;i<arr.length;i++) {
			newArr[i]=arr[i];
		}
		newArr[arr.length]=5;
		arr=newArr;
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
	}

}
