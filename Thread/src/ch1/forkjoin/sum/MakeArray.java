package ch1.forkjoin.sum;

import java.util.Random;

/**
 * @ClassName MakeArray
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/13 19:18
 * @Version 1.0
 */
public class MakeArray {
    public static final int ARRAY_LENGTH=100000000;
    public static int[] makeArray(){
        Random random = new Random();
        int [] result=new int[ARRAY_LENGTH];
        for(int i=0;i<ARRAY_LENGTH;i++){
            result[i]=random.nextInt(ARRAY_LENGTH*3);
        }
        return result;
    }
}
