package day1;

public class VarableParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer l2=-12283;
		int i=-12283;
		System.out.println(i==l2);
//		System.out.println(add(1,1,2));
//		System.out.println(add(4,6));
	}
	public static int add(int ...len) {
		int sum=0;
		for(int num:len) {
			sum+=num;
		}
		/*for(int i=0;i<len.length;i++) {
			sum+=len[i];
		}*/
		return sum;
	}
}
