package day2;

import java.lang.reflect.Method;

public class ReflectTest2 {
	public static void main(String[] args) throws Exception, SecurityException {
		Method method=String.class.getMethod("charAt", int.class);
		String str="abc";
		System.out.println(method.invoke(str, 1));
		String startingClassName=args[0];
		Method method1=Class.forName(startingClassName).getMethod("main",String[].class);
		method1.invoke(null, (Object)new String[]{"111","222"});
	}
}
