package ch1.volatileTest;

/**
 * @ClassName SetNumberThread
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 22:50
 * @Version 1.0
 */
public class SetNumberThread implements Runnable{
    private Resource resource;
    public SetNumberThread(Resource resource){
        this.resource=resource;
    }
    @Override
    public void run() {
        resource.setNumber(99);
    }
}
