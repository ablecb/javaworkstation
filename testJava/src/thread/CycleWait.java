package thread;

public class CycleWait implements Runnable{
	private String value;
	@Override
	public void run() {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		value="we hava data now";
	}
	public static void main(String[] args) throws Exception {
		CycleWait cycleWait=new CycleWait();
		Thread thread=new Thread(cycleWait);
		thread.start();
		/*while(cycleWait.value==null) {
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		thread.join();
		System.out.println(cycleWait.value);
	}
}
