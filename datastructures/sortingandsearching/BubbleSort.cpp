#include<iostream>
using namespace std;

void swap(int* a, int* b){
	int temp = *a;
	*a = *b;
	*b = temp;
}

void bubbleSort(int arr[]){
	int n = 5;
	int flag = 0;
	
	for(int i = 0; i < n-1; i++){
		flag = 0;
		for(int j = 0; j < n-1-i; j++){
			if(arr[j] > arr[j+1]){
				swap(&arr[j], &arr[j+1]);
				flag = 1;
			}
		}
		if(flag == 0){
			break;
		}
	}
}

int main(){
	int arr[] = {16, 14, 5, 6, 8};

	bubbleSort(arr);
	for(int i = 0; i < 5; i++)
		cout<< arr[i] << " ";
	cout<< endl;

	return 0;
}
