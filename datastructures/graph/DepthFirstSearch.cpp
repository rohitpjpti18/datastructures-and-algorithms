/*
NPTEL-Design and Analysis of Algorithms
Topic-Depth first search (DFS)
https://www.youtube.com/watch?v=0n4UtSm5HtE&list=PL3pGy4HtqwD0ooUPM_0fLASrcXYWxL_Ry&index=21

SUDO CODE
<!--
for j = 1...n {visited[j] = 0; parent[j] = -1}

function DFS(i) // DFS starting from vertex i
    // Mark i as visited
    visited[i] = 1

    // Explore each neighbour of i recursively
    for each (i, j) in E
        if visited[j] == 0
            parent[j] = i
            DFS(j)
-->
*/
#include<iostream>
#include<vector>
using namespace std;

// Depth first search algorithm
void depthFirstSearch(int index, vector<vector<int>> &testGraph, vector<int> &visited, vector<int> &parent){
    visited[index] = 1;

    for(int i=0; i<testGraph[index].size(); i++){
        if(visited[testGraph[index][i]] == 0){
            parent[testGraph[index][i]] = index;
            depthFirstSearch(testGraph[index][i], testGraph, visited, parent);
        }
    }
}


void testDepthFirstSearch(){
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

    vector<int> visited(testGraph.size(), 0);
    vector<int> parent(testGraph.size(), -1);

    depthFirstSearch(3, testGraph, visited, parent);

    for(int i = 0; i<parent.size(); i++){
        cout<< parent[i] << " ";
    }
    cout<< endl;
}


int main(){
    testDepthFirstSearch();
    return 0;
}
