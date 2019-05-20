package day5;

import java.util.ArrayList;
import java.util.Collection;

public class GenericTest<E> {

	public static void main(String[] args)throws Exception {
	/*	Constructor<String> con=String.class.getConstructor(StringBuffer.class);
		String  str=con.newInstance(new StringBuffer("abc"));
		System.out.println(str);*/
		ArrayList<String> arr=new ArrayList<>();
		Class clazz=arr.getClass();
		clazz.getMethod("add",Object.class).invoke(arr,"123");
		System.out.println(arr.get(0));
		Object obj=new Object();
		System.out.println(obj.getClass().isAssignableFrom(String.class));
		addArray(arr);
		System.out.println();
	}

	private static void addArray(Collection<? extends Object> arr) {
			
			
	}
}
