package datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    int data;
    int distance;
    boolean visited;
    Node parent;

    List<Edge> neighbours;

    Node(){
        this.data = 0;
        this.neighbours = new ArrayList<>();
    }

    Node(int data){
        this.data = data;
        this.neighbours = new ArrayList<>();
    }
}
