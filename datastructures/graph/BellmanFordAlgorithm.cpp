#include<iostream>
#include<vector>
using namespace std;

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
