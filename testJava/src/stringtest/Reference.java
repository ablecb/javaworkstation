package stringtest;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Reference {
	public static void main(String[] args) {
		String str=new String();//强引用
		SoftReference<String> reference=new SoftReference<String>(str);//软引用
		WeakReference<String> reference2=new WeakReference<String>(str);//弱引用
		PhantomReference<String> phantomReference
		=new PhantomReference<String>(str, new ReferenceQueue<>());//虚引用
	}
}	
