// Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.
// Note: Array A can contain duplicate elements as well.
// Input format:
// The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
// The following line contains N space separated integers, that denote the value of the elements of the array.
// Output format :
// The first and only line of output contains the count of pair of elements in the array which sum up to 0. 
// Constraints :
// 0 <= N <= 10^4
// Time Limit: 1 sec
// Sample Input 1:
// 5
// 2 1 -2 2 3
// Sample Output 1:
// 2

import java.util.*;

public class Solution {
    public static int PairSum(int[] input, int size) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<size;i++)
        {
            if(map.containsKey(input[i]))
            {
                int value = map.get(input[i]);
                value++;
                map.put(input[i],value);
            }
            else
            {
                map.put(input[i],1);
            }
        }

        int finalCount = 0;
        for(int i=0; i < size; i++)
        {
            int key = input[i];
            if(map.containsKey(-key) && map.get(key)!=0)
            {
                int times;
                if (key == (-key)) { //True in case of zero
                    int occurences = map.get(key);
                    times = (occurences * (occurences - 1)) / 2;
                    finalCount = finalCount+times;
                    map.put(key, 0);
                    continue;
                }
                times = map.get(key) * map.get(-key);
                finalCount = finalCount+times;
                map.put(key, 0);
                map.put(-key, 0);
            }
        }
        return finalCount;
    }
}
