package gc;

public class Finalization {
	public  static Finalization finalization;
	
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalized");
		finalization=this;
	}
	public static void main(String[] args) {
		Finalization finalization=new Finalization();
		System.out.println("First  "+finalization);
		System.out.println(finalization.finalization);
		System.out.println("--------------------------");
		finalization=null;
		System.gc();
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Second   "+finalization);
		System.out.println(finalization.finalization);
	}
	
}
