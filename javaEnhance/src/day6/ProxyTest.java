package day6;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

public class ProxyTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazzProxy1=Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
		System.out.println(clazzProxy1.getName());
		System.out.println("---------------start Constructor--------------------");
		Constructor[] constructs = clazzProxy1.getConstructors();
		for(Constructor construct:constructs) {
			String name=construct.getName();
			StringBuilder sBuilder=new StringBuilder(name);
			sBuilder.append('(');
			Class[] clazzParams=construct.getParameterTypes();
			for(Class clazzParam:clazzParams) {
				sBuilder.append(clazzParam.getName()).append(',');
			}
			if(clazzParams.length!=0)
				sBuilder.deleteCharAt(sBuilder.length()-1);
			sBuilder.append(')');
			System.out.println(sBuilder);
		}
		System.out.println("--------------start Method-------------------");
		Method[] methods = clazzProxy1.getMethods();
		for(Method method:methods) {
			String name=method.getName();
			StringBuilder sBuilder=new StringBuilder(name);
			sBuilder.append('(');
			Class[] clazzParams=method.getParameterTypes();
			for(Class clazzParam:clazzParams) {
				sBuilder.append(clazzParam.getName()).append(',');
			}
			if(clazzParams.length!=0)
				sBuilder.deleteCharAt(sBuilder.length()-1);
			sBuilder.append(')');
			System.out.println(sBuilder);
		}
		System.out.println("-------------------------create instance-----------------------");
		Constructor constructor =clazzProxy1.getConstructor(InvocationHandler.class);
		class MyInvocationHandler implements InvocationHandler{

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
			
		}
		Collection proxy1=(Collection)constructor.newInstance(new MyInvocationHandler());
		System.out.println(proxy1);
		proxy1.clear();
		//proxy1.isEmpty();
		Collection proxy2=(Collection)constructor.newInstance(new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		ArrayList target=new ArrayList<>();
		Collection proxy3 = (Collection) getProxy(target,new MyAdvice());
		proxy3.add("hello");
		proxy3.add("world");
		proxy3.add("!");
		System.out.println(proxy3.size());
	}

	private static Object getProxy(Object target,Advice advice) {
		Object proxy3 = Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						/*Long beginTime=System.currentTimeMillis();
						Object retVal=method.invoke(target, args);
						Long endTime=System.currentTimeMillis();
						System.out.println(method+" run "+(endTime-beginTime));
						return retVal;*/
						advice.beforeMethod(method);
						Object retVal=method.invoke(target, args);
						advice.afterMethod(method);
						return retVal;
					}
				});
		return proxy3;
	}
}
