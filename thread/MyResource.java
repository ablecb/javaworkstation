package thread;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyResource {
	private volatile boolean flag=true;
	private AtomicInteger atomicInteger=new AtomicInteger();
	private BlockingQueue<String> blockingQueue=null;
	public MyResource(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}
	public void myProd() throws Exception{
		String data=null;
		boolean retVal;
		while(flag){
			data=atomicInteger.incrementAndGet()+"";
			retVal=blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
			if(retVal){
				System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
			}else{
				System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
			}
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println(Thread.currentThread().getName()+"\t 大老板叫停了，表示FLAG=False，生产动作结束！");
	}
	public void myConsumer()throws Exception{
		String result=null;
		while(flag){
			result=blockingQueue.poll(2L, TimeUnit.SECONDS);
			if(null==result||result.equalsIgnoreCase("")){
				flag=false;
				System.out.println(Thread.currentThread().getName()+"\t 超过2s没有取到蛋糕，消费退出");
				return;
			}
			System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");

		}
	}
	public void stop()throws Exception{
		flag=false;
	}
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		int time=scanner.nextInt();
		MyResource myResource=new MyResource(new ArrayBlockingQueue<>(3));
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
			try {
				myResource.myProd();
			} catch (Exception e) {
				// TODO: handle exception
			}
		},"Prod").start();
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
			try {
				myResource.myConsumer();
			} catch (Exception e) {
				// TODO: handle exception
			}
		},"Consumer").start();
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(time+"s时间到，大老板Main线程叫停，活动结束");
		myResource.stop();
	}
}
