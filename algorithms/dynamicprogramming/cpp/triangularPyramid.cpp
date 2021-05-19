// count of ways to travel a cyclic path in N steps in a triangular pyramid.
/*
  0 1 2 3 
O 1 0 3 6
A 0 1 2 7
B 0 1 2 7
C 0 1 2 7
*/
#include<iostream>
#include<vector>
using namespace std;

int triangularPyramid(int n){
    vector<vector<int>> arr(4, vector<int> (n+1, 0) );

    arr[0][0] = 1;
    arr[1][1] = 1;
    arr[2][1] = 1;
    arr[3][1] = 1;

    for(int i=2; i<n+1; i++){
        arr[0][i] = arr[1][i-1] + arr[2][i-1] + arr[3][i-1];
        arr[1][i] = arr[0][i-1] + arr[2][i-1] + arr[3][i-1];
        arr[2][i] = arr[0][i-1] + arr[1][i-1] + arr[3][i-1];
        arr[3][i] = arr[0][i-1] + arr[1][i-1] + arr[2][i-1];
    }

    return arr[0][n];
}

void testTriangularPyramid(){
    cout<< triangularPyramid(4)<< endl;
}

int main(){
    testTriangularPyramid();

    return 0;
}