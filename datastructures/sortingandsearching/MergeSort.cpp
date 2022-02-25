#include<iostream>
using namespace std;

void merge(int arr[], int lower_limit, int mid, int upper_limit){
	int sorted_arr[upper_limit-lower_limit];
	int i = lower_limit;
	int j = mid;
	int k = 0;

	while(k < upper_limit - lower_limit){
		if(i != mid && (j >= upper_limit || arr[i] <= arr[j])){
			sorted_arr[k] = arr[i];
			k++; i++;
		}else{
			sorted_arr[k] = arr[j];
			k++; j++;
		}
	}

	for(int x = lower_limit, k=0; x < upper_limit; x++, k++){
		arr[x] = sorted_arr[k];
	}
}

void mergeSort(int arr[], int lower_limit, int upper_limit){
	int mid;

	if(upper_limit - lower_limit > 1){
		mid = (lower_limit + upper_limit)/2;
		mergeSort(arr, lower_limit, mid);
		mergeSort(arr, mid, upper_limit);
		merge(arr, lower_limit, mid, upper_limit);
	}
}


int main(){
	int arr[] = {3, 8, 1, 5, 2, 9, 4, 0, 7, 6};
	int length = 10;

	mergeSort(arr, 0, 10);

	for(int i = 0; i<length; i++){
		cout<< arr[i] << " ";
	}
	cout<< "\n";

	return 0;
}
