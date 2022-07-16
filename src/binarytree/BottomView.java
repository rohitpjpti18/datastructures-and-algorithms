package src.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

public class BottomView {

    public List<Integer> bottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        Map<Integer, Integer> mpp = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        root.verticalLine = 0;
        if(root != null) queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode n = queue.poll();
            mpp.put(n.verticalLine, n.val);

            n.left.verticalLine = n.verticalLine - 1;
            n.right.verticalLine = n.verticalLine + 1;

            if(n.left  != null) queue.offer(n.left);
            if(n.right != null) queue.offer(n.right);
        }

        for(Entry<Integer, Integer> e: mpp.entrySet()) result.add(e.getValue());

        return result;
    }

    /*
    coding ninja implementation
     static class Pair {
        public BinaryTreeNode node;
        public int verticalLine;
        
        Pair() {}
        Pair(BinaryTreeNode node, int v) { 
            this.node = node;
            this.verticalLine = v;
        }
    }   
    
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> mpp = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;

        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()) {
            Pair n = queue.poll();
            mpp.put(n.verticalLine, n.node.val);

            if(n.node.left  != null) queue.offer(new Pair(n.node.left, n.verticalLine - 1));
            if(n.node.right != null) queue.offer(new Pair(n.node.right, n.verticalLine + 1));
        }
        
        for (Map.Entry<Integer, Integer> entry: mpp.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
    */ 
}
