package Array;

public class Queue {
	private int [] queArray;
	private int maxSize;
	public  int front;
	public int rear;
	private int length;
	public Queue(int maxSize) {
		this.maxSize=maxSize;
		queArray=new int[maxSize];
		front =0;
		rear=-1;
		length=0;
	}
	public void insert(int elem)throws Exception{
		if(isFull()) {
			throw new Exception("队列已经满了");
		}
		if(rear==maxSize-1) {
			rear=-1;
		}
		queArray[++rear]=elem;
		length++;
	}
	public int  remove()throws Exception{
		if(isEmpty()) {
			throw new Exception("队列为空不能进行移除操作");
		}
		int ele=queArray[front++];
		if(front==maxSize) {
			front=0;
		}
		length--;
		return ele;
	}
	public int peek()throws Exception{
		if(isEmpty()) {
			throw new Exception("队列中没有元素");
		}
		return queArray[front];
	}
	public boolean isEmpty() {
		return (length==0);
	}
	public boolean isFull() {
		return (length==maxSize);
	}
	public int size() {
		return length;
	}
}
