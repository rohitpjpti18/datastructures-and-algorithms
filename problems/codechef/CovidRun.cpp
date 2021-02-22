// CVDRUN
#include<iostream>
#include<vector>
using namespace std;

int main(){
    int T;


    cin>> T;
    int N, K, X, Y;
    
    for(int i = 0; i<T; i++){
        cin>> N >> K >> X >> Y;
        // K is divisible by N
        vector<bool> infected(N, false);
        do{
            infected[X] = true;
            X = (X+K)%N;
        }while(!infected[X] && X != Y)
        
        if(X == Y) cout << "YES" << endl;
        else cout << "NO"<< endl
    }
}