// TREE2
#include<iostream>
#include<vector>
#include<set>
#include<algorithm>
using namespace std;


int main(){
    int t;
    int n;

    cin>> t;

    while(t--){
        cin>> n;
        vector<long> a(n);
        for(int i = 0; i<n; i++){
            cin>> a[i];
        }

        set<long> s;

        for(auto i : a){
            s.insert(i);
        }

        if(s.find(0) != s.end()) cout<< s.size() -1 << endl;
        else cout<< s.size() << endl;
    }
}