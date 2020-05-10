#include<iostream>
#include<vector>
using namespace std;



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
