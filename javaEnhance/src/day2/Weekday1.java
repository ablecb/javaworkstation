package day2;

/**
 * @author 曹博
 *
 */
public abstract class Weekday1 {
	private Weekday1() {
		
	}
	public static final Weekday1 SUN=new Weekday1() {
		public Weekday1 nextDay() {
			return MON;
		}
	};
	public static final Weekday1 MON=new Weekday1() {
		public Weekday1 nextDay() {
			return SUN;
		}
	};
	abstract Weekday1 nextDay();
	
	/*public Weekday nextDay() {
		if(this==SUN) {
			return MON;
		}else {
			return SUN;
		}
	}*/


	@Override
	public String toString() {
		return this==SUN?"sun":"mon";
	}
	
	
}
