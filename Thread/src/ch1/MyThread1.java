package ch1;

/**
 * @ClassName MyThread1
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 10:46
 * @Version 1.0
 */
public class MyThread1 extends Thread{
    private  WaitAndNotify waitAndNotify;
    MyThread1(WaitAndNotify waitAndNotify){
        this.waitAndNotify=waitAndNotify;
    }
    @Override
    public void run() {
        try {
            waitAndNotify.add();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
