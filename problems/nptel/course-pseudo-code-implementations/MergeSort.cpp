#include<iostream>
#include<vector>
using namespace std;

void merge(vector<int> &arr, int lower, int mid, int upper);
void mergeSort(vector<int> &arr, int lower, int upper);
void printArray(vector<int> &arr);

int main(){
    vector<int> arr;    
    int n;
    cin>> n;
    for(int i = 0; i<n; i++){
        int temp;
        cin>> temp;
        arr.push_back(temp);
    }

    mergeSort(arr, 0, n);
    printArray(arr);
    return 0;
}



void merge(vector<int> &arr, int lower, int mid, int upper){
    vector<int> temp_arr;
    int i = lower, j = mid;
    int k = 0;
    while(k < upper-lower){
        if(i!=mid && (j >=upper || arr[i]<=arr[j])){
            temp_arr.push_back(arr[i]);
            i++; k++;
        }
        else{
            temp_arr.push_back(arr[j]);
            j++; k++;
        }
    }

    for(int a = 0, x = lower; x<upper; x++, a++){
        arr[x] = temp_arr[a];
    }
}

void mergeSort(vector<int> &arr, int lower, int upper){
    if(upper - lower > 1){
        int mid = (lower+upper)/2;
        mergeSort(arr, lower, mid);
        mergeSort(arr, mid, upper);
        merge(arr, lower, mid, upper);
    }
}

void printArray(vector<int> &arr){
    for(auto i: arr){
        cout<< i << " ";
    }
    cout<< endl;
}