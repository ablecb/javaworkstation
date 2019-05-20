package atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

import annoations.NotThreadSafe;
import annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
@ThreadSafe
@Slf4j
public class AtomicExample3 {
	public static int clientTotal =5000;
	public static int threadTotal=200;
	public static LongAdder count=new LongAdder();
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
		count.increment();
		//System.out.println(count);
		//count.getAndIncrement();
	}
}
