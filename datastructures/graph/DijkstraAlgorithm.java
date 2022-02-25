package datastructures.graph;

import java.util.ArrayList;
import java.util.List;

class DijkstraAlgorithm{
    private static List<Node> graph;

    public static void dikstraAlgorithm(Node start){
        start.distance = 0;
        
        for(int i = 0; i<graph.size(); i++){
            Node currentNode = getLowestDistanceNode();
            currentNode.visited = true;
            for(Edge j: currentNode.neighbours){
                j.getNeighbour(currentNode).distance = Math.max(j.getNeighbour(currentNode).distance, currentNode.distance + j.weight);
            }
        }

    }

    private static Node getLowestDistanceNode(){
        return null;
    }

    private static void createGraph(){

    }

    public static void main(String[] args){

    }
}