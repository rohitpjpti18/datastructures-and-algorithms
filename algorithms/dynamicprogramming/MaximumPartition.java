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

    public static void printVector(Vector<Vector<Boolean>> arr){
        for(int i = 0; i<arr.size(); i++){
            for(int j = 0; j<arr.get(i).size(); j++){
                System.out.print(arr.get(i).get(j) + " ");
            }
            System.out.print("\n");
        }
    }

    public static long[] maxPartition(Vector<Long> arr){
        Vector<Vector<Boolean>> dpArr = new Vector<Vector<Boolean>>();

        long sumOfAll = getSum(arr);

        Vector<Boolean> temp1 = new Vector<Boolean>(); 
        for(int i = 0; i<Math.ceil(sumOfAll/2.0)+1; i++){
            temp1.add(false);
        }

        dpArr.add(temp1);

        for(int i = 1; i<arr.size()+1; i++){
            Vector<Boolean> temp = new Vector<Boolean>();
            for(int j = 0; j<Math.ceil(sumOfAll/2.0)+1; j++){
                if(dpArr.get(i-1).get(j).equals(true) 
                    || 
                    (arr.get(i-1) <= (j) && 
                        dpArr.get(i-1).get((int) (j - arr.get(i-1))).equals(true))
                    ||
                    (arr.get(i-1).equals((long) j))
                    ){
                    temp.add(true);
                }else{
                    temp.add(false);
                }
            }

            dpArr.add(temp);
        }

        //printVector(dpArr);

        long[] result = new long[2];
        for(int i = dpArr.get(arr.size()).size()-1; i>= 0; i--){
            if(dpArr.get(arr.size()).get(i).equals(true)){
                result[0] = i;
                break;
            }
        }

        result[1] = sumOfAll - result[0];
        return result;
    }

    public static void main(String[] args){
        Vector<Long> arr = new Vector<Long>();

        arr.add((long) 10);
        arr.add((long) 20);
        arr.add((long) 15);
        arr.add((long) 5);
        arr.add((long) 25);

        long[] result = maxPartition(arr);
        System.out.println(result[0] + " " + result[1]);
    }
}
