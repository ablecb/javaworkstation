package count;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
@NotThreadSafe
@Slf4j
public class CountExample {
	public static int clientTotal =5000;
	public static int threadTotal=200;
	public static int count=0;
	public static void main(String[] args) throws Exception {
		ExecutorService executorService=Executors.newCachedThreadPool();
		final Semaphore semaphore=new Semaphore(threadTotal);
		final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
		for(int i=0;i<clientTotal;i++) {
			executorService.execute(()->{
				try {
					semaphore.acquire();
					add();
					semaphore.release();
				} catch (Exception e) {
					e.printStackTrace();
				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		System.out.println(count);
	}
	private  static void  add() {
		++count;
		//System.out.println(count);
	}
}
