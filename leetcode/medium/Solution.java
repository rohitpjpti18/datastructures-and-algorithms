package leetcode.medium;

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

    // https://leetcode.com/problems/two-city-scheduling/
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
            int i = a[0] - a[1];
            int j = b[0] - b[1];
            
            return i-j;
        });
        
        int result = 0;
        for(int i = 0; i<costs.length/2; i++)
            result += costs[i][0];
        for(int i = costs.length/2; i<costs.length; i++)
            result += costs[i][1];
        
        return result;
    }

    // https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
    public int minDominoRotations(int[] tops, int[] bottoms) {
        boolean[][] dice = new boolean[6][tops.length];
        
        for(int i = 0; i<tops.length; i++)
            dice[tops[i]-1][i] = true;
        
        for(int i = 0; i<bottoms.length; i++)
            dice[bottoms[i]-1][i] = true;
        
        List<Integer> theValue = new ArrayList();
        for(int i = 0; i<dice.length; i++){
            boolean flag = true;
            for(int j = 0; j<dice[0].length; j++){
                if(!dice[i][j]){
                    flag = false;
                }
            }
            if(flag){
                theValue.add(i+1);
            }
        }
        
        if(theValue.isEmpty()){
            return -1;
        }
        
        int countt = 0;
        int countb = 0;
        int[] counts = new int[theValue.size()];
        for(int v = 0; v<theValue.size(); v++){
            countt = 0; countb = 0;
            for(int i = 0; i<tops.length; i++){
                if(tops[i] != theValue.get(v)) countt++;
                if(bottoms[i] != theValue.get(v)) countb++;
            }
            counts[v] = Math.min(countt, countb);
        }
        
        
        int result = Integer.MAX_VALUE;

        for(int i = 0; i<counts.length; i++){
            if(counts[i] < result) result = counts[i]; 
        }
        
        return result;
    }

    // https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode slowPtr;
        ListNode fastPtr;
        
        if(head == null) return null;
        if(head.next == null) return head;
        
        slowPtr = head;
        fastPtr = head;
        
        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        return slowPtr;
    }

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/ 
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int newCount = 0;
        ListNode ptr = new ListNode(-1);
        ptr.next = head;
        head = ptr;
        
        int count = 0;
        
        while(ptr!=null){
            ptr = ptr.next;
            count++;
        }
        ptr=head;
        
        while(ptr != null){
            if(newCount == count-1-n){
                ptr.next = ptr.next.next;
                break;
            }
            ptr = ptr.next;
            newCount++;
        }
        
        return head.next;
    }

    // https://leetcode.com/problems/swap-nodes-in-pairs/
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;
        
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        head = newNode;
        
        ListNode upper = head.next.next;
        ListNode current = head.next;
        ListNode lower = head;
        
        while(upper != null){
            ListNode temp = current;
            current = upper;
            lower.next = upper;
            upper = temp;
            temp.next = current.next;
            current.next = upper;
            
            if(upper.next == null){
                break;
            }
            
            lower = upper;
            current = upper.next;
            upper = upper.next.next;
        }
        return head.next;
    }


    // https://leetcode.com/problems/remove-duplicate-letters/
    public String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        
        Map<Character, Integer> map = new HashMap();
        
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i], i);
        }
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i<arr.length; i++){
            
            if(!stack.contains(arr[i])){
                while(!stack.isEmpty() && stack.peek() > arr[i] && i < map.get(stack.peek())){
                    stack.pop();
                }
                stack.push(arr[i]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        sb.reverse();
        return sb.toString();
    }


    // https://leetcode.com/problems/integer-to-roman
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
        while(num > 0){
            if(num >= 1000){
                sb.append("M");
                num = num - 1000;
                continue;
            }if(num >= 900){
                sb.append("CM");
                num = num - 900;
                continue;
            }if(num >= 500){
                sb.append("D");
                num = num - 500;
                continue;
            }if(num >= 400){
                sb.append("CD");
                num = num - 400;
                continue;
            }if( num >= 100){
                sb.append("C");
                num = num - 100;
                continue;
            }if(num >= 90){
                sb.append("XC");   
                num = num - 90;
                continue;
            }if(num >= 50){
                sb.append("L");
                num = num - 50;
                continue;
            }if(num >=40){
                sb.append("XL");
                num = num - 40;
                continue;
            }if(num>=10){
                sb.append("X");
                num = num - 10;
                continue;
            }if(num>=9){
                sb.append("IX");
                num = num - 9;
                continue;
            }if(num>=5){
                sb.append("V");
                num = num - 5;
                continue;
            }if(num>=4){
                sb.append("IV");
                num = num - 4;
                continue;
            }if(num>=1){
                sb.append("I");
                num = num - 1;
                continue;
            }
        }
        
        return sb.toString();
    }

    // https://leetcode.com/problems/game-of-life/
    public void gameOfLife(int[][] board) {
        int[][] temp = new int[board.length][board[0].length];
        
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                temp[i][j] = 0;
                if(i > 0) temp[i][j] += board[i-1][j];
                if(j > 0) temp[i][j] += board[i][j-1];
                if(i < board.length-1) temp[i][j] += board[i+1][j];
                if(j < board[0].length-1) temp[i][j] += board[i][j+1];
                if(i > 0 && j > 0) temp[i][j] += board[i-1][j-1];
                if(i > 0 && j < board[0].length-1) temp[i][j] += board[i-1][j+1];
                if(i < board.length-1 && j < board[0].length-1) temp[i][j] += board[i+1][j+1];
                if(i < board.length-1 && j > 0 ) temp[i][j] += board[i+1][j-1];
            }
        }
        
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 1){
                    if(temp[i][j] < 2) board[i][j] = 0;
                    else if(temp[i][j] == 2 || temp[i][j] == 3) board[i][j] = 1;
                    else board[i][j] = 0;
                }else if(temp[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    // https://leetcode.com/problems/spiral-matrix-ii/
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int length = 0;
        int offset = 0;
        int value = 0;
        while(offset <= n/2){
            for(int a=offset; a<n-offset; a++){
                result[offset][a] = ++value;
                if(offset == n/2) return result;
            }
            for(int a = offset+1; a<n-offset-1; a++){
                result[a][n-offset-1] = ++value;
            }
            for(int a = n-offset-1; a>=offset; a--){
                result[n-offset-1][a] = ++value;
            }
            for(int a = n-offset-2; a>offset; a--){
                result[a][offset] = ++value; 
            }
            
            offset++;
        }
        
        return result;
    }
}
