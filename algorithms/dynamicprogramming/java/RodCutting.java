/*
 *  Cutting a rod (unbounded knapsack)
 *  ----------------------------------------------------
 *  Given a rod of length n inches and an array of prices that contains prices of 
 *  all pieces of size smaller than n. Determine the maximum value obtainable by 
 *  cutting up the rod and selling the pieces. For example, if length of the rod 
 *  is 8 and the values of different pieces are given as following, then the maximum 
 *  obtainable value is 22 (by cutting in two pieces of lengths 2 and 6) 
 *  
 *  length | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
 *  ----------------------------------------
 *  price  | 1 | 5 | 8 | 9 | 10| 17| 17| 20|
 * 
 */
package algorithms.dynamicprogramming.java;

import java.util.*;


public class RodCutting {
    public static long rodCuttingProblem(Vector<Long> arr){
        Vector<Vector<Long>> dpArr = new Vector<Vector<Long>>();

        for(int i = 0; i<arr.size()+1; i++){
            Vector<Long> temp = new Vector<Long>();
            for(int j = 0; j<arr.size()+1; j++){
                temp.add((long) 0);
                //System.out.print(0 + " ");
            }
            //System.out.println();
            dpArr.add(temp);
        }
        for(int i = 1; i<arr.size()+1; i++){
            for(int j = 1; j < arr.size()+1; j++){
                long maxValue;
                if(j<i){
                    maxValue = dpArr.get(i-1).get(j);
                }else{
                    maxValue = Math.max( 
                        dpArr.get(i-1).get(j), 
                        arr.get(i-1) + dpArr.get(i).get(j-i)
                    );
                }
                dpArr.get(i).set(j, maxValue);
                //System.out.print(dpArr.get(i).get(j) + " ");
            }
            //System.out.println();
        }
        return dpArr.get(arr.size()).get(arr.size());
    }

    public static void main(String[] args){
        Vector<Long> arr = new Vector<Long>();

        arr.add((long) 3);
        arr.add((long) 5);
        arr.add((long) 8);
        arr.add((long) 9);
        arr.add((long) 10);
        arr.add((long) 17);
        arr.add((long) 17);
        arr.add((long) 20);

        System.out.println(rodCuttingProblem(arr));
    }
}
