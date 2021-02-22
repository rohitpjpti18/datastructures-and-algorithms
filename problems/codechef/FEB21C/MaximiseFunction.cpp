#include<bits/stdc++.h>
using namespace std;

int main(){

    freopen("input.txt", "r", stdin);

    int t;
    cin>>t;

    long n;
    while(t--){
        vector<long> arr;

        cin>> n;
        for(long i = 0; i<n; i++){
            long temp;
            cin>> temp;
            arr.push_back(temp);
        }

        sort(arr.begin(), arr.end());

        int a1, a2, a3;
        a1 = arr[0];
        a2 = arr[n-1];
        a3 = arr[1];

        long maximum = abs(a1-a2) + abs(a2-a3) + abs(a3-a1);
        for(long i = 2; i<n-1; i++){
            maximum = max(maximum, abs(a1-a2)+ abs(a2-arr[i]) + abs(arr[i]-a1));
        }

        cout<< maximum << endl;
    }

    return 0;
}