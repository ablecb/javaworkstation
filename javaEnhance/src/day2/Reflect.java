package day2;

public class Reflect {

	public static void main(String[] args)throws Exception {
		String str="abc";
		Class<String> str1=String.class;
		Class str2=str.getClass();
		Class str3=Class.forName("java.lang.String");
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str1.isPrimitive());
		System.out.println(int.class.isPrimitive());
		str3.getConstructor(StringBuffer.class);
	}

}
