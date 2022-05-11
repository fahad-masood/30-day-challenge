// https://www.hackerrank.com/challenges/electronics-shop/problem

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> keyboard = new ArrayList<Integer>();
        List<Integer> usb = new ArrayList<Integer>();
                
        for(int i = 0; i<n; i++){
            keyboard.add(sc.nextInt());     
        }
        for(int i = 0; i<m; i++){
            usb.add(sc.nextInt()); 
        }
        int max = -1;
        for(int i = 0; i < keyboard.size(); i++){
            for(int j = 0; j< usb.size(); j++){
                if(keyboard.get(i) + usb.get(j) > max && keyboard.get(i) + usb.get(j) <= b){
                    max = keyboard.get(i) + usb.get(j);
                }
            }
        }
        System.out.println(max);
    }
}