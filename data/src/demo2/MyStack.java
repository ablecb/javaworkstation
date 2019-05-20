package demo2;

public class MyStack {
	private Object[] arr;
	public MyStack() {
		arr=new Object[0];
	}
	public void push(Object element) {
		Object[] newArr=new Object[arr.length+1];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		newArr[arr.length]=element;
		arr=newArr;
	}
	public Object pop() {
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Object[] newArr=new Object[arr.length-1];
		Object element=arr[arr.length-1];
		System.arraycopy(arr, 0, newArr, 0, newArr.length);
		arr=newArr;
		return element;
	}
	public Object peek() {
		if(isEmpty()) {
			return null;
		}
		return arr[arr.length-1];
	}
	public boolean isEmpty() {
		return arr.length==0;
	}
}
