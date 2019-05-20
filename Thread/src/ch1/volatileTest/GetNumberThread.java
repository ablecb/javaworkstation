package ch1.volatileTest;

/**
 * @ClassName GetNumberThread
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 22:52
 * @Version 1.0
 */
public class GetNumberThread implements Runnable{
    private Resource resource;
    public GetNumberThread(Resource resource){
        this.resource=resource;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"get Number:");
    }
}
