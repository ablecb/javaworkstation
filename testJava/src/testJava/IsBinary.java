package testJava;

import java.util.Scanner;

public class IsBinary {
	public static void main(String[] args) {
		Scanner num=new Scanner(System.in);
		while (true) {
			int number = num.nextInt();
			int result = IsBinary.anotherIs2Power(number);
			System.out.println(result);
		}
	}
	static int anotherIs2Power(int num) {  
        if(num < 2)  
            return -1;  
          
        if((num & num - 1) == 0 )  
            return 1;  
        else  
            return -1;  
    }
	
}
