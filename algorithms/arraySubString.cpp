#include<iostream>
#include<vector>
using namespace std;

vector<vector<int>> allSubArray(vector<int> arr){
    vector<vector<int>> subArray;
    
    for(int i = 0; i<arr.size(); i++){
        for(int j = i; j<arr.size(); j++){
            vector<int> temp;
            for(int k=i; k<=j; k++){
                temp.push_back(arr[k]);
                //cout<< k << " ";
            }
            //cout<< endl;
            subArray.push_back(temp);
        }
    }

    return subArray;
}

int main(){
    vector<int> arr;
    arr.push_back(1);
    arr.push_back(2);
    arr.push_back(3);
    arr.push_back(4);
    arr.push_back(5);

    vector<vector<int>> result = allSubArray(arr);
    for(int i = 0; i<result.size(); i++){
        for(int j = 0; j<result[i].size(); j++){
            cout<< result[i][j] << " ";
        }
        cout<< endl;
    }

    return 0;
}
