package algorithms.dynamicprogramming.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knapsack {
    public static int solution(List<Integer> weights, List<Integer> values, Integer target){
        int[][] dpArr = new int[values.size()+1][target+1];

        for(int i = 0;i<values.size()+1; i++){
            for(int j = 0; j<target+1; j++){
                if(i == 0  || j == 0){
                    dpArr[i][j] = 0;
                }else{
                    if(j>=weights.get(i-1))
                        dpArr[i][j] = Math.max(dpArr[i-1][j-weights.get(i-1)] + values.get(i-1), dpArr[i-1][j]);
                    else
                        dpArr[i][j] = dpArr[i-j][j];
                }
            }
        }
        
        return dpArr[values.size()][target];
    }


    public static void main(String[] args) throws Exception{
        File input = new File(System.getProperty("user.dir") + "\\input.txt");
        Scanner s = new Scanner(input);

        int t = s.nextInt();
        int target = s.nextInt();
        List<Integer> v = new ArrayList<Integer>();
        List<Integer> w = new ArrayList<Integer>();

        for(int i = 0; i<t; i++){
            w.add(s.nextInt());
        }
        for(int i = 0; i<t; i++){
            v.add(s.nextInt());
        }

        System.out.println(Knapsack.solution(w, v, target));

        s.close();
    }
}
