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

    // https://leetcode.com/problems/multiply-strings/
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        if(num1.equals("1")) return num2;
        if(num2.equals("1")) return num1;
        
        int[][] ans = new int[num2.length()][num1.length() + num2.length()];
        int[] result = new int[num1.length() + num2.length()];
        StringBuilder newNum1 = new StringBuilder(num1);
        StringBuilder newNum2 = new StringBuilder(num2);
        
        newNum1.reverse();
        newNum2.reverse();
        
        num1 = newNum1.toString();
        num2 = newNum2.toString();
            
        int offset = 0;
        
        for(int i = 0; i<num2.length(); i++){
            int carry = 0;
            for(int j = 0; j<num1.length(); j++){
                int mul = (num2.charAt(i) - '0')*(num1.charAt(j) - '0');
                mul+=carry;
                carry = 0;
                if(mul > 9){
                    carry = mul/10;
                    mul = mul%10;
                }
                
                ans[i][j+offset] = mul;
            }
            if(carry>0){
                ans[i][num1.length()+offset] = carry; 
            }
            offset++;
        }
        
        int carry = 0;
        for(int j = 0; j<ans[0].length; j++){
            int sum = carry; 
            for(int i = 0; i<ans.length; i++){
                sum += ans[i][j];
            }            
            if(sum>9){
                carry = sum/10;
                sum = sum%10;
            }else{
                carry = 0;
            }
            
            result[j] = sum;
        }
        
        //System.out.println(Arrays.toString(result));
        
        int startIndex = 0;
        for(int i = result.length-1; i>-1 ; i--){
            if(result[i] != 0) {
                startIndex = i;
                break;
            }
        }
        
        StringBuilder r = new StringBuilder();
        for(int i = startIndex; i>-1; i--){
            r.append(Integer.toString(result[i]));
        }
        
        return r.toString();
    }

    // https://leetcode.com/problems/boats-to-save-people/
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int result = 0;
        
        while(left<=right){
            if(people[left] + people[right] <= limit)
                left++;
            right--;
            result++;
        }
        
        return result;
    }

    // https://leetcode.com/problems/broken-calculator/
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while(target>startValue){
            ans++;
            if(target%2==0) target /= 2;
            else target++;
        }
        
        return ans + startValue - target;
    }

    // https://leetcode.com/problems/3sum-closest/
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int result = 0;
        int minimum = Integer.MAX_VALUE;
        
        for(int i = 0; i<nums.length-2; i++){
            int j = i+1;
            int k = nums.length - 1;
            
            while(j<k){
                int total = Math.abs(nums[i] + nums[j] + nums[k] - target);
                
                if(total ==0) return nums[i]+nums[j]+nums[k];
                if(total < minimum){
                    minimum = total;
                    result = nums[i] + nums[j] + nums[k];
                }
                
                if(nums[i] + nums[j] + nums[k] > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        
        return result;
    }

    // https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
    public String getSmallest(StringBuilder result, int n, int k){
        while(n>0){
            int value = k - (n-1);
            if(value > 26){
                result.append("z");
                k -= ('z' - 'a') + 1;
            }else{
                result.append((char)((int)('a') + value - 1));
                k -= value;
            }
            n--;
        }
        result.reverse();
        return result.toString();
    }
    public String getSmallestString(int n, int k) {
        return getSmallest(new StringBuilder(), n, k);
    }

    // https://leetcode.com/problems/partition-labels/
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        
        for(int i = 0; i<s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for(int i = 0; i<s.length(); i++){
            j = Math.max(j, last[s.charAt(i)-'a']);
            
            if(i == j){
                ans.add(j-anchor + 1);
                anchor = i+1;
            }
        }
        
        return ans;
    }
}
