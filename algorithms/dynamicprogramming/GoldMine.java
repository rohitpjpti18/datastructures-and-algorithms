/*
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer 
 * which is the amount of gold in tons. Initially the miner is at first column but can be 
 * at any row. He can move only (right->,right up /,right down\) that is from a given cell, 
 * the miner can move to the cell diagonally up towards the right or right or diagonally 
 * down towards the right. Find out maximum amount of gold he can collect.
 */
package algorithms.dynamicprogramming;

import java.util.*;

public class GoldMine {
    public static long maxElementOfMatrix(Vector<Vector<Long>> arr){
        long maxValue = Long.MIN_VALUE;

        for(int i = 0; i<arr.size(); i++){
            for(int j = 0; j<arr.get(0).size(); j++){
                if(arr.get(i).get(j) > maxValue){
                    maxValue = arr.get(i).get(j);
                }
            }
        }

        return maxValue;
    }

    public static long goldMineProblem(Vector<Vector<Long>> arr){
        for(int j = 1; j<arr.get(0).size(); j++){
            for(int i = 0; i<arr.size(); i++){
                if(i == 0){
                    arr
                    .get(i)
                    .set(
                        j, 
                        arr.get(i).get(j) + Math.max(
                            arr.get(i).get(j-1), 
                            arr.get(i+1).get(j-1)
                        )
                    );
                }else if( i == arr.size()-1){
                    arr
                    .get(i)
                    .set(
                        j, 
                        arr.get(i).get(j) + Math.max(
                            arr.get(i).get(j-1), 
                            arr.get(i-1).get(j-1)
                        )
                    );  
                }else{
                    arr
                    .get(i)
                    .set(
                        j, 
                        arr.get(i).get(j) + Math.max(
                            arr.get(i+1).get(j-1),
                            Math.max(
                                arr.get(i).get(j-1), 
                                arr.get(i-1).get(j-1)
                            )
                        )
                    );  
                }
            }    
        }

        return maxElementOfMatrix(arr);
    }

    public static void main(String[] args){
        Vector<Vector<Long>> arr = new Vector<Vector<Long>>();

        Vector<Long> temp = new Vector<Long>();

        temp.add((long) 10);
        temp.add((long) 33);
        temp.add((long) 13);
        temp.add((long) 15);

        arr.add(temp);

        temp = new Vector<Long>();

        temp.add((long) 22);
        temp.add((long) 21);
        temp.add((long) 4);
        temp.add((long) 1);

        arr.add(temp);
        
        temp = new Vector<Long>();

        temp.add((long) 5);
        temp.add((long) 0);
        temp.add((long) 2);
        temp.add((long) 3);

        arr.add(temp);
        
        temp = new Vector<Long>();

        temp.add((long) 0);
        temp.add((long) 6);
        temp.add((long) 14);
        temp.add((long) 2);

        arr.add(temp);

        System.out.println(goldMineProblem(arr));
    }
}
