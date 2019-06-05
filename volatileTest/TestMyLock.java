package volatileTest;

import java.util.concurrent.locks.Lock;

import thread.KingLock;

public class TestMyLock {
    int i = 0;
    int j = 0;
    Lock lock = new KingLock();

    public void incr() {
        lock.lock();
        try {
            i++;
            j++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestMyLock demo = new TestMyLock();
        for (int k = 0; k < 10; k++) {
            new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    demo.incr();
                }
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(demo.i);
        System.out.println(demo.j);
    }
}