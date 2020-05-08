// even when all the elements are negative
#include<iostream>
#include<vector>
using namespace std;

int maxSubArraySum(vector<int> num){
    int max_so_far = a[0];
    int current_max = a[0];

    for(int i = 1; i<num.size(); i++){
        current_max = max(a[i], current_max + a[i]);
        max_so_far = max(max_so_far, current_max);
    }

    return max_so_far;
}


