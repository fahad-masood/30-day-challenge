// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
        List<Integer> rank = new ArrayList<Integer>();
        List<Integer> climbingLeaderboard = new ArrayList<Integer>();
        int count = 1;
        rank.add(count);
        
        for(int i = 1; i < ranked.size(); i++){
            if(ranked.get(i) < ranked.get(i-1)){
                count++;
                rank.add(count);
            } else {
                rank.add(count);            
            }
        }
        
        for(int i = 0; i < player.size(); i++){
            if(player.get(i) >= ranked.get(0)){
                climbingLeaderboard.add(1);
            }
            else if(player.get(i) == ranked.get(ranked.size()-1)){
                climbingLeaderboard.add(rank.get(rank.size() - 1));
            }
            else if(player.get(i) < ranked.get(ranked.size()-1)){
                climbingLeaderboard.add(rank.get(rank.size() - 1) + 1);
            }
            else{
                int index = binarySearch(ranked, player.get(i));
                climbingLeaderboard.add(rank.get(index));
            }
        }
        return climbingLeaderboard;
    }
    
    public static int binarySearch(List<Integer> a, int key){
        int start = 0;
        int end = a.size() - 1;
        
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(a.get(mid) == key){
                return mid;
            }
            else if(a.get(mid) < key && key < a.get(mid - 1)){
                return mid;
            }
            else if(a.get(mid) > key && key >= a.get(mid + 1)){
                return mid + 1;
            }
            else if(a.get(mid) > key){
                start = mid + 1;
            }
            else if(a.get(mid) < key){
                end = mid - 1;
            }
        }
        return -1;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

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
