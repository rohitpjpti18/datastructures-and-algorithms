#include<iostream>
#include<vector>
using namespace std;

//
// count the ways to reach the nth stair using multiple 1, and 2 steps. 
// n = no. of stairs
//
int simpleStaircase(int n){
    vector<int> arr(n+1, 0);

    arr[0] = 1; arr[1] = 1; arr[2] = 2;

    for(int i = 3; i < n+1; i++){
        arr[i] = arr[i-1] + arr[i-2];
    }

    return arr[n]; 
}

//
// count the ways to reach the nth stair using multiple 1, and 2 steps and a single step 3 only once.
//
int modifiedStaircase(int n){
    vector<int> withArr(n+1, 0);
    vector<int> withoutArr(n+1, 0);

    withArr[0] = 0; withArr[1] = 0; withArr[2] = 0; withArr[3] = 1;
    withoutArr[0] = 1; withoutArr[1] = 1; withoutArr[2] = 2; withoutArr[3] = 3;

    for(int i = 4; i<n+1; i++){
        withArr[i] = withArr[i-1] + withArr[i-2] + withoutArr[i-3];
        withoutArr[i] = withoutArr[i-1] + withoutArr[i-2];
    }

    return withArr[n];
}


void testModifiedStaircase(){
    bool output=true;
    int result;

    cout<< modifiedStaircase(5) << endl;
}

int main(){
    testModifiedStaircase();

    return 0;
}


