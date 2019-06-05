package thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class KingLock implements Lock {

    //线程的原子操作类
    AtomicReference<Thread> owner = new AtomicReference<>();

    //如果有的线程抢不到，就放入等待队列
    public LinkedBlockingQueue<Thread> waiters = new LinkedBlockingQueue<>();

    @Override
    public void lock() {
        //多个线程同时调用
        while (!owner.compareAndSet(null, Thread.currentThread())) {//如果不成功
            waiters.add(Thread.currentThread());//加入等待队列
            //Thread.currentThread().wait();//不能使用，wait()方法需要synchronized关键字
            LockSupport.park();//让当前线程等待
            //取巧的方式：如果能执行到本行的话，说明这个线程被唤醒了，可以从等待队列中删除了
            waiters.remove(Thread.currentThread());
        }
    }

    @Override
    public void unlock() {
        //多个线程同时解锁
        if (owner.compareAndSet(Thread.currentThread(), null)) {//判断当前线程是不是owner
            //释放锁
            Object[] objects = waiters.toArray();//等待队列转化为数组
            System.out.println(objects.length);
            for (Object object : objects) {//唤醒等待队列中所有的线程
                Thread thread = (Thread) object;
                LockSupport.unpark(thread);
            }
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean tryLock() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Condition newCondition() {
        // TODO Auto-generated method stub
        return null;
    }

}
//测试
//启动10个线程，每个线程执行10000次incr()操作。


