package algorithms.dynamicprogramming;

// question link: https://www.geeksforgeeks.org/ugly-numbers/

import java.util.Scanner;
import java.lang.Math;

class UglyNumbers{

    public static int getUglyNumbers(int n){
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;

        int next_i2, next_i3, next_i5;

        for(int i = 1; i<n; i++){
            next_i2 = ugly[i2]*2;
            next_i3 = ugly[i3]*3;
            next_i5 = ugly[i5]*5;


            ugly[i] = Math.min(next_i2, Math.min(next_i3, next_i5));

            if(ugly[i] == next_i2){
                i2++;
            }
            if(ugly[i] == next_i3){
                i3++;
            }
            if(ugly[i] == next_i5){
                i5++;
            }
        }

        return ugly[n-1];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        System.out.println(getUglyNumbers(n));

        in.close();
    }
}