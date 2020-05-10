#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;


// return the infinity value with respect to graph
long computeInfinity(vector<vector<long>> &graph){
    long total=0;
    for(long i = 0; i<graph.size(); i++){
        for(long j=0; j<graph[i].size(); j++){
            if(graph[i][j] != -1)
                total += graph[i][j];
        }
    }
    return total;
}


// return value for u such that visited[u] == false and distance[u] is minimum
long findAppropiateNode(vector<long> &distance, vector<bool> &visited, long infinity){
    long minimum = infinity;
    long minIndex = -1;
    for(long i = 0; i<visited.size(); i++){
        if(visited[i] == false && minimum>distance[i]){
            minimum = distance[i];
            minIndex = i;
        }
    }
    return minIndex;
}


// dijkstras algorithm
vector<long> dijkstraAlgorithm(vector<vector<long>> &graph, long startIndex){
    long infinity = computeInfinity(graph);
    vector<bool> visited(graph.size(), false);
    vector<long> distance(graph.size(), infinity);

    long u;

    distance[startIndex] = 0;

    for(long i = 0; i<graph.size(); i++){
        u = findAppropiateNode(distance, visited, infinity);
        visited[u] = true;
        for(long v = 0; v<graph[i].size(); v++){
            if(graph[u][v] != -1 && visited[v] == false){
                if(distance[v] > distance[u] + graph[u][v]){
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
    }

    return distance;
}

void testDijkstraAlgorithm(){
    vector<vector<long>> testGraph{
        {-1, 10, 80, -1, -1, -1, -1},
        {10, -1, 6, -1, 20, -1, -1},
        {80, 6, -1, 70, -1, -1, -1},
        {-1, -1, 70, -1, -1, -1, -1},
        {-1, 20, -1, -1, -1, 50, 10},
        {-1, -1, -1, -1, 50, -1, 5},
        {-1, -1, -1, -1, 10, 5, -1},
    };

    vector<long> result = dijkstraAlgorithm(testGraph, 0);

    for(long i=0; i<result.size(); i++){
        cout<< result[i] << " ";
    }
    cout<< endl;
}

int main(){
    testDijkstraAlgorithm();
    return 0;
}