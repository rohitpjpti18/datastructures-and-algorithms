/*
Given two sequences, find the length of longest subsequence present in both of 
them. A subsequence is a sequence that appears in the same relative order, but 
not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, 
.. etc are subsequences of “abcdefg”. 

reference
https://www.youtube.com/watch?v=jHGgXV27qtk

*/
#include<iostream>
#include<string>
using namespace std;

int max(int a, int b){
    return a>b ? a : b;
}


int lcs(string a, string b, int lenA, int lenB){
    if(lenA == 0 || lenB == 0){
        return 0;
    }
    if(a[lenA-1] == b[lenB-1]){
        return (1 + lcs(a, b, lenA-1, lenB-1));
    }else{
        return max(
            lcs(a, b, lenA-1, lenB), 
            lcs(a, b, lenA, lenB-1)
            );
    }
}


void testLcs(){
    bool output = true;
    string testA = "abaaba";
    string testB = "babbab";

    int result = lcs(testA, testB, testA.size(), testB.size());
    if(result != 4){
        cout<< "Failed: expected 4 got " << result << endl;
        output = false;
    }

    testA = "aedfhr";
    testB = "abcdgh";
    result = lcs(testA, testB, testA.size(), testB.size());
    if(result != 3){
        cout<< "Failed: expected 3 got " << result << endl;
        output = false;
    }

    testA = "aggtab";
    testB = "gxtxayb";
    result = lcs(testA, testB, testA.size(), testB.size());
    if(result != 4){
        cout<< "Failed: expected 4 got " << result << endl;
        output = false;
    }

    if(output){
        cout<< "OK.... all cases Passed"<< endl;
    }
}


int main(){
    testLcs();

    return 0;
}
