package testJava;

public class Main {
	static int num=0;
	public static void main(String[] args) {
	
		Runnable r=new Runnable() {
			public void run() {
				for(int i=0;i<500;i++) {
					num++;
					System.out.println(Thread.currentThread().getName()+"   "+num);
				}
			}
		};
		Thread t=new Thread(r);
		Thread t1=new Thread(r);
		t.start();
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num);
	}
}
