package thread;

public class ThreadTest {
	private static void attack() {
		System.out.println("Fight");
		System.out.println("Current Thread is  :"+Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		String[] arg=new String[1];
		arg[0]="afd";
		SyncBlockAndMethod.main(arg);
		Thread  t=new Thread() {
			@Override
			public void run() {
				attack();
			}
		};
		t.run();
		System.out.println("Current main thread is  "+Thread.currentThread().getName());
		System.out.println("-------------------------");
		t.start();
		
	}
}
