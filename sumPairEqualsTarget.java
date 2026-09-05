import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15, 3, 6};
        int target = 9;
        for (int i=0;i<numbers.length ; i++) {
            for (int j=i+1;j<numbers.length;j++ ) {

                if(numbers[i]+numbers[j]==target){
    System.out.println(numbers[i]+ "+"+numbers[j]+"="+target);
                }
                
            }
            
        }
}
}
