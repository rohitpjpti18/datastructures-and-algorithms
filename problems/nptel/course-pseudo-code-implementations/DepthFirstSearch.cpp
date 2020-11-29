#include<bits/stdc++.h>
using namespace std;


void printArray(vector<int> &arr);
void depthFirstSearch(  int node, 
                        vector<vector<int>> &graph,
                        vector<int> &visited, 
                        vector<int> &parent );

int main(){
    int n;
    vector<vector<int>> arr;
    freopen("inputs/graph1.txt", "r", stdin);

    cin>> n;
    for(int i = 0; i<n; i++){
        int m;
        cin>>m;
        vector<int> tempArr;
        for(int j = 0; j<m; j++){
            int temp;
            cin>> temp;
            tempArr.push_back(temp);
        }
        arr.push_back(tempArr);
    }

    vector<int> visited(n, 0);
    vector<int> parent(n, -1);

    depthFirstSearch(0, arr, visited, parent);
    printArray(parent);
}


void printArray(vector<int> &arr){
    for(auto i: arr){
        cout<< i << " ";
    }
    cout<< endl;
}

void depthFirstSearch(int node, vector<vector<int>> &graph, vector<int> &visited, vector<int> &parent){
    visited[node] = 1;

    for(auto i : graph[node]){
        if(visited[i] == 0){
            parent[i] = node;
            depthFirstSearch(i, graph, visited, parent);
        }
    }
}