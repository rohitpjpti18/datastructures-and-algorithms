#include<iostream>
using namespace std;

void swap(int* a, int* b){
	int temp = *a;
	*a = *b;
	*b = temp;
}

int partition(int arr[], int lower_limit, int upper_limit){
	int pivot = arr[upper_limit];
	int i = lower_limit -1;

	for(int j = lower_limit; j < upper_limit; j++){
		if(arr[j] < pivot){
			i++;
			swap(&arr[i], &arr[j]);
		}
	}
	swap(&arr[i + 1], &arr[upper_limit]);
	return i + 1;
}

void quickSort(int arr[], int lower_limit, int upper_limit){
	int mid;

	if(lower_limit<upper_limit){
		mid = partition(arr, lower_limit, upper_limit);
		quickSort(arr, lower_limit, mid-1);
		quickSort(arr, mid+1, upper_limit);
	}
}

int main(){
	int arr[] = {7, 6, 10, 5, 8, 2, 31, 15, 7 };
	
	quickSort(arr, 0, 8);

	for(int i = 0; i<9; i++){
		cout << arr[i] << " ";
	}
	cout << endl;

	return 0;
}
