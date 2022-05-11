// https://www.hackerrank.com/challenges/cats-and-a-mouse/problem

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        
        int q = sc.nextInt();
        
        for(int i = 0; i < q; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();   
            
            if(Math.abs(a-c) == Math.abs(b-c)){
                System.out.println("Mouse C");
            }
            if(Math.abs(a-c) < Math.abs(b-c)){
                System.out.println("Cat A");
            }
            if(Math.abs(a-c) > Math.abs(b-c)){
                System.out.println("Cat B");
            }         
        }
        
    }
}