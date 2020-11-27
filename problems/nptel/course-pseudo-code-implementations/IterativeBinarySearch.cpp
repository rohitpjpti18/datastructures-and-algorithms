#include<iostream>
#include<vector>
using namespace std;

int main(){
    vector<int> arr;
    for(int i = 2; i<=20; i+=2) arr.push_back(i);

    //for(int i = 0; i<arr.size(); i++) cout<< arr[i] << " ";
    cout<< endl;

    int lower = 0, upper = arr.size()-1;
    int data; cin>> data;
    int foundAtIndex = -1;

    while(lower<=upper){
        int mid = (lower+upper)/2;
        if(arr[mid] == data) {
            foundAtIndex = mid;
            break;
        }

        if(data > arr[mid]) lower = mid+1;
        else upper = mid-1;
    }

    cout<< foundAtIndex << " ";

    return 0;
}