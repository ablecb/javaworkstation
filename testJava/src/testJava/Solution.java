package testJava;
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
         ArrayList<Integer> a=new ArrayList<Integer>();
           for(int i=0;i<array.length;i++){
               for(int j=i+1;j<array.length;j++){
                   if(array[i]+array[j]==sum){
                       //System.out.println(array[i]*array[j]);
                      
                       a.add(array[i]);
                       a.add(array[j]);
                       return a;
                   }
               }
           }
		return a;
    }
}