package ch1;

/**
 * @ClassName WaitAndNotify
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 10:37
 * @Version 1.0
 */
public class WaitAndNotify {
    int i=0;
    public  synchronized void  add() throws InterruptedException {
        while (true){
            i++;
            Thread.currentThread().sleep(100);
            System.out.println(i);
            if (i>20){

                notify();
                wait();
            }
        }



    }
    public synchronized  void dec() throws InterruptedException {
        while(true){
            if(i<20){
                wait();
            }else {
                i=i-20;
                notify();
            }
        }

    }
}
