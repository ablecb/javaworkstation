package day6;

import java.net.URI;
import java.net.URL;

public class ClassLoaderTest {
	//已经导出jar 到 ext
	public static void main(String[] args) {
		/*String ext=ClassLoaderTest.class.getClassLoader().getParent().getClass().getName();
		System.out.println(ext);
		ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();
		while(classLoader!=null) {
			System.out.println(classLoader.getClass().getName());
			classLoader=classLoader.getParent();
		}
		System.out.println(classLoader.getClass().getName());*/
		//System.out.println(System.class.getClassLoader());
		//获取java path的 绝对路径 
		//System.out.println(System.getProperty("java.class.path"));
		ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();
		while(classLoader!=null) {
			System.out.println(classLoader.getClass().getName());
			classLoader=classLoader.getParent();
		}
		System.out.println(classLoader);
	}
}
