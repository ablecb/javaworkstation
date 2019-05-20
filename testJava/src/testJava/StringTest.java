package testJava;

public class StringTest {
	public static void main(String[] args) {
		String a="abc";
		String b=a+"d";
		String aa=new String("abc");
		String a1=String.valueOf(aa);
		System.out.println(a1==a);
	}
}
