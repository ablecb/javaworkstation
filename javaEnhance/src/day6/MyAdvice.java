package day6;

import java.lang.reflect.Method;

public class MyAdvice implements Advice{
	Long beginTime;
	public void beforeMethod(Method method) {
		System.out.println("开始啦");
		beginTime=System.currentTimeMillis();
		
	}

	public void afterMethod(Method method) {
		Long endTime=System.currentTimeMillis();
		System.out.println(method.getName()+(endTime-beginTime));
		System.out.println("结束了");
	}
	
}
