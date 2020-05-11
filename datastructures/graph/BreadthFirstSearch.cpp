/*
NPTEL-Design and Analysis of Algorithms
Topic-Breadth first search (BFS)
https://www.youtube.com/watch?v=ahXszIXr1NE&list=PL3pGy4HtqwD0ooUPM_0fLASrcXYWxL_Ry&index=20

SOURCE CODE
<!--
function BFS(i) // BFS starting from vertex i
    //Initialization
    for j = 1...n {visited[j] = 0}; Q = []

    //Starting the exploration at i
    visited[i] = 1; append(Q, i);

    //Explore each vertex in Q
    while Q is not empty
        j = extract_head(Q)
        for each (j,k) in E
            if visited[k] == 0
                visited[k] = 1; append(Q, k)
-->
*/

#include<iostream>
#include<vector>
#include<queue>
using namespace std;

// BFS algorithm
vector<int> breadthFirstSearch(vector<vector<int>> graph, int startingIndex=0){
    queue<int> q;
    int value;
    vector<int> visited(graph.size(), 0);
    vector<int> parent(graph.size(), 0);
    
    visited[startingIndex] = 1;
    parent[startingIndex] = -1;
    q.push(startingIndex);

    while(!q.empty()){
        value = q.front(); q.pop();
        for(int i=0; i<graph[value].size(); i++){
            if(visited[graph[value][i]] != 1){
                visited[graph[value][i]] = 1;
                q.push(graph[value][i]);
                parent[graph[value][i]] = value;
            }
        }
    }

    return parent;
}


int testBreadthFirstSearch(){
    vector<vector<int>> testGraph{
        {1,2,3},
        {0,2},
        {0,1},
        {0,4,7},
        {3,5,6},
        {4,6,7,8},
        {4,5},
        {3,5,8},
        {5,7,9},
        {8}
    };

    vector<int> result = breadthFirstSearch(testGraph, 0);
    for(int i = 0; i<result.size(); i++){
        cout<< result[i] << " ";
    }
    cout<< endl;

    return 0;
}

int main(){
    int processCode = testBreadthFirstSearch();
    return processCode;
}
