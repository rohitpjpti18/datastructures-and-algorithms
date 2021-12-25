package datastructures.linkedlist;

public class Node {
    private Integer data;
    private Node next;

    public void print(){
        System.out.println(data.toString());
    }

    public Node(){
        this.data = 0;
    }

    public Node(int i) { 
        this.data = i;
    } 

    public Node(int i, Node nextNode){
        this.data = i;
        this.next = nextNode;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
