/*
NPTEL-Design and analysis of Algorithms
Topic-Negative edge weights: Bellman-Ford algorithm
https://www.youtube.com/watch?v=YbbGemzQ5ok&list=PL3pGy4HtqwD0ooUPM_0fLASrcXYWxL_Ry&index=26

SUDO CODE
<!--
function BellmanFord(s) // source s, with -ve weights
    for i = 1 to n
        distance[i] = infinity

    distance[s] = 0

    for i=1 to n-1 // repeat n-1 times
        for each edge(j, k) in E
            distance = min(distance(k), distance(j) + weight(j,k))
-->
*/

#include<iostream>
#include<vector>
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


// bellman-ford algorithm
vector<long> bellmanFordAlgorithm(vector<vector<long>> &graph, long startIndex) {
    long infinity = computeInfinity(graph);
    vector<long> distance(graph.size(), infinity);

    distance[startIndex] = 0;

    for(long i=0; i<graph.size()-1; i++){
        for(long j = 0; j<graph.size(); j++){
            for(long k = 0; k<graph.size(); k++){
                if(graph[j][k] != 0)
                    distance[k] > distance[j] + graph[j][k] ?
                        distance[k] = distance[j] + graph[j][k] :
                            distance[k] = distance[k];
            }
        }
    }

    return distance;
}


void testBellmanFordAlgorithm() {
    vector<vector<long>> testGraph{
        {0, 10, 0, 0, 0, 0, 0, 8},
        {0, 0, 0, 0, 0, 2, 0, 0},
        {0, 1, 0, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 3, 0, 0, 0},
        {0, 0, 0, 0, 0, -1, 0, 0},
        {0, 0, -2, 0, 0, 0, 0, 0},
        {0, -4, 0, 0, 0, -1, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0},
    };

    vector<long> result = bellmanFordAlgorithm(testGraph, 0);

    for(long i=0; i<result.size(); i++){
        cout<< result[i] << " ";
    }
    cout<< endl;
}


int main() {
    testBellmanFordAlgorithm();
    return 0;
}
