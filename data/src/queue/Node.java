package queue;

public class Node {
	int data;
	Node next;
	public void setNext(Node next) {
		this.next=next;
	}
	public void setData(int data) {
		this.data=data;
	}
	public int getData() {
		return data;
	}
	public Node getNext() {
		return next;
	}
}
