package Array;

import Array.util.MyArray;

public class TestMyArray {
	public static void main(String[] args) {
		MyArray my=new MyArray();
		my.insert(21123);
		my.insert("hello");
		my.insert("hello1");
		my.insert("hello2");
		my.insert("hello3");
		my.show();
		my.insert("fds", 0);
		my.show();
		my.set("nihao", 0);
		my.show();
	}
}
