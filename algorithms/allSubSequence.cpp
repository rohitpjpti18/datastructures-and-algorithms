#include<iostream>
#include<vector>
#include<cmath>
using namespace std;

vector<vector<int>> allSubSequence(vector<int> arr){ 
    vector<int> subSequence;
    vector<vector<int>> all;
    unsigned int limit = pow(2, arr.size()); 

    for (int i = 1; i < limit; i++) { 
        for (int j = 0; j < arr.size(); j++) { 
            if (i & (1<<j)) 
                subSequence.push_back(arr[j]); 
        } 
        all.push_back(subSequence);
    }

    return all; 
} 


int main(){
    vector<int> arr;
    arr.push_back(1);
    arr.push_back(2);
    arr.push_back(3);
    arr.push_back(4);

    vector<vector<int>> result = allSubSequence(arr);
    for(int i = 0; i<result.size(   ); i++){
        for(int j = 0; j<result[i].size(); j++){
            cout<< result[i][j] << " ";
        }
        cout<< endl;
    }

    return 0;
}
