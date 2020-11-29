#include<bits/stdc++.h>
using namespace std;

vector<int> breadthFirstSearch(int source, vector<vector<int>> &graph);
void printArray(vector<int> &arr);

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

    vector<int> result = breadthFirstSearch(0, arr);
    printArray(result);
    return 0;
}

void printArray(vector<int> &arr){
    for(auto i : arr){
        cout<< i << " ";
    }
    cout<< endl;
}

vector<int> breadthFirstSearch(int source, vector<vector<int>> &graph){
    vector<int> visited(graph.size(), 0);
    vector<int> parent(graph.size(), -1);
    queue<int> q; 
    
    visited[source] = 1;
    q.push(source);

    while(!q.empty()){
        int j = q.front(); q.pop();
        for(auto i : graph[j]){
            if(visited[i] == 0){
                visited[i] = 1;
                parent[i] = j;
                q.push(i);
            }
        }
    }

    return parent;
}