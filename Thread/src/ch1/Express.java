package ch1;

/**
 * @ClassName Express
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 10:22
 * @Version 1.0
 */
public class Express {
    public final static  String city="ShangHai";
    private  int km;
    private  String site;
    public Express(){

    };

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }
    public synchronized void changeKm(){
        this.km=101;
        notify();
    };
    public synchronized void changeSite(){
        this.site="BeiJing";
        notifyAll();
    };
    public synchronized void waitKm(){
        while(this.km<=100){
            try {
                wait();
                System.out.println("check km thread ["+Thread.currentThread().getId()+"] is be notify");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the km is"+this.km+",I will change db");
    };
    public synchronized void waitSite(){
        while(this.site.equals(city)){
            try {
                wait();
                System.out.println("check site thread ["+Thread.currentThread().getId()+"] is be notify");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the site is"+this.site+",I will change db");
    };
}
