package algorithms.arrays;

import java.util.*;

public class RotatedSorted {

    public static long binarySearch(Vector<Long> arr, long searchValue){
        int left = 0, right = arr.size()-1, mid;

        while(left<=right){
            mid =(int) (left+right)/2;
            
            if(arr.get(mid).equals(searchValue)){
                return mid;
            }
            else if(arr.get(mid) < searchValue){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return (long) -1;
    }

    //  2 3 4 5 6 7 8 9 10 11 12 1
    // to find the dividing point in the array.
    public static long specialBinary(Vector<Long> arr){
        int left = 0, right = arr.size()-1, mid;

        while(left<=right){
            mid = (left+right)/2;

            if(left == right){
                return left;
            }

            if(mid < right && arr.get(mid) > arr.get(mid+1)){
                return mid;
            }
            else if(arr.get(left) > arr.get(mid)){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }

        return (long) -1;
    }

    public static void main(String[] args){
        Vector<Long> arr = new Vector<Long>();
       
        arr.add((long) 7);
        arr.add((long) 8);
        arr.add((long) 9);
        arr.add((long) 10);
        arr.add((long) 1);
        arr.add((long) 2);
        arr.add((long) 3);
        arr.add((long) 4);
        arr.add((long) 5);
        arr.add((long) 6);
        
        System.out.println(specialBinary(arr));
    }
}
