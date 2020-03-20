#include<iostream>
using namespace std;

void swap(int* a, int* b){
	int temp = *a;
	*a = *b;
       	*b = temp;
}	


void selectionSort(int arr[], int length){
	int i=0, j=i+1;

	for(i = 0; i<length-1; i++){
		for(j=i+1; j<length; j++){
			if(arr[i] > arr[j]){
				swap(&arr[i], &arr[j]);
			}
		}
	}
}


int main(){
	int arr[] = {3, 8, 1, 5, 2, 9, 4, 0, 7, 6};
	int length = 10;

	selectionSort(arr, length);

	for(int i=0; i<length; i++){
		cout<< arr[i] << " ";
	}
	cout<< "\n";

	return 0;
}
