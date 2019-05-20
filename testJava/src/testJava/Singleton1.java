package testJava;

public class Singleton1 {
	private Singleton1() {
		
	};
	private Singleton1 example;
	public Singleton1 getInstance() {
		if(example==null) {
			example=new Singleton1();
		}
		return example;
	}
}
