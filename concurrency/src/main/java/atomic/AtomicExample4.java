package atomic;

import java.util.concurrent.atomic.AtomicReference;

import annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;
@ThreadSafe
@Slf4j
public class AtomicExample4 {
	
	public static AtomicReference<Integer> count=new AtomicReference<Integer>(0);
	
	public static void main(String[] args)  {
		count.compareAndSet(0,1);
		count.compareAndSet(0,2);
		count.compareAndSet(2,3);
		count.compareAndSet(1,2);
		System.out.println(count.get());
	}
	
}
