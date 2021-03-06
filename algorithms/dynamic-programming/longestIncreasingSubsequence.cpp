// Use dynamic programming to get the best result
// time complexity: O(n^2)
// space complexity: O(n)
#include<iostream>
#include<vector>
using namespace std;

// longest increasing subsequence
int lis(vector<int> &arr, int size){
    vector<int> lisArr(size, -1);

    lisArr[0] = 1;

    for(int i = 1; i<size; i++){
        for(int j = i-1; j>=0; j--){
            if(arr[j] < arr[i] && lisArr[j] + 1 > lisArr[i]){
                lisArr[i] = lisArr[j] + 1;
            }
        }
    }

    return lisArr[size-1];
}

void testLis(){
    int result;
    int output = true;

    // test case 1
    vector<int> arr{10, 22, 9, 33, 21, 50, 41, 60, 80};
    result = lis(arr, arr.size());
    if(result != 6){
        cout<< "failed: expected 6 got " << result << endl;
        output = false;
    }

    // test case 2
    vector<int> testArr1{2, 1, 3, 4, 9, 7, 8};
    result = lis(testArr1, testArr1.size());
    if(result != 5){
        cout<< "failed: expected 5 got " << result << endl;
        output = false;
    }

    if(output){
        cout<< "OK.... all test cases passed"<< endl;
    }
}

int main(){
    testLis();

    return 0;
}
