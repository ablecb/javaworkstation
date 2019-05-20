package collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SafaHashMapDemo {
	public static void main(String[] args) {
		HashMap map=new HashMap<>();
		ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap<>();
		
		Map table=new Hashtable<>();
		Map  safeMap=Collections.synchronizedMap(map);
		safeMap.put("fdsjk", 123);
	}
}	
