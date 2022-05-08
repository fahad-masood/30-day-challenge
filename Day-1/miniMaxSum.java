// https://www.hackerrank.com/challenges/mini-max-sum/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        long min = arr.get(0);
        long max = min;
        long sum = min;
        
        for(int i = 1; i < 5; i++){
            sum += arr.get(i);
            
            if(arr.get(i) < min){
                min = arr.get(i); // Find the minimum element of array
            }
            if(arr.get(i) > max){
                max = arr.get(i); // Find the maximum element of array
            }
        }
        
        // Min sum = total sum - max element
        // Max sum = total sum - min element
        System.out.println((sum-max) + " " + (sum-min));
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
