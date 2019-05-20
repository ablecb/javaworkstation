package atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

import annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
@ThreadSafe
@Slf4j
public class AtomicExample5 {
	
	private static AtomicIntegerFieldUpdater<AtomicExample5>
	updater=AtomicIntegerFieldUpdater.newUpdater
	
	(AtomicExample5.class, "count");
	@Getter
	public volatile int count=100;
	
	public static void main(String[] args)  {
		AtomicExample5 example5=new AtomicExample5();
		if(updater.compareAndSet(example5, 100, 120)) {
			System.out.println("update success1");
		}
		if(updater.compareAndSet(example5, 100, 120)) {
			System.out.println("update success2");
		}else {
			System.out.println("update failed");
		}
	}
	
}
