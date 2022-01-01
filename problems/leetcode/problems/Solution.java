package problems.leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
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
}
