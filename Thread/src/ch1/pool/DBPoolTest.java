package ch1.pool;

import com.sun.javafx.sg.prism.web.NGWebView;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName DBPoolTest
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 13:19
 * @Version 1.0
 */
public class DBPoolTest {
    static DBPool pool= new DBPool(10);
    static CountDownLatch end;

    public static void main(String[] args)throws  Exception {
        int threadCount=50;
        end=new CountDownLatch(threadCount);
        int count=20;
        AtomicInteger got=new AtomicInteger();
        AtomicInteger notGot=new AtomicInteger();
        for(int i=0;i<threadCount;i++){
            Thread thread=new Thread(new Work(count,got,notGot),"Worker"+i);
            thread.start();
        }
        end.await();
        System.out.println("总共尝试了："+(threadCount*count));
        System.out.println("拿到连接的次数："+got);
        System.out.println("没能拿到连接的次数："+notGot);
    }
    static  class Work implements  Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public Work(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
           while(count>0){
               try {
                   Connection connection=pool.fetchConn(1000);
                   if(connection!=null){
                       try {
                           connection.createStatement();
                           connection.commit();
                       }finally {
                            pool.relaseConn(connection);
                            got.incrementAndGet();
                       }
                   }else{
                       notGot.incrementAndGet();
                       System.out.println(Thread.currentThread().getName()+"等待超时!");
                   }

               }catch (Exception e){

               }finally {
                    count--;
               }

           }
           end.countDown();
        }
    }
}
