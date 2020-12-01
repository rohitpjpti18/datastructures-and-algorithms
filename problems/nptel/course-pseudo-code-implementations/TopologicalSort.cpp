#include<bits/stdc++.h>
using namespace std;

void printArray(vector<int> &arr);
vector<int> topologicalSort(vector<vector<int>> &graph, vector<int> &indegree);

int main(){
    int n;
    vector<vector<int>> arr;
    freopen("inputs/topological.txt", "r", stdin);

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

    vector<int> indegree(n, 0);
    for(auto i: arr){
        for(auto j: i)
            indegree[j]++; 
    }

    printArray(indegree);
    vector<int> result = topologicalSort(arr, indegree);
    printArray(result);

    return 0;
}

void printArray(vector<int> &arr){
    for(auto i: arr){
        cout<< i << " ";
    }
    cout<< endl;
}

int findNodeWithZeroIndex(vector<int> &indegree){
    for(int i = indegree.size()-1; i>=0; i--){
        if(indegree[i] == 0) return i;
    }
    return -1;
}

vector<int> topologicalSort(vector<vector<int>> &graph, vector<int> &indegree){
    vector<int> topologicallySorted;
    for(int i = 0; i<indegree.size(); i++){
        int j = findNodeWithZeroIndex(indegree);
        if(j == -1) break;
        indegree[j] = -1;
        topologicallySorted.push_back(j);

        for(auto k: graph[j]) indegree[k]--;
    }

    return topologicallySorted;
}