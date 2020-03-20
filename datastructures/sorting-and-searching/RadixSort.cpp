#include<iostream>
using namespace std;

int get_maximum(int arr[], int length){
	int max = -1;
	for(int i = 0; i < length; i++){
		if(arr[i] > max) max = arr[i];
	}
	
	return max;
}

void countSort(int arr[], int length, int pos, int sorted_arr[]){
	int count_arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	for(int i = 0; i < length; i++)
		count_arr[(arr[i]/pos)%10]++;
	
	for(int i=1; i<10; i++)
		count_arr[i] += count_arr[i-1];
	
	for(int i = length-1; i>=0; i--)
		sorted_arr[--count_arr[(arr[i]/pos)%10]] = arr[i];
}

void radixSort(int arr[], int length, int sorted_arr[]){
	int max = get_maximum(arr, length);
	for(int pos = 1; (max/pos) > 0; pos*=10){
		countSort(arr, length, pos, sorted_arr);
		for(int i = 0; i < length; i++){
			arr[i] = sorted_arr[i];
		}
	}
}

int main(){
	int arr[] = {432, 8, 530, 90, 88, 231, 11, 45, 677, 199};
	int length = 10;
	int sorted_arr[10];

	radixSort(arr, length, sorted_arr);
	for(int i = 0; i < length; i++)
		cout<< sorted_arr[i] << " ";
	cout<< endl;

	return 0;
}
