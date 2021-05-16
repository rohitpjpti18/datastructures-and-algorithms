class RotatedSorteArray{

    // returns index at which the valueToFind is present in arr, returns -1 otherwise;
    public static int binarySearch(int[] arr, int left, int right, int valueToFind){
        while(left<=right){
            int center = (left+right)/2;

            if(arr[center] == valueToFind){
                return center;
            }else if(valueToFind < arr[center]){
                right = center-1;
                continue;
            }else{
                left = center+1;
            }
        }

        return -1;
    }

    public static int specialBinarySearch(int[] arr, int left, int right){
        while(left <= right){
            int center = (left+right)/2;

            if(left == right){
                return left;
            }
            if(right-left == 1){
                if(arr[left] == ;
            }

            if(arr[center] < arr[center-1] && arr[center] < arr[center+1]){
                return center;
            }else if(arr[center - 1] < arr[left]){
                right = center - 1;
            }else{
                left = center + 1;
            }
        }
    }


    public static void main(String[] args){
        int[] testArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        System.out.println(binarySearch(testArr, 0, 15, 10));
    }
}