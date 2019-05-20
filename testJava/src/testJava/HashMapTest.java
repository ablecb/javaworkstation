package testJava;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		/*Hashtable aa=new Hashtable();
		Map map=new HashMap();
		String  a=new String("abc");
		map.put(new String("abc"), "abc");
		map.put(a, "acd");
		a=new String("bcd");
		map.remove(a);
		System.out.println(map.size());
		Thread a11=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		a11.start();*/
		HashMap map=new HashMap();
		String a=new String("abc");
		map.put(a, "abc");
		a="abc";
		map.remove(a);
		String b="abc";
		System.out.println(new String("abc").hashCode()==b.hashCode());
		System.out.println(map.size());
	}
}
