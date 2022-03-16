package problems.leetcode.medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    // https://leetcode.com/problems/rotate-array/
    public void rotate(int[] nums, int k) {
        int numOfRotations = k%nums.length;
        
        int ptr = nums.length - numOfRotations;

        int[] temp = new int[ptr];

        for(int i = 0; i<ptr; i++){
            temp[i] = nums[i];
        }

        int start = 0;
        for(int i = ptr; i<nums.length; i++){
            nums[start] = nums[i];
            start++;
        }

        for(int i = 0; i<temp.length ; i++){
            nums[start] = temp[i];
            start++;
        }

    }

    // https://leetcode.com/problems/string-to-integer-atoi/
    public int myAtoi(String s) {
        s = s.trim();
        
        if(s.length() == 0) return 0;
        
        int signMultiplier = 1;
        int start = 0;
        if(signMultiplier == '-'){
            signMultiplier = -1;
            start = 1;
        }else if(signMultiplier == '+'){
            signMultiplier = 1;
            start = 1;
        }
        
        int result = 0;
        
        for(int i = 0; i<s.length(); i++){
            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                return result*signMultiplier;
            }
            
            result = result*10 + int(s.charAt(i) - '0')
                
            if(result*signMultiplier <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else if(result*signMultiplier >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        
        return result*signMultiplier;
    }

    // https://leetcode.com/problems/3sum/
    public List<List<Integer>> threeSum(int[] nums) {
        int left;
        int right;
        
        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();
        if(nums.length < 3){
            return new ArrayList<>(result);   
        }
        for(int current = 0; current<nums.length-2; current++){
            left = current+1;
            right = nums.length-1;
            while(left<right){
                int threeSum = nums[current] + nums[left] + nums[right];
                if(threeSum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[current]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);

                    result.add(temp);
                    
                    left++;

                    while(left<right && nums[left] == nums[left-1]){
                        left++;
                    }
                }
                if(threeSum > 0){
                    right--;
                }
                if(threeSum < 0){
                    left++;
                }
            }
        }
        

        return new ArrayList<>(result);        
    }

    /*
    public Integer threeSumCloset(int[] nums, target){
        int left;
        int right;
        int output = Integer.MAX_INT;

        for(int current = 0; current<nums.length-2; current++){
            left = current+1;
            right = nums.length-1;

            while(left<right){
                int currentVal = nums[left] + nums[right] + nums[current];

                if(currentVal - target == 0)
                    return currentVal;

                if(Math.abs(currentVal - target) < Math.abs(output-target)){
                    output = currentVal;
                }

                if(currentVal - target < )
            }
        }
    }
    */
}
