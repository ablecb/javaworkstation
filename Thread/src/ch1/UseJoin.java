package ch1;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName UseJoin
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 14:13
 * @Version 1.0
 */
public class UseJoin {
    static  class  JumpQueue implements  Runnable{
        private  Thread thread;

        public JumpQueue(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"terminate");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread previous =Thread.currentThread();
        for(int i=0;i<10;i++){
            Thread thread=new Thread(new JumpQueue(previous),String.valueOf(i));
            System.out.println(previous.getName()+" jump a queue the thread :");
            thread.start();
            previous=thread;
        }
        Thread.currentThread().sleep(2000);
        System.out.println(Thread.currentThread().getName()+"terminate.");
    }
}
