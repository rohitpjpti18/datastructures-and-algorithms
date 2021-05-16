package algorithms.dynamicprogramming;

import java.util.*;
import java.lang.*;

public class MaximumPartition {
    public static long getSum(Vector<Long> arr){
        long sum = 0;
        for(long i = 0; i<arr.size(); i++){
            sum += Math.abs(arr.get((int) i));
        }

        return sum;
    }

    public static long maxPartition(Vector<Long> arr){
        Vector<Vector<Boolean>> dpArr = new Vector<Vector<Boolean>>();

        long sumOfAll = getSum(arr);

        return (long) -1;
    }

    public static void main(String[] args){
        Vector<Long> arr = new Vector<Long>();

        arr.add((long) 1);
        arr.add((long) 6);
        arr.add((long) 11);
        arr.add((long) 5);

        System.out.println(maxPartition(arr));
    }
}
