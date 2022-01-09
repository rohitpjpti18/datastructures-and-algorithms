package problems.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> columns = new HashSet<Integer>();

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for(int i = 0; i<matrix.length; i++){
            if(rows.contains(i)){
                for(int j = 0; j<matrix[0].length; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0; j<matrix[0].length; j++){
            if(columns.contains(j)){
                for(int i = 0; i<matrix.length; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public String reverseWords(String s) {
        s = s.trim();
        int ptr1 = s.length()-1;
        int ptr2 = s.length()-1;

        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' '){
                sb.append(s.substring(ptr2+1, ptr1+1));
                sb.append(" ");

                ptr1 = ptr2-1;
            }
            ptr2--;
        }
        sb.append(s.substring(ptr2+1, ptr1+1));

        

        return sb.toString().replaceAll("( +)"," ").trim();
    }


    // https://leetcode.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        
        int maxLen = 0;
        int startIndex = 0;
        int lastIndex = 0;

        int low;
        int high;
        for(int i = 0; i<s.length(); i++){
            low = i-1;
            high = i+1;

            while(low >= 0 && high < s.length()){
                if(s.charAt(low) != s.charAt(high)){
                    break;
                }
                low--;
                high++;
            }
            ++low; --high;

            if(maxLen < (high-low)){
                maxLen = high-low;
                startIndex = low;
                lastIndex = high;
            }

            low = i;
            high = i+1;

            while(low >= 0 && high <s.length()){
                if(s.charAt(low) != s.charAt(high)){
                    break;
                }
                low--;
                high++;
            }
            ++low; high--;

            if(maxLen < (high-low)){
                maxLen = high-low;
                startIndex = low;
                lastIndex = high;
            }

            low = i;
            high = i+1;

        }


        return s.substring(startIndex, lastIndex+1);
    }



}
