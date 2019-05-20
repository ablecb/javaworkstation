package Array;

public class LinkList {
	private Link first;
	public LinkList() {
		first=null;
	}
	public  void insertFirst(Link link) {
		link.next=first;
		first=link;
	}
}
