package testJava;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
	static int a=0;
	
	public static void main(String[] args) throws Exception {
		Lock lock=new ReentrantLock();
		//BlockingQueue queue=new ArrayBlockingQueue<>(1);
		//Semaphore se=new Semaphore(1);
		for(int i=0;i<2;i++) {
			Thread t1=new Thread(new Runnable() {
				
				public void run() {
					for(int i=0;i<100000;i++)
						try {
							lock.lock();
							//queue.put("1");
							//se.acquire();
							a++;
							lock.unlock();
							//se.release();
							//queue.take();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
				}
			});
			t1.start();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(a);
	}
}
