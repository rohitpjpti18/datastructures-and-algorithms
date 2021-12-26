package datastructures.trees;

public class Node {
    private int data;
    private Node parent;
    private Node left; 
    private Node right;

    public Node(){
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Node(int data){
        this.data = data;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public Node(int data, Node left, Node right){
        this.data = data;
        this.parent = null;
        this.left = left;
        this.right = right;
    }

    public Node(int data, Node parent){
        this.data = data;
        this.parent = parent; 
        this.left = null;
        this.right = null;
    }

    public Node(int data, Node parent, Node left, Node right){
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public void print() {
        System.out.print(Integer.valueOf(data).toString() + " ");
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
