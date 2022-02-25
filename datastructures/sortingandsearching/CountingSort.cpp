#include<iostream>
using namespace std;


// get the maximum element in array
int get_maximum(int arr[], int length){
	int max = 0;
	for(int i = 0; i < length; i++){
		if(arr[i] > max)
			max = arr[i];
	}
	return max;
}

// Counting sort
void countingSort(int arr[], int length, int sorted_arr[]){
	int max = get_maximum(arr, length);
	int count_arr[max+1];

	for(int i = 0; i < max+1; i++)
		count_arr[i] = 0;

	for(int i = 0; i<length; i++)
		++count_arr[arr[i]];

	for(int i = 1; i< max+1; i++)
		count_arr[i] += count_arr[i-1];

	for(int i = length-1; i >= 0; i--)
		sorted_arr[--count_arr[arr[i]]] = arr[i];
}

int main(){
	int arr[] = {2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9};
	int length = 17;
	int sorted_arr[17];

	countingSort(arr, 17, sorted_arr);

	for(int i = 0; i < length; i++){
		cout<< sorted_arr[i] << " ";
	}
	cout<< endl;

	return 0;
}
