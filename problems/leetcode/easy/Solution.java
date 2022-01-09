package problems.leetcode.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val){
            this.val= val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // https://leetcode.com/problems/binary-tree-inorder-traversal/
    public List<Integer> inOrderTraversalRunner(TreeNode node, List<Integer> result){ 
        if(node != null){
            inOrderTraversalRunner(node.left, result);
            result.add(node.val);
            inOrderTraversalRunner(node.right, result);
        }

        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> i = new ArrayList<Integer>();

        return inOrderTraversalRunner(root, i);
    }

    // https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head){
        Set<ListNode> sets = new HashSet<ListNode>();
        ListNode ptr = head;
        while(ptr != null){
            if(!sets.contains(ptr)){
                sets.add(ptr);
                ptr = ptr.next;
            }else{
                return true;
            }
        }
        return false;
    }


    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode ptr1 = head;
        ListNode ptr2 = head;

        while(ptr2 != null){
            if(ptr2.val != ptr1.val){
                ptr1.next = ptr2;
                ptr1 = ptr2;
            }
            ptr2 = ptr2.next;
        }
        ptr1.next = null;

        return head; 
    }


    // https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        Deque<TreeNode> q = new ArrayDeque<TreeNode>();
        q.add(root.left);
        q.add(root.right);

        while(!q.isEmpty()){
            TreeNode n1 = q.removeFirst();
            TreeNode n2 = q.removeFirst();

            if(n1 == null && n2 == null)
                continue;
            else if(n1 == null || n2 == null)
                return false;
            else{
                q.addLast(n1.left);
                q.addLast(n2.right);
                q.addLast(n1.right);
                q.addLast(n2.left);
            }
        }
        return true;
    }

    // https://leetcode.com/problems/path-sum/
    public void inOrderTraversalRunner2(TreeNode node, Integer added, Integer valToFind, boolean flag){ 
        if(node != null){
            if(node.right == null && node.left == null){
                if(node.val+added == valToFind)
                    flag = true;
            }
            inOrderTraversalRunner2(node.left, added+node.val, valToFind, flag);

            inOrderTraversalRunner2(node.right, added+node.val, valToFind, flag);
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean result = false;
        inOrderTraversalRunner2(root, 0, targetSum, result);
        return result;
    }

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int current_min = prices[0];
        for(int i = 1; i<prices.length; i++){
            if(prices[i] - current_min > max_profit){
                max_profit = prices[i] - current_min;
            }
            if(current_min > prices[i]){
                current_min = prices[i];
            }
        }   

        return max_profit;
    }

    // https://leetcode.com/problems/min-stack/
    class MinStack {
        private Stack<Integer> stack;
        
        public MinStack() {
            this.stack = new Stack<Integer>();
        }
        
        public void push(int val) {
            this.stack.add(val);
        }
        
        public void pop() {
            this.stack.pop();
        }
        
        public int top() {
            return this.stack.peek();
        }
        
        public int getMin() {
            return Collections.min(this.stack);
        }
    }

    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0;
        int ptr2 = numbers.length-1;
        
        while(ptr1!=ptr2){
            if(numbers[ptr1]+numbers[ptr2] == target){
                int[] r = new int[2];
                r[0] = ++ptr1;
                r[1] = ++ptr2;
                return r;
            }else if(numbers[ptr1] + numbers[ptr2] > target){
                ptr2--;
            }else
                ptr1++;
        }

        int[] r2 = new int[2];
        r2[0] = -1;
        r2[1] = -1;
        return r2;
    }

    // https://leetcode.com/problems/excel-sheet-column-title/
    public String convertToTitle(int columnNumber) {
        String ch = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
        StringBuilder r = new StringBuilder();
        while(columnNumber != 0){
            r.append(ch.charAt(columnNumber%26));
            if(columnNumber%26 == 0){
                columnNumber = columnNumber/26-1;
            }else{
                columnNumber = columnNumber/26;
            }
            
        }

        return r.reverse().toString();
    }   

    // https://leetcode.com/problems/majority-element/
    public int majorityElement(int[] nums) {
        int limit = nums.length/2;

        Arrays.sort(nums);
        
        if(nums.length < 2){
            return nums[0];
        }

        int ptr1 = 0;
        int ptr2 = 1;
        //int me = -1;
        while(ptr2 < nums.length){
            if(nums[ptr1] == nums[ptr2]){
                if((ptr2 - ptr1 +1) > limit)
                    return nums[ptr2];
                ptr2++;
            }else{
                if((ptr2 - ptr1 +1) > limit){
                    return nums[ptr2];
                }
                ptr1 = ptr2;
                ptr2++;
            }
        }

        return nums[0];
    }

    // https://leetcode.com/problems/number-of-1-bits/
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    // https://leetcode.com/problems/excel-sheet-column-number/
    public int titleToNumber(String columnTitle) {
        int r = 0;

        int counter=0;
        for(int i = columnTitle.length()-1; i>=0; i--){
            r += Math.pow(26, counter)*(columnTitle.charAt(i)-64);
            counter++;
        }

        return r;
    }

    // https://leetcode.com/problems/reverse-bits/
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    // https://leetcode.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }

        if(head.next == null){
            if(head.val == val){
                return null;
            }else
                return head;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;

        while(ptr2 != null){
            if(ptr2.val == val){
                ptr1.next = ptr2.next;
                ptr2 = ptr2.next;
                continue;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;

        }

        if(head.val == val){
            head = head.next;
        }

        return head;
    }

    // https://leetcode.com/problems/isomorphic-strings/
    public boolean isIsomorphic(String s, String t) {
        //var i = 10;

        Map<Character, List<Integer>> sl1 = new HashMap<Character, List<Integer>>();
        Map<Character, List<Integer>> sl2 = new HashMap<Character, List<Integer>>();

        for(int i = 0; i<s.length(); i++){
            if(!sl1.containsKey(s.charAt(i))){
                List<Integer> newl = new ArrayList<Integer>();
                newl.add(i);
                sl1.put(s.charAt(i), newl);
            }else{
                List<Integer> newl = sl1.get(s.charAt(i));
                newl.add(i);
                sl1.replace(s.charAt(i), newl);
            }

            if(!sl2.containsKey(t.charAt(i))){
                List<Integer> newl2  =new ArrayList<Integer>();
                newl2.add(i);
                sl2.put(t.charAt(i), newl2);
            }else{
                List<Integer> newl2 = sl2.get(t.charAt(i));
                newl2.add(i);
                sl2.replace(t.charAt(i), newl2);
            }
        }


        Map<List<Integer>, Character> ls1 = new HashMap<List<Integer>, Character>();
        Map<List<Integer>, Character> ls2 = new HashMap<List<Integer>, Character>();

        for(Map.Entry<Character, List<Integer>> a: sl1.entrySet()){
            ls1.put(a.getValue(), a.getKey());
        }

        for(Map.Entry<Character, List<Integer>> a: sl2.entrySet()){
            ls2.put(a.getValue(), a.getKey());
        }

        for(Map.Entry<List<Integer>, Character> a : ls1.entrySet()){
            if(!ls2.containsKey(a.getKey())){
                return false;
            }
        }

        return true;
    }

    // https://leetcode.com/problems/reverse-linked-list/
    public ListNode reverseList(ListNode head) {
        ListNode ptr1 = null;
        ListNode ptr2 = head;
        ListNode ptr3 = head.next;

        while(ptr2 != null){
            ptr3 = ptr2.next;
            ptr2.next = ptr1;

            ptr1 = ptr2;
            ptr2 = ptr3;

        }

        // ptr2.next = ptr1;

        return ptr1;
    }
    
    // https://leetcode.com/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();

        for(int i = 0; i<nums.length; i++){
            s.add(nums[i]);
        }

        return nums.length != s.size();
    }

    // https://leetcode.com/problems/contains-duplicate-ii/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> s = new HashSet<Integer>();
        
        for(int i = 0; i<nums.length; i++){
            if(s.contains(nums[i])){
                return true;
            }

            s.add(nums[i]);
            if(i>=k){
                s.remove(nums[i-k]);
            }
        }

        return false;
    }


    // https://leetcode.com/problems/implement-stack-using-queues/submissions/
    class MyStack {
        private Deque<Integer> q1; 
        private Deque<Integer> q2;
    
    
        public MyStack() {
            this.q1 = new ArrayDeque<Integer>();
            this.q2 = new ArrayDeque<Integer>();
        }
        
        public void push(int x) {
            q2.addLast(x);
            while(!q1.isEmpty()){
                q2.addLast(q1.removeFirst());
            }
            while(!q2.isEmpty()){
                q1.addLast(q2.removeFirst());
            }
        }
        
        public int pop() {
            return q1.removeFirst();
        }
        
        public int top() {
            return q1.getFirst();
        }
        
        public boolean empty() {
            return q1.isEmpty();
        }
    }


    // https://leetcode.com/problems/invert-binary-tree/
    public void invertTreeRecursive(TreeNode current){
        if(current == null){
            return ;
        }

        invertTreeRecursive(current.left);
        invertTreeRecursive(current.right);

        TreeNode tempPtr = current.left;
        current.left = current.right;
        current.right = tempPtr;
    }
    public TreeNode invertTree(TreeNode root) {
        invertTreeRecursive(root);

        return root;
    }

    // https://leetcode.com/problems/summary-ranges/
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();

        if(nums.length == 0){
            return result;
        }

        Integer initalAdd = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i]-1 == nums[i-1]){
                continue;
            }else{

                if(initalAdd - (i-1) == 0){
                    result.add(Integer.toString(nums[initalAdd]));
                }else{
                    result.add(Integer.toString(nums[initalAdd]) + "->" + Integer.toString(nums[i - 1]));
                }

                initalAdd = i;
            }
        }
        if(initalAdd - (nums.length-1) == 0){
            result.add(Integer.toString(nums[initalAdd]));
        }else{
            result.add(Integer.toString(nums[initalAdd]) + "->" + Integer.toString(nums[nums.length-1]));
        }

        return result;
    }

    // https://leetcode.com/problems/power-of-two/
    public boolean isPowerOfTwo(int n) {
        if(n<0){
            return false;
        }
        return (n != 0 && ((n & (n-1)) == 0));
    }

    // https://leetcode.com/problems/implement-queue-using-stacks/
    class MyQueue {
        private Deque<Integer> s1;
        private Deque<Integer> s2;

        public MyQueue() {
            this.s1 = new ArrayDeque<Integer>();
            this.s2 = new ArrayDeque<Integer>();        
        }
        
        public void push(int x) {
            while(!s1.isEmpty()){
                s2.addLast(s1.removeLast());
            }
            s2.addLast(x);

            while(!s2.isEmpty()){
                s1.addLast(s2.removeLast());
            }
        }
        
        public int pop() {
            return s1.removeLast();
        }
        
        public int peek() {
            return s1.getLast();
        }
        
        public boolean empty() {
            return s1.isEmpty();
        }
    }

    public ListNode midVal(ListNode head){
        ListNode doublePtr = head;
        ListNode singlePtr = head;

        while(doublePtr != null && doublePtr.next != null){
            doublePtr = doublePtr.next.next;
            singlePtr = singlePtr.next;
        }

        return singlePtr;
    }

    boolean compareLists(ListNode head1, ListNode head2){
        ListNode temp1 = head1;
        ListNode temp2 = head2;
 
        while (temp1 != null && temp2 != null) {
            if (temp1.val == temp2.val) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else
                return false;
        }
 
        if (temp1 == null && temp2 == null)
            return true;
 
        return false;
    }


    // https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        ListNode ptr = head;
        Stack<ListNode> s = new Stack<ListNode>();
        while(ptr!=null){
            s.add(ptr);

            ptr = ptr.next;

        }

        ptr = head;
        while(ptr!=null){
            if(ptr.val != s.pop().val){
                return false;
            }
            ptr = ptr.next;
        }

        return true;
    }

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        TreeNode leftNode = null;
        TreeNode rightNode = null;

        if(root.val == p.val || root.val == q.val){
            return root;
        }


        leftNode = lowestCommonAncestor(root.left, p, q);
        rightNode = lowestCommonAncestor(root.right, p, q);

        if(leftNode != null && rightNode != null){
            return root;
        }

        return leftNode != null ? leftNode : rightNode;
    }

    // https://leetcode.com/problems/delete-node-in-a-linked-list/
    public void deleteNode(ListNode node) {
        ListNode ptr = node;

        while(ptr.next.next != null){
            ptr.val = ptr.next.val;
            ptr = ptr.next;
        }
        ptr.val = ptr.next.val;

        ptr.next = null;
    }

    // https://leetcode.com/problems/valid-anagram/
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        Arrays.fill(arr1, 0);
        Arrays.fill(arr2, 0);

        for(int i = 0; i<s.length(); i++){
            arr1[ s.charAt(i) - 'a']++; 
            arr2[ t.charAt(i) - 'a']++;
        }

        for(int i = 0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        
        return true;
    }

    // https://leetcode.com/problems/binary-tree-paths/
    public void binaryTreePath(TreeNode node, List<String> finalList, List<String> listTillNow){
        if(node!=null){

            if(node.left == null && node.right == null){
                StringBuilder sb = new StringBuilder();
                for(String i: listTillNow){
                    sb.append(i);
                    sb.append("->");
                }
                sb.append(Integer.toString(node.val));
                finalList.add(sb.toString());
            }
            listTillNow = new ArrayList<String>(listTillNow);
            listTillNow.add(Integer.toString(node.val));
            binaryTreePath(node.left, finalList, listTillNow);
            binaryTreePath(node.right, finalList, listTillNow);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> listTillNow = new ArrayList<String>();
        List<String> finalList = new ArrayList<String>();
        binaryTreePath(root, finalList, listTillNow);

        return finalList;
    }

    // https://leetcode.com/problems/add-digits/
    public int addDigits(int num) {
        int sum = 0;
        
        while(num != 0){
            sum += num%10;
            num = num/10;
        }

        while(sum > 9){
            num = sum;
            sum = 0;
            while(num != 0){
                sum += num%10;
                num = num/10;
            }
        }
        return sum;
    }

    // https://leetcode.com/problems/ugly-number/
    public boolean isUgly(int n) {
        if(n<=0){
            return false;
        }

        while(n != 1){
            if(n%2 == 0){
                n = n/2;
            }else if(n%3 == 0){
                n = n/3;
            }else if(n%5 == 0){
                n = n/5;
            }else{
                return false;
            }
        }

        return true;
    }   

    // https://leetcode.com/problems/missing-number/
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0;i<nums.length; i++){
            if(nums[i]!=i){
                return i;
            }
        }

        return nums.length;
    }

    // https://leetcode.com/problems/first-bad-version/
    public int firstBadVersion(int n) {
        int lower = 1;
        int upper = n;

        while(lower<=upper){
            boolean mid = false; //isBadVersion((lower+upper)/2);

            if(!mid)
                lower = ((lower+upper)/2) + 1;
            else
                upper = ((lower+upper)/2) - 1;
        }

        

        return lower;
    }


    // https://leetcode.com/problems/implement-strstr/
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // https://leetcode.com/problems/move-zeroes/
    public void moveZeroes(int[] nums) {
        int[] tempArr = new int[nums.length];

        Arrays.fill(tempArr, 0);

        int count = 0;
        for(int i = 0; i<tempArr.length; i++){
            if(nums[i] != 0){
                tempArr[count] = nums[i];
                count++;
            }
        }

        for(int i =0; i<tempArr.length; i++){
            nums[i] = tempArr[i];
        }
    }

    // https://leetcode.com/problems/word-pattern/
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        Map<Character, String> str = new HashMap<Character, String>();


        if(pattern.length() != words.length){
            return false;
        }

        for(int i = 0; i<pattern.length(); i++){
            if(!str.containsKey(pattern.charAt(i))){
                str.put(pattern.charAt(i), words[i]);
            }else if(!str.get(pattern.charAt(i)).equals(words[i])){
                return false;
            }
        }

        List<String> a = (ArrayList<String>) str.values();

        Set<String> e = new HashSet<String>(a);



        return a.size() != e.size();
    }

    // https://leetcode.com/problems/range-sum-query-immutable/
    class NumArray {
        private List<Integer> numsArr;
        public NumArray(int[] nums) {
            numsArr = new ArrayList<Integer>();
            for(int i = 0 ; i<nums.length; i++){
                numsArr.add(nums[i]);
            }
        }
        
        public int sumRange(int left, int right) {
            List<Integer> sumstr = numsArr.subList(left, right+1);
            int sum = 0;

            for(Integer i: sumstr){
                sum += i;
            }

            return sum;
        }
    }

    // https://leetcode.com/problems/power-of-three/
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        while(n != 1){
            if(n%3 == 0){
                n = n/3;
            }else{
                return false;
            }
        }

        return true;
    }


    // https://leetcode.com/problems/counting-bits/
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i = 0; i<n+1; i++){
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }

    // https://leetcode.com/problems/power-of-four/
    public boolean isPowerOfFour(int n) {
        if(n<=0){
            return false;
        }
        while(n != 1){
            if(n%4 == 0){
                n = n/4;
            }else{
                return false;
            }
        }

        return true;
    }

    // https://leetcode.com/problems/reverse-string/
    public void reverseString(char[] s) {
        for(int i = 0; i<s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }

}



