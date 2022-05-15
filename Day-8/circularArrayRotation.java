// https://www.hackerrank.com/challenges/circular-array-rotation/problem

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
     * Complete the 'circularArrayRotation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     *  3. INTEGER_ARRAY queries
     */

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
    // Write your code here
    
    List <Integer> ans = new ArrayList<Integer>();
    List <Integer> temp = new ArrayList<Integer>();
    
    // We make a duplicate list temp so that after rotation, when the value is fetched from the integer list, it gives us the old value and not the updated one as we are using a.set(index, element) method.
    
    for(int i=0; i<a.size(); i++) {
        temp.add(a.get(i));
    }
    
    // temp.get(i) instead of a.get(i) because if we use a.set(3, a.get(3)), it would have given the updated value of a.get(3) instead of the old one and we have to swap it with the old value not the new one.
    for(int i=0; i<a.size(); i++) {
        // Swap the value directly after k rotations
        a.set((i+k) % a.size(), temp.get(i));
    }
    
    for(int i = 0; i < queries.size(); i++){
        ans.add(a.get(queries.get(i)));
    }
    return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        int q = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.circularArrayRotation(a, k, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
