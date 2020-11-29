#include<iostream>
#include<bits/stdc++.h>
using namespace std;


int main(){
    int t;

    cin>> t;

    while(t--){
        int n;

        cin>> n;
        vector<int> C(n);


        for(int i =0; i<n; i++){
            cin>> C[i];
        }
        sort(C.begin(), C.end(), greater<int>());

        int n1=0, n2=0; 
        for(int i = 0; i<n; i++){
            if(n1<n2){
                n1 += C[i];
            }else{
                n2 += C[i];
            }
        }

        cout<< max(n1, n2) << endl;
    }

    return 0;
}
