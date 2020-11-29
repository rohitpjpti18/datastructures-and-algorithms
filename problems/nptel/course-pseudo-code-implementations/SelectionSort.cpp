#include<bits/stdc++.h>
using namespace std;

void swap(int *a, int *b);
void printArray(vector<int> &arr);

int main(){
    freopen("inputs/quickSort.txt", "r", stdin);
    int n;
    vector<int> arr;

    cin>> n;
    for(int i = 0; i<n; i++){
        int temp; 
        cin>> temp;
        arr.push_back(temp);
    }

    for(int yellow_ptr=0; yellow_ptr<n; yellow_ptr++){
        int red_ptr = yellow_ptr;
        for(int j = yellow_ptr; j<n; j++){
            if(arr[j] < arr[red_ptr]){
                red_ptr = j;
            }
        }
        swap(&arr[yellow_ptr], &arr[red_ptr]);
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