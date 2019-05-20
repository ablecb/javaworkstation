package ch1;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 * @ClassName WaitOut
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 12:23
 * @Version 1.0
 */
public class WaitOut extends  Thread{
    @Override
    public void run() {
        try {
            long time=System.currentTimeMillis()+5000;
            Thread.currentThread().wait(time);
            System.out.println("你好");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WaitOut waitOut=new WaitOut();
        waitOut.start();
        System.out.println("执行完毕");

    }
}
