package day6;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Vector;

public class GenericTest {
	public static void main(String[] args)  throws Exception{
		User user=new User();
		user.add(new String());
		Vector<Date> vector=new Vector<>();
		apply(vector);
	}
	public static void apply (Vector<Date> v1) throws NoSuchMethodException, SecurityException {
		Method method=GenericTest.class.getMethod("apply",Vector.class);
		Type type=method.getGenericParameterTypes()[0];
		ParameterizedType parameterizedType = (ParameterizedType)type;
		System.out.println(parameterizedType.getRawType());
		System.out.println(parameterizedType.getActualTypeArguments()[0]);
	}
}
