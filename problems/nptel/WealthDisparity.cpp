#include<iostream>
#include<vector>
using namespace std;

long maxDifference = INT32_MIN;
long employeeCount;
vector<long> minWealth = vector<long>(0);
vector<bool> visited;
vector<long> employeeWealth;
vector<long> employeeManager;
vector<vector<long>> edges;

vector<vector<long>> computeEdges(vector<long> employeeManager){
    vector<vector<long>> edges(employeeManager.size(), vector<long>());

    for(long i = 0; i<employeeManager.size(); i++){
        if(employeeManager[i] != -1) edges[employeeManager[i]].push_back(i);
    }

    return edges;
}

void depthFirstSearch(long source){
    visited[source] = true;

    for(long i = 0; i<edges[source].size(); i++){
        long neighbour = edges[source][i];

        if(!visited[neighbour]){
            depthFirstSearch(neighbour);
            maxDifference = max(maxDifference, employeeWealth[source] - minWealth[neighbour]);
            minWealth[source] = min(minWealth[source], minWealth[neighbour]);
        }
    }
}

int main(){
    long mrHojoIndex = -1;

    cin>> employeeCount;
    for(long i = 0; i<employeeCount; i++){
        long temp;
        cin>> temp;
        employeeWealth.push_back(temp);
    }
    minWealth.insert(minWealth.end(), employeeWealth.begin(), employeeWealth.end());

    for(long i = 0; i<employeeCount; i++){
        long temp;
        cin>> temp;
        if(temp>0) employeeManager.push_back(temp-1);
        else{
            mrHojoIndex = i;
            employeeManager.push_back(temp);
        } 
    }

    edges = computeEdges(employeeManager);
    visited = vector<bool>(employeeCount, false);

    depthFirstSearch(mrHojoIndex);

    cout<< maxDifference;

    return 0;
}