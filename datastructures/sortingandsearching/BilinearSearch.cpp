#include<iostream>
using namespace std;

bool bilinearSearch(int arr[], int lower_bound, int upper_bound, int value){
	int mid;
	if(upper_bound - lower_bound == -1){
		return false;
	}else{
		mid = (lower_bound + upper_bound)/2;
		if(arr[mid] == value){
			return true;
		}else if(arr[mid] > value){
			return bilinearSearch(arr, lower_bound, mid-1, value);
		}else{
			return bilinearSearch(arr, mid+1, upper_bound, value);
		}
	}
}

int main(){
	int arr[] = {1, 4, 5, 6, 8, 10};
	int value;
	cin>> value;
	cout<< bilinearSearch(arr, 0, 5, value) << endl;

	return 0;
}
