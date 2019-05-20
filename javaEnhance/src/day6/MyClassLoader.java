package day6;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class MyClassLoader extends ClassLoader{
	public MyClassLoader(String string) {
		
	}
	public static void main(String[] args) throws Exception{
		System.out.println("aaaa");
		/*System.out.println(MyClassLoader.class.getClassLoader().getClass().getName());*/
		/*String srcPath=args[0];
		String destPath=args[1];
		FileInputStream fis=new FileInputStream(srcPath);
		FileOutputStream fos=new FileOutputStream(destPath);
		cypher(fis,fos);
		fis.close();
		fos.close();*/
		/*MyClassLoaderAttachment m=new MyClassLoaderAttachment();
		System.out.println(m);*/
		Class clazz=new MyClassLoader("config").loadClass("MyClassLoaderAttachment");
		Date date=(Date) clazz.newInstance();
		System.out.println(date);
	}
	private static void cypher(InputStream ips,OutputStream ops) throws Exception {
		int b=0;
		while((b=ips.read())!=-1) {
			ops.write(b ^ 0xff);
		}
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		System.out.println("1111111111111111111111111111");
		String classFileName="G:\\javaworkstation\\javaEnhance\\config\\MyClassLoaderAttachment.class";
		try {
			FileInputStream fis=new FileInputStream(classFileName);
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			cypher(fis,bos);
			fis.close();
			byte[] bytes=bos.toByteArray();
			return defineClass(bytes,0,bytes.length);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return super.findClass(name);
	}
}
