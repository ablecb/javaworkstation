package queue;

public class TestMyQueue {

	public static void main(String[] args) {
		
		MyQueue mq=new MyQueue();
		mq.add("nihap");
		mq.add("nihap1");
		mq.add("nihap2");
		mq.add("nihap3");
		System.out.println(mq.poll());
		System.out.println(mq.poll());
	}

}
