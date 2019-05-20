package ch1.volatileTest;

/**
 * @ClassName VolatileDemo
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 22:54
 * @Version 1.0
 */
public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        Resource resource=new Resource();
       /* Thread t1=new Thread(new SetNumberThread(resource),"A线程");
        t1.start();*/
        Thread.currentThread().sleep(100);
        Thread t2=new Thread(new GetNumberThread(resource),"B线程");
        Thread t3=new Thread(new GetNumberThread(resource),"C线程");
        t2.start();
        t3.start();
    }
}
