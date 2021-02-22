#include<bits/stdc++.h>
using namespace std;

int find(int value, vector<int>& weights){
    int index = -1;
    for(int i = 0; i<weights.size(); ++i){
        if(value == weights[i]){
            index = i;
        }
    }

    return index;
}

int main(){
    freopen("input.txt", "r", stdin);

    long t;
    cin>>t;
    //cout<< t;

    while(t--){
        int n;
        vector<int> weights;
        vector<int> jumps;
        cin>> n;

        for(int i = 0; i< n; i++){
            int temp;
            cin>> temp;
            weights.push_back(temp);
        }

        for(int i = 0; i< n; i++){
            int temp;
            cin>> temp;
            jumps.push_back(temp);
        }

        vector<int> sortedweights(weights);
        sort(sortedweights.begin(), sortedweights.end());

        int lowestweight = sortedweights[0];

        int current = 1;
        int output = 0;
        int smaller = find(lowestweight, weights);
        //cout<< output << endl;
        int emptyspace = n;

        while(current != n){
            int larger = find(sortedweights[current], weights);
            int n = 0; 

            if(smaller > larger){
                n = (emptyspace-larger)/jumps[larger];
                weights[larger] = -1;
                output+=n;
                emptyspace++;
            }
  
            cout<< smaller << " " << larger << endl;

            if(++current != n){
                smaller = larger+n;
                larger = find(sortedweights[current], weights);
            }
        }

        cout<< output <<endl;
    }

    return 0;
}