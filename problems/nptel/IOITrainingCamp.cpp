#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;


void kadaneAlgorithm(vector<int> &data, vector<vector<int>> &best){
    best[0][0] = data[0];
    for(int i = 1; i<data.size(); ++i){
        best[i][0] = max(data[i], best[i-1][0]+data[i]);
    }
}

int IOICamp(vector<int> &data, int n, int k){
    vector<vector<int>> best(n, vector<int>(k, 0));

    kadaneAlgorithm(data, best);


}


int main(){
    int n;
    int k;

    cin>> n >> k;
    vector<int> data;

    for(int i=0; i<n; i++){
        cin>>data[i];
    }


    return 0;
}