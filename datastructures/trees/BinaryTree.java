/*
            5
          /   \
         3     7
       /  \      \
      1    4      9
       \         /
        2       8
*/
package datastructures.trees;

public class BinaryTree {
    private static Node root;

    public static void inOrderTraversal(Node node){
        if(node != null){
            inOrderTraversal(node.getLeft());
            node.print();
            inOrderTraversal(node.getRight());
        }
    }

    public static int minimum(Node node) {
        Node ptr = node;
        if(node != null){
            while(ptr.getLeft() != null) {
                ptr = ptr.getLeft();
            }
        }
        return ptr.getData();
    }

    public static int maximum(Node node) {
        Node ptr = node;
        if(node != null){
            while(ptr.getRight() != null){
                ptr = ptr.getRight();
            }
        }

        return ptr.getData();
    }

    public static int successor(Node node){
        if(node.getRight() != null){
            return minimum(node.getRight()); 
        }else{
            Node parent = node.getParent();
            Node current = node;
            while(parent!=null){
                if(parent.getLeft() == current){
                    return parent.getData();
                }else{
                    current = parent;
                    parent = parent.getParent();
                }
            }

            return -1;
        }
    }

    public static int predecessor(Node node){
        if(node.getLeft() != null){
            return maximum(node.getLeft());
        }else{
            Node parent = node.getParent();
            Node current = node;

            while(parent != null){
                if(parent.getRight() == current){
                    return parent.getData();
                }else{
                    current = parent;
                    parent = parent.getParent();
                }
            }

            return -1;
        }
    }


    public static Node createAExTree(){
        Node five = new Node(5);
        Node three = new Node(3, five);
        Node seven = new Node(7, five);
        five.setLeft(three);
        five.setRight(seven);

        Node one = new Node(1, three);
        Node four = new Node(4, three);
        three.setLeft(one);
        three.setRight(four);

        Node two = new Node(2, one);
        one.setRight(two);
        Node nine = new Node(9, seven);
        seven.setRight(nine);
        Node eight = new Node(8, nine);
        nine.setLeft(eight);

        return five;
    }

    public static void main(String[] args){
        root = createAExTree();
        
        //  inOrderTraversal(root);
        //  System.out.println(Integer.valueOf(minimum(root.getRight())).toString());
        //System.out.println(Integer.valueOf(maximum(root.getRight())).toString());
        System.out.println(Integer.valueOf(successor(root.getLeft().getRight())).toString());
    }


    public static Node getRoot() {
        return root;
    }


    public static void setRoot(Node root) {
        BinaryTree.root = root;
    }
}


                 