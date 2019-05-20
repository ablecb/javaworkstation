package ch1;

/**
 * @ClassName MyThread2
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 10:48
 * @Version 1.0
 */
public class MyThread2 extends Thread{
    private WaitAndNotify waitAndNotify ;
    MyThread2(WaitAndNotify waitAndNotify){
        this.waitAndNotify=waitAndNotify;
    }
    @Override
    public void run() {
        try {
            waitAndNotify.dec();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
