package collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		
		Map map=new HashMap();
		String a=new String("fs");
		String result="";
		for(int i=0;i<a.length();i++) {
			result+=Integer.toBinaryString(a.charAt(i));
		}
		System.out.println(a.hashCode());
		System.out.println(result);
	}
}
