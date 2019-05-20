package reflect;



public class Fibooacci {
	static int [] arr=new int[100];
	public static int fibooacci(int n) {
		if(n==1) {
			return 0;
		}
		if(n==2) {
			return 1;
		}
		arr[n - 1] = fibooacci(n-1);
		arr[n - 2] = fibooacci(n - 2);
		return arr[n - 1] + arr[n - 2];
	}
	public static void main(String[] args) {
		System.out.println(fibooacci(1000000));
	}
}
