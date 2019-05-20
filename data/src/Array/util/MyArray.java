package Array.util;
import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class MyArray {
	private Object[] arr;
	public MyArray() {
		arr=new Object[0];
	}
	public int size() {
		return arr.length;
	}
	public void insert(Object element) {
		Object[] newArr=new Object[arr.length+1];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		newArr[arr.length]=element;
		arr=newArr;
	}
	public void show() {
		System.out.println(Arrays.toString(arr));
	}
	public void delete(int index) {
		if(index<0||index>arr.length-1) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界");
		}
		Object[] newArr=new Object[arr.length-1];
		System.arraycopy(arr, 0, newArr, 0, index);
		System.arraycopy(arr, index+1, newArr, index, arr.length-1-index);
		arr=newArr;
	}
	public Object get(int index) {
		return arr[index];
	}
	public void insert(Object element,int index) {
		if(index<0||index>arr.length) {
			throw new ArrayIndexOutOfBoundsException("数组下标越界");
		}
		Object[] newArr=new Object[arr.length+1];
		System.arraycopy(arr, 0, newArr, 0, index);
		newArr[index]=element;
		System.arraycopy(arr, index, newArr, index+1, arr.length-index);
		arr=newArr;
		
	}
	public void set(Object element,int index) {
		if(index<0||index>arr.length-1) {
			throw new ArrayIndexOutOfBoundsException();
		}
		arr[index]=element;                                                                      
	}
}
