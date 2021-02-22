#include<bits/stdc++.h>
using namespace std;

void getPrimes(vector<int> &nums, vector<int> &prime){
    for(int i = 2; i<nums.size(); i++){
        if(nums[i] == -1){
            for(int j = i+i; j<nums.size(); j+=i){
                if(nums[j] == -1)
                    nums[j] = i;
            }
        }
    }

    for(int i = 2; i<nums.size(); i++){
        if(nums[i] == -1)
            prime.push_back(i);
    }
}


int main(){
    int t;
    cin>> t;

    vector<int> *nums = new vector<int>(100, -1);
    vector<int> prime;

    getPrimes(*nums, prime);

    delete nums;

    while(t--){
        int n;
        cin>>n;

        vector<int> A(n, -1);
        vector<int> B(n);

        for(int i = 0; i< n; i++){
            int temp; cin>> temp;
            B[i] = temp-1;
        }
        int f = 0;
        for(int i = 0; i<n; i++){
            if(A[B[i]] == -1){
                A[B[i]] = prime[f];
                f++;
            }
        }

        for(int i = 0; i<n; i++){
            if(A[i] == -1){
                A[i] = A[B[i]];
            }
        }

        for(int i = 0; i<n ; i++){
            cout<< A[i] << " ";
        }
        cout<< endl;
    }

    return 0;
}