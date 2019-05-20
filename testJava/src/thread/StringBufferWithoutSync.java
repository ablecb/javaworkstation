package thread;

public class StringBufferWithoutSync {
	public void add(String str1,String str2) {
		StringBuffer buffer=new StringBuffer();
		buffer.append(str1).append(str2);
	}
	public static void main(String[] args) {
		StringBufferWithoutSync bufferWithoutSync=new StringBufferWithoutSync();
		for(int i=0;i<1000;i++) {
			bufferWithoutSync.add("aaa", "bbb");
		}
		
	}
}
