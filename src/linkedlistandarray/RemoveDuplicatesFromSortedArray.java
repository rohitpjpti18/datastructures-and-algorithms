package src.linkedlistandarray;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int p1, p2, n;
        n = nums.length;
        p1 = p2 = 0;
        
        while(p2 < n) {
            if(nums[p1] == nums[p2]) p2++;
            else {
                nums[++p1] = nums[p2];
                p2++;
            }
        }
        
        return p1 + 1;
    }
}
