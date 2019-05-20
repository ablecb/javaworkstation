package thread;

public class CoarseSync {
	public static String  copyString100Times(String target) {
		int i=0;
		StringBuffer buffer=new StringBuffer();
		while(i<100) {
			buffer.append(target);
		}
		return buffer.toString();
	}
}
