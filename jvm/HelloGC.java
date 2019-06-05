package jvm;

public class HelloGC {
	public static void main(String[] args) throws InterruptedException {
		/*System.out.println("hello gc");
		Thread.sleep(Integer.MAX_VALUE);*/
		long totalMemory =Runtime.getRuntime().totalMemory();
		long maxMemory=Runtime.getRuntime().maxMemory();
		System.out.println("TOTAL_MEMORY(-Xms)="+totalMemory+"(字节)"+(totalMemory/1024/1024)+"MB");
		System.out.println("MAX_MEMORY(-Xmx)="+maxMemory+"(字节)"+(maxMemory/1024/1024)+"MB");
	}
}
