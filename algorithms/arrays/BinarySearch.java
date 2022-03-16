package algorithms.arrays;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearchIterative(int[] arr, int left, int right, int target){
        //Arrays.sort(arr);
        // int left = 0;
        // int right = arr.length-1;

        while(left<=right){     
            int mid = left + (right-left)/2;

            if(arr[mid] == target){
                return mid;
            }

            if(arr[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;
    }

    // for rotated sorted array
    public static int specialBinarySearchIterative(int[] arr){
        int left = 0, right=arr.length-1, mid;

        while(left<=right){
            mid = left + (right-left)/2;

            if(left == right){
                return left;
            }

            if(mid<right && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(arr[left] > arr[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = new int[]{63, 72, 81, 92, 9, 11, 23, 35, 46, 52 };
        int pivot = specialBinarySearchIterative(arr);
        System.out.println(pivot);
        System.out.println(binarySearchIterative(arr, 0, pivot, 72));
        System.out.println(binarySearchIterative(arr, pivot+1, arr.length-1, 72));
    }
}
