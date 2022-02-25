#include<iostream>
using namespace std;

void swap(int* a, int *b){
	int temp = *a;
	*a = *b;
	*b = temp;
}


void InsertionSort(int arr[], int length){
	int j;
	
	for(int i=0; i<length; i++){
		j = i;
		while(j>0 && arr[j] < arr[j-1]){
			swap(&arr[j], &arr[j-1]);
			j--;
		}
	}
}


int main(){
	int arr[] = {3, 8, 1, 5, 2, 9, 4, 0, 7, 6};
	int length = 10;

	InsertionSort(arr, length);

	for(int i = 0; i < length; i++){
		cout<< arr[i] << " ";
	}
	cout<< "\n";

	return 0;
}

