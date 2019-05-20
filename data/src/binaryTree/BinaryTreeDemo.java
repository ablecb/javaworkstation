package binaryTree;

public class BinaryTreeDemo {
	public static void main(String[] args) {
		int[] a= {3,1,0,2,7,5,8,9};
		BinaryTree bt=new BinaryTree();
		for(int i=0;i<a.length;i++) {
			bt.add(a[i]);
		}
	}
}
