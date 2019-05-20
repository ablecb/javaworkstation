package publish;

import annoations.NotRecommend;
import annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
	private int thisCanBeEscape=0;
	public Escape() {
		new InnerClass();
	}
	private class InnerClass {
		public InnerClass() {
			System.out.println(Escape.this.thisCanBeEscape);
		}
	}
	public static void main(String[] args) {
		new Escape();
	}
}
