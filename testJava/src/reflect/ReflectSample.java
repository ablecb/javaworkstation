package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectSample {
	public static void main(String[] args) throws Exception{
		Class clazz=Class.forName("reflect.Robot");
		Robot robot=(Robot)clazz.newInstance();
		Field field=clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(robot, "曹博");
		System.out.print(field.getName()+":");
		System.out.println(field.get(robot));
		
		Method method=clazz.getDeclaredMethod("sayHi",String.class);
		method.invoke(robot, "你好");
		Method methodHello=clazz.getDeclaredMethod("throwHello",String.class);
		Object obj=methodHello.invoke(robot, "able");
		System.out.println(obj);
		
	}
}
