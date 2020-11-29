#include<bits/stdc++.h>
using namespace std;

void swap(int *a, int *b);
void printArray(vector<int> &arr);

int main(){
    vector<int> arr;
    int n;
    freopen("inputs/quickSort.txt", "r", stdin);

    cin>> n;
    for(int i = 0; i<n; i++){
        int temp; 
        cin>> temp;
        arr.push_back(temp);
    }

    for(int i = 0; i<n; i++){

        int yellow_ptr = i;
        while(yellow_ptr>0){
            if(arr[yellow_ptr] < arr[yellow_ptr-1])
                swap(&arr[yellow_ptr], &arr[yellow_ptr-1]);
            else
                break;
            yellow_ptr--;
        }
    }

    printArray(arr);
    return 0;
}

void printArray(vector<int> &arr){
    for(auto i: arr) cout<< i << " ";
    cout<< endl;
}

void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}