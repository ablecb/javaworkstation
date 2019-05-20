package day2;

public class ReflectPoint {
	private int x;
	public int y;
	public ReflectPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public String str1="basketball";
	public  String str2="back";
	public String str3="bank";
	@Override
	public String toString() {
		return "ReflectPoint [x=" + x + ", y=" + y + ", str1=" + str1 + ", str2=" + str2 + ", str3=" + str3 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReflectPoint other = (ReflectPoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}
