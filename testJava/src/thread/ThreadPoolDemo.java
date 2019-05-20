package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService newCachedThreadPool=Executors.newCachedThreadPool();
		Future future=newCachedThreadPool.submit(new MyCallable());
		if(!future.isDone()) {
			System.out.println("task has not finish ,please wait ");
		}
		System.out.println(future.get());
	}
}
