#include<iostream>
#include<bits/stdc++.h>
using namespace std;


long lcw(string strA, string strB, long lenA, long lenB){
    vector<vector<long>> arr(lenA+1, vector<long>(lenB+1, 0));
    
    //long result = 0;
    for(int i = lenA-1; i >= 0; i--){
        for(int j = lenB-1; j >= 0; j--){
            if(strA[i] == strB[j]){
                arr[i][j] = 1 + arr[i+1][j+1];
            }
        }
    }

    long maxElement = LONG_MIN;
    //cout<< maxElement;
    for(int i = lenA-1; i >= 0; i--){
        for(int j = lenB-1; j >= 0; j--){
            if(arr[i][j] > maxElement){
                maxElement = arr[i][j];
            }
        }
    }

    return maxElement;

}

void testLcw(){
    bool output = true;
    string testA = "abaaba";
    string testB = "babbab";

    int result = lcw(testA, testB, testA.size(), testB.size());
    if(result != 2){
        cout<< "Failed: expected 2 got " << result << endl;
        output = false;
    }

    testA = "aedfhr";
    testB = "abcdgh";
    result = lcw(testA, testB, testA.size(), testB.size());
    if(result != 1){
        cout<< "Failed: expected 1 got " << result << endl;
        output = false;
    }

    testA = "aggtab";
    testB = "gxtxayb";
    result = lcw(testA, testB, testA.size(), testB.size());
    if(result != 1){
        cout<< "Failed: expected 1 got " << result << endl;
        output = false;
    }

    testA = "geeksforgeeks";
    testB = "geeksquiz";
    result = lcw(testA, testB, testA.size(), testB.size());
    if(result != 5){
        cout<< "Failed: expected 5 got " << result << endl;
        output = false;
    }

    testA = "abcdxyz";
    testB = "xyzabcd";
    result = lcw(testA, testB, testA.size(), testB.size());
    if(result != 4){
        cout<< "Failed: expected 4 got " << result << endl;
        output = false;
    }

    testA = "zxabcdezy";
    testB = "yzabcdezx";
    result = lcw(testA, testB, testA.size(), testB.size());
    if(result != 6){
        cout<< "Failed: expected 6 got " << result << endl;
        output = false;
    }

    if(output){
        cout<< "OK.... all cases Passed"<< endl;
    }
}


int main(){
    testLcw();

    return 0;
}
