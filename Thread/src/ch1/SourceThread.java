package ch1;

/**
 * @ClassName SourceThread
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 10:42
 * @Version 1.0
 */
public class SourceThread {
    public static void main(String[] args) {
        WaitAndNotify waitAndNotify=new WaitAndNotify();
        MyThread1 myThread1=new MyThread1(waitAndNotify);
        MyThread2 myThread2=new MyThread2(waitAndNotify);

        //myThread2.start();
        //myThread1.start();
    }
}
