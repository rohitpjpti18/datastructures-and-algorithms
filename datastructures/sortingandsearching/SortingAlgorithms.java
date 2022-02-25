package datastructures.sortingandsearching;


public class SortingAlgorithms{

    public static void printList(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static int[] bubbleSort(int[] arr){
        for(int i = 0; i<arr.length-1; i++){
            boolean flag = true;
            for(int j = 0; j<arr.length-1-i; j++ ){
                if(arr[j] > arr[j+1]){
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(flag){
                break;
            }
        }

        return arr;
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int[] tempArr = new int[high-low];
        
        int i = low;
        int j = mid;
        int k = 0;

        while(k < (high - low)){
            if(i < mid && (j >= high || arr[i] < arr[j])){
                tempArr[k] = arr[i];
                k++; i++;
            }else{
                tempArr[k] = arr[j];
                k++; j++;
            }
        }

        for(int a = 0; a<high-low; a++){
            arr[low+a] = tempArr[a];
        }
    }


    public static void mergeSort(int[] arr, int low, int high){
        if(high-low > 1){
            int mid = (low+high)/2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid, high);
            merge(arr, low, mid, high);

        }
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int lowerPtr = left - 1;

        for(int i = left; i<right; i++){
            if(arr[i] < pivot){
                lowerPtr++;

                // swap
                int temp = arr[lowerPtr];
                arr[lowerPtr] = arr[i];
                arr[i] = temp;
            }
        }

        lowerPtr++;

        // swap
        int temp = arr[lowerPtr];
        arr[lowerPtr] = pivot;
        arr[right] = temp;

        return lowerPtr;
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left<right){
            int mid = partition(arr, left, right);
            quickSort(arr, left, mid-1);
            quickSort(arr, mid+1, right);
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{5, 4, 1, 2, 6, 3, 3};

        //arr = bubbleSort(arr);
        mergeSort(arr, 0, arr.length);
        printList(arr);
        
    }
}