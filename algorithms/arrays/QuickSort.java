package algorithms.arrays;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] arr, Integer a, Integer b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int lowerPtr = left-1;

        for(int i = left; i<right; i++){
            if(arr[i] < pivot){
                swap(arr, ++lowerPtr, i);
            }
        }

        swap(arr, ++lowerPtr, right);
        return lowerPtr;
    }

    public static void quickSortAlgorithm(int[] arr, int left, int right){
        if(left<right){
            int mid = partition(arr, left, right);
            quickSortAlgorithm(arr, left, mid-1);
            quickSortAlgorithm(arr, mid+1, right);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{23, 32, 5, 42, 78, 35, 60, 93, 24, 46};
        System.out.println(Arrays.toString(arr));
        quickSortAlgorithm(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
