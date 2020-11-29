#include<bits/stdc++.h>
#include<fstream>
using namespace std;

int partition(vector<int> &arr, int lower, int upper);
void quickSort(vector<int> &arr, int lower, int upper);
void swap(int &a, int &b);
void printArray(vector<int> &arr);

int main(){
    freopen("inputs/quickSort.txt", "r", stdin);
    vector<int> arr;
    int n;
    cin>> n;
    for(int i = 0; i<n; i++){
        int temp;
        cin>> temp;
        arr.push_back(temp);
    }

    quickSort(arr, 0, n);
    printArray(arr); 
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

int partition(vector<int> &arr, int lower, int upper){
    int pivot = upper-1;
    int yellow_ptr = lower-1;
    
    for(int green_ptr = lower; green_ptr<upper-1; green_ptr++){
        if(arr[green_ptr] < arr[pivot]){
            yellow_ptr++;
            swap(&arr[green_ptr], &arr[yellow_ptr]);
        }
    }

    swap(&arr[yellow_ptr+1], &arr[pivot]);
    
    return yellow_ptr+1;
}

void quickSort(vector<int> &arr, int lower, int upper){
    if(upper-lower>1){
        int mid = partition(arr, lower, upper);
        quickSort(arr, lower, mid);
        quickSort(arr, mid, upper);
    }
}