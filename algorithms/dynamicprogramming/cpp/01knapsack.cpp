/*
0-1 Knapsack problem
*/

/*
Given weights and values of n items, put these items in a knapsack of 
capacity W to get the maximum total value in the knapsack. In other 
words, given two integer arrays val[0..n-1] and wt[0..n-1] which 
represent values and weights associated with n items respectively. Also 
given an integer W which represents knapsack capacity, find out the 
maximum value subset of val[] such that sum of the weights of this subset 
is smaller than or equal to W. You cannot break an item, either pick the 
complete item or don’t pick it (0-1 property)
*/
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;


long knapsack01(long size, long targetweight, vector<long> weights, vector<long> profits){
    vector<pair<long, long>> items;
    for(long i = 0; i<size; i++){
        pair<long, long> temp;
        temp.first = weights[i];
        temp.second = profits[i];

        items.push_back(temp);
    }

    sort(items.begin(), items.end());

    long solmatrix[size+1][targetweight+1];

    for(long i = 0; i<size+1; i++){
        for(long j = 0; j<targetweight+1; j++)
        if(i == 0 || j == 0 ) solmatrix[i][j] = 0;
    }

    for(long i = 1; i<size+1; i++){
        for(long j = 1; j<targetweight+1; j++){
            if(items[i-1].first <= j)
                solmatrix[i][j] = max(items[i-1].second + solmatrix[i-1][j-(items[i-1].first)], solmatrix[i-1][j]);
            else
            {
                solmatrix[i][j] = solmatrix[i-1][j];
            }
            
        }
    }

    return solmatrix[size][targetweight];
}

int main(){
    long targetWeight, n;
    vector<long> weights;
    vector<long> profits;
    int temp1;
    int temp2;

    freopen("knapsackSampleInput.txt", "r", stdin);

    cin>> n;
    cin>> targetWeight;
    for(int i = 0; i<n; i++){
        cin>> temp1;
        cin>> temp2;
        weights.push_back(temp1);
        profits.push_back(temp2);
    }
    
    cout<< "before knapsack" << endl;
    cout<< knapsack01(n, targetWeight, weights, profits);


    return 0;
}