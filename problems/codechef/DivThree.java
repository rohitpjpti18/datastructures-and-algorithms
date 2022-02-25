package problems.codechef;

import java.util.*;
import java.lang.*;
import java.io.*;

class DivThree{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while(--t >= 0){
            int n;
            int k;
            int d;

            n = in.nextInt();
            k = in.nextInt();
            d = in.nextInt();

            List<Integer> arr = new ArrayList<Integer>();
            long sum = 0;
            for(int i = 0; i<n; i++){
                int temp = in.nextInt();
                arr.add(temp);
                sum+= temp;
            }

            int noOfContest = 0;
            while(sum>=k && noOfContest < d){
                sum = sum - k;
                noOfContest++;
            }

            System.out.println(noOfContest);


        }


        in.close();
    }
}