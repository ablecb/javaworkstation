package day6.aopframework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import day6.Advice;

public class ProxyFactoryBean {
	private Advice advice;
	private Object target;
	
	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object getProxy() {
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
