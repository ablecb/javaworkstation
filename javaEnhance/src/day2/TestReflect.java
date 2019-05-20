package day2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TestReflect {
	public static void main(String[] args)throws Exception {
		new String(new StringBuffer("abc"));
		Class  cla=String.class;
		Constructor constructor=cla.getConstructor(StringBuffer.class);
		String str=(String) constructor.newInstance(new StringBuffer("abc"));
		System.out.println(str);
		System.out.println("---------------------------------------");
		ReflectPoint rp=new ReflectPoint(3,5);
		Field fieldY=rp.getClass().getField("y");		
		int y=(int) fieldY.get(rp);
		System.out.println(y);
		Field fieldX=rp.getClass().getDeclaredField("x");
		fieldX.setAccessible(true);
		System.out.println(fieldX.get(rp));
		System.out.println("----------------------------------");
		changeValue(rp);
		
		System.out.println(rp);
	}

	private static void changeValue(Object rp) throws IllegalArgumentException, IllegalAccessException {
		Field[] field=rp.getClass().getFields();
		for(Field field1:field) {
			if (field1.getType()==String.class) {
				field1.setAccessible(true);
				String old = (String) field1.get(rp);
				String newValue = old.replace('b', 'x');
				field1.set(rp, newValue);
			}
		}
	}
}
