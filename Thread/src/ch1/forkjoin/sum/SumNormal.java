package ch1.forkjoin.sum;

/**
 * @ClassName SumNormal
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 19:22
 * @Version 1.0
 */
public class SumNormal {
    public static void main(String[] args) throws InterruptedException {
        int count=0;
        int[] src=MakeArray.makeArray();
        long start=System.currentTimeMillis();
        for(int i=0;i<src.length;i++){
          /*  Thread.currentThread().sleep(1);*/
            count=count+src[i];
        }
        System.out.println("The count is "+count+" spend time "+(System.currentTimeMillis()-start)+"ms");
    }
}
