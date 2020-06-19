/*
problem statement
Given two strings str1 and str2 and below operations that can performed on str1. Find
minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

    Insert
    Remove
    Replace

All of the above operations are of equal cost.
*/
#include<iostream>
#include<string>
using namespace std;

int min(int a, int b, int c){
    if(a<b && a<c){
        return a;
    }else{
        return b<c ?  b : c;
    }
}

int editDistance(string a, string b, int lenA, int lenB){
    if(lenA == 0){
        return lenB;
    }
    if(lenB == 0){
        return lenA;
    }
    if(a[lenA-1] == b[lenB-1]){
        return editDistance(a, b, lenA-1, lenB-1);
    }else{
        return 1 + min(editDistance(a, b, lenA-1, lenB-1),
            editDistance(a, b, lenA-1, lenB),
            editDistance(a, b, lenA, lenB-1)
        );
    }
}


void testEditDistance(){
    bool output = true;
    string a, b;
    int result;

    // test case 1;
    a = "secret"; b = "bisect";
    result = editDistance(a, b, a.size(), b.size());
    if(result != 4){
        cout<< "Failed: expected 4 got "<< result<< endl;
        output = false;
    }

    // test case 2;
    a = "sunday"; b = "saturday";
    result = editDistance(a, b, a.size(), b.size());
    if(result != 3){
        cout<< "Failed: expected 3 got "<< result<< endl;
        output = false;
    }

    if(output){
        cout<< "OK.... all cases passed."<< endl;
    }
}


int main(){
    testEditDistance();

    return 0;
}
