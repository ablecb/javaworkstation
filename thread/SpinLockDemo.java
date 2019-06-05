package thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
	static int num=0;
	AtomicReference<Thread> atomicReference=new AtomicReference<Thread>();
	public void Lock(){
		Thread thread=Thread.currentThread();
		while(!atomicReference.compareAndSet(null, thread)){
			
		}
	}
	public void unLock(){
		Thread thread=Thread.currentThread();
		atomicReference.compareAndSet(thread, null);
	}
	
	public static void main(String[] args) throws Exception {
		
		SpinLockDemo demo=new SpinLockDemo();
		for(int i=0;i<10;i++){
			new Thread(()->{
				//demo.Lock();
				for(int j=0;j<500;j++){
					num++;
				}
				//demo.unLock();
			}).start();
		}
		Thread.currentThread().sleep(1000);
		System.out.println(num);
	}
}
