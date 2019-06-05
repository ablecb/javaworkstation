package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("Callable");
		return 1024;
	}
	
}
public class CallableDemo {
	public static void main(String[] args) throws Exception {
		FutureTask<Integer> futureTask=new FutureTask<>(new MyThread());
		Thread t1=new Thread(futureTask,"aa");
		Thread t2=new Thread(futureTask,"bb");
		t1.start();
		System.out.println(futureTask.get());
	}
}
