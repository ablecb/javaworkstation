package atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

import annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
@ThreadSafe
@Slf4j
public class AtomicExample6 {
	
	public static AtomicBoolean isHappened=new AtomicBoolean(false);
	public static int clientNum =5000;
	public static int threadNum=200;
	public static void main(String[] args)  {
		System.out.println(isHappened.get());
		ExecutorService exec=Executors.newCachedThreadPool();
		Semaphore semaphore=new Semaphore(threadNum);
		CountDownLatch cdl=new CountDownLatch(0);
		for(int i=0;i<clientNum;i++) {
			try {
				semaphore.acquire();
				test();
				semaphore.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(isHappened.get());
	}
	private static void test() {
		if(isHappened.compareAndSet(false, true)) {
			System.out.println("hello");
		}
	}
}