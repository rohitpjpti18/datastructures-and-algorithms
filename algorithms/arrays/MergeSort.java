package algorithms.arrays;

import java.util.Arrays;

public class MergeSort {
    public static void merge(int[] arr, int left, int right, int mid){
        int i=left, j=mid+1, k=0;
        int[] tempArr = new int[right-left+1];
        while(k<tempArr.length){
            if(!(i>mid) && (j>right || arr[i]<=arr[j])){
                tempArr[k] = arr[i];
                i++;
            }else{
                tempArr[k] = arr[j];
                j++;
            }
            k++;
        }
        k=0;
        while(k<tempArr.length){
            arr[left+k] = tempArr[k];
            k++;
        }
    }

    public static void mergeSortAlgorithm(int[] arr, int left, int right){
        if(right-left>1){
            int mid = left + (right-left)/2;
            mergeSortAlgorithm(arr, left, mid);
            mergeSortAlgorithm(arr, mid+1, right);
            // System.out.printf("%d %d %d\n", left, mid, right);
            merge(arr, left, right, mid);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{23, 32, 5, 42, 78, 35, 60, 93, 24, 46};
        System.out.println(Arrays.toString(arr));
        mergeSortAlgorithm(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
