package datastructures.graph;

public class Edge {
    Node node1;
    Node node2;

    Integer weight;

    public Node getNeighbour(Node currentNode) {
        return currentNode == node1 ? node2 : node1;
    }
}
