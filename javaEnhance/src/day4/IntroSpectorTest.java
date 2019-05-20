package day4;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class IntroSpectorTest {
	public static void main(String[] args)throws Exception {
		ReflectPoint point=new ReflectPoint(3, 5);
		String x="x";
		Object xVal = getVal(point, x);
		System.out.println(xVal);
		int value=10;
		setVal(point, x, value);
		System.out.println(getVal(point, x));
	}

	private static void setVal(ReflectPoint point, String x, int value)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd=new PropertyDescriptor(x,point.getClass());
		Method setX=pd.getWriteMethod();
		setX.invoke(point, value);
	}

	private static Object getVal(ReflectPoint point, String x)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd=new PropertyDescriptor(x,point.getClass());
		BeanInfo beanInfo=Introspector.getBeanInfo(point.getClass());
		PropertyDescriptor[] methods = beanInfo.getPropertyDescriptors();
		Object xVal=null;
		for(PropertyDescriptor pd1:methods) {
			if(pd1.getName().equals(x)) {
				Method getX=pd.getReadMethod();
				xVal=getX.invoke(point);
			}
		}
		
		
		return xVal;
	}
}

















