package day2;

public class EnumTest {
	public static void main(String[] args) {
		Weekday1 weekday=Weekday1.SUN;
		System.out.println(weekday.nextDay());
		
		Weekday2 day=Weekday2.MON;
		System.out.println(day.name());
		System.out.println(day.ordinal());
		System.out.println(Weekday2.valueOf("SUN"));
		System.out.println(Weekday2.values().length);
		
	}
	public enum Weekday2{
		SUN(1),MON,TUE,WON,THR,FRI,SAT;
		private Weekday2() {
			System.out.println("无参构造");
		};
		private Weekday2(int i) {
			System.out.println("有参构造");
		}
	}
}
