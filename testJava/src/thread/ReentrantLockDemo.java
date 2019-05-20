package thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable{
	private static ReentrantLock lock=new ReentrantLock();
	@Override
	public void run() {
		while(true) {
			try {
				lock.lock();
				System.out.println(Thread.currentThread().getName()+"  get lock");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
	}
	public static void main(String[] args) {
		ReentrantLockDemo demo=new ReentrantLockDemo();
		Thread  thread=new Thread(demo);
		Thread thread2=new Thread(demo);
		thread.start();
		thread2.start();
	}
}
