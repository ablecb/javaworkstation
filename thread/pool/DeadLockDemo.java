package thread.pool;

public class DeadLockDemo implements Runnable{
	private String lockA;
	private String lockB;
	public DeadLockDemo(String lockA, String lockB) {
		super();
		this.lockA = lockA;
		this.lockB = lockB;
	}
	public void run(){
		synchronized (lockA) {
			System.out.println(Thread.currentThread().getName()+"尝试获取"+lockA);
			synchronized (lockB) {
				System.out.println(Thread.currentThread().getName()+"尝试获取"+lockB);
			}
		}
	}
	public static void main(String[] args) {
		String  lockA="lockAAA";
		String lockB ="lockBBB";
		Thread t1=new Thread(new DeadLockDemo(lockA, lockB),lockA);
		Thread t2=new Thread(new DeadLockDemo(lockB, lockA),lockB);
		t1.start();
		t2.start();
	}
}
