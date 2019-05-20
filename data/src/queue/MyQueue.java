package queue;
public class MyQueue {
	private Object[] arr;
	public MyQueue() {
		arr=new Object[0];
	}
	public void add(Object element) {
		Object[] newArr=new Object[arr.length+1];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		newArr[arr.length]=element;
		arr=newArr;
	}
	public Object poll() {
		if(isEmpty()) {
			return null;
		}
		Object obj=arr[0];
		Object[] newArr=new Object[arr.length-1];
		System.arraycopy(arr, 1, newArr, 0, arr.length-1);
		arr=newArr;
		return obj;
	}
	public boolean isEmpty() {
		return arr.length==0;
	}
}
