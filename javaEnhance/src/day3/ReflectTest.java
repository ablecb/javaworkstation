package day3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

import day2.ReflectPoint;

public class ReflectTest {

	public static void main(String[] args)throws Exception {
		InputStream is=new FileInputStream("config.properties");
		Properties properties=new Properties();
		properties.load(is);
		is.close();
		String className=properties.getProperty("className");
		Collection collection=(Collection)Class.forName(className).newInstance();
		//Collection collection=new HashSet();
		ReflectPoint pt=new ReflectPoint(5, 5);
		ReflectPoint pt1=new ReflectPoint(3, 3);
		ReflectPoint pt2=new ReflectPoint(3, 4);
		ReflectPoint pt3=new ReflectPoint(3, 500);
		collection.add(pt);
		collection.add(pt2);
		collection.add(pt3);
		collection.add(pt1);
		collection.add(pt);
		System.out.println(collection.toString());
		collection.add(pt);
		pt.y=100;
		collection.remove(pt);
		//内存泄漏 删不掉
		System.out.println(collection.size());
	}

}
