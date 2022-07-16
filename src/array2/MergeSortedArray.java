package src.array2;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tempm = m;
        for(int i = 0; i<n; i++){
            nums1[tempm] = nums2[i];
            tempm++;
        }
        
        Arrays.sort(nums1);
    }
}
