#include<iostream>
using namespace std;

// implementation of fibonacci series using dynamic programming.
long fibonacci(int n){
    long temp0 = 0;
    long temp1 = 1;

    if(n == 0 || n == 1) return n;

    long tempn;
    for(long i=2; i<=n; i++){
        tempn = temp0 + temp1;
        temp0 = temp1;
        temp1 = tempn;
    }

    return tempn;
}

// test function for fibonacci 
void testFibonacci(){
    long result = fibonacci(5);
    bool output= true;

    if(result != 5){
        cout<< "failed testcase n=5: expected 5 got "<< result << endl;
        output = false;
    }

    result = fibonacci(4);
    if(result != 3){
        cout<< "failed testcase n=4: expected 3 got "<< result << endl;
        output = false;
    }

    result = fibonacci(6);
    if(result != 8){
        cout<< "failed testcase n=6: expected 8 got "<< result << endl;
        output = false;
    }

    if(output){
        cout<< "OK.... all cases Passed "<< endl;
    }
}

int main(){
    testFibonacci();

    return 0;
}