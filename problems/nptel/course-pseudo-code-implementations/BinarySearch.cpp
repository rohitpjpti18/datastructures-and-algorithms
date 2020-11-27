// Binary Search 
#include<iostream>
#include<vector>
using namespace std;

int binarySearch(vector<int> &arr, int data, int lower, int upper){
    if(upper - lower == 0) return -1;

    int mid = (lower + upper)/2;
    if(data == arr[mid]){
        return mid;
    }


    if(data > arr[mid])
        return binarySearch(arr, data, mid+1, upper);
    else
        return binarySearch(arr, data, lower, mid-1);
    
}

int main(){
    vector<int> arr;
    int find_value;

    for(int i = 1; i<11; i++){
        arr.push_back(i);
    }
    cin>> find_value;

    cout<< binarySearch(arr, find_value, 0, 9);

    return 0;
}