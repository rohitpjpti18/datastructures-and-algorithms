#include<iostream>
#include<vector>
using namespace std;

int main(){
    int n;
    cin>> n;
    vector<int> arr(n, 0);
    for(int i = 0; i<n; i++){
        cin>> arr[i];
    }


    int maxSoFar = INT32_MIN;
    int maxEndingHere = 0;


    for(int i = 0; i<n; i++){
        maxEndingHere = maxEndingHere + arr[i];
        if(maxSoFar < maxEndingHere) maxSoFar = maxEndingHere;
        if(maxEndingHere < 0) maxEndingHere = 0;
    }

    cout << maxSoFar;

    return 0;
}