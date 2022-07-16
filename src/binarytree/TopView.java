package src.binarytree;

import java.util.List;

public class TopView {
    public class Pair {
        TreeNode node;
        int verticalLine;

        Pair() {}
        Pair(TreeNode node, int verticalLine) {
            this.node = node;
            this.verticalLine = verticalLine;
        }
    }

    public List<Integer> top(TreeNode root) {
        return null;
    }

    /*
     * coding ninja implementation
    static class Pair {
        BinaryTreeNode node;
        Integer verticalLine;
        
        Pair() {} 
        Pair(BinaryTreeNode node, Integer verticalLine) {
            this.node = node;
            this.verticalLine = verticalLine;
        }
    }
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> mpp = new TreeMap<>();
        
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()) {
            Pair n = queue.poll();
            if(!mpp.containsKey(n.verticalLine)) mpp.put(n.verticalLine, n.node.val);
            
            if(n.node.left != null) queue.offer(new Pair(n.node.left, n.verticalLine-1));
            if(n.node.right != null) queue.offer(new Pair(n.node.right, n.verticalLine+1));
        }
        
        for(Map.Entry<Integer, Integer> e: mpp.entrySet()) {
            result.add(e.getValue());
        }
        
        return result;
	}
     */
}
