package Array;

import java.util.Arrays;

public class TestOpArray2 {
	public static void main(String[] args) {
		int[] arr=new int[] {5,5,2,3,4,5};
		int[] newArr=new int[arr.length-1];
		int index=2;
		for(int i=0;i<arr.length;i++) {
			if(i<index) {
				newArr[i]=arr[i];
			}else if(index==i) {
				continue;
			}
			else
			{
				newArr[i-1]=arr[i];
			}
		}
		arr=newArr;
		System.out.println(Arrays.toString(arr));
	}
}
