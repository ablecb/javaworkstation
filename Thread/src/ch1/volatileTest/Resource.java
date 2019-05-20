package ch1.volatileTest;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @ClassName Resource
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 22:47
 * @Version 1.0
 */
public class Resource {
    public int number=0;
    public  void setNumber(int number){
        this.number=number;
    }


    public static void main(String[] args) throws InterruptedException {
        Resource resource=new Resource();
        Thread thread=new Thread(()->{
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.setNumber(16);
        });
        thread.start();
        Thread thread1=new Thread(()->{
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程"+ Thread.currentThread().getId()+"get value is:"+resource.number);
        });
        thread1.start();
    }
}
