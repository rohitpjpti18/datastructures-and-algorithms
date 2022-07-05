package src.array;

public class SortColor {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left, right, mid;
        left = mid = 0;
        right = n-1;

        while(mid<=right){
            switch(nums[mid]) {
                case 0: {
                    swap(nums, left, mid);
                    ++left;
                    ++mid;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    swap(nums, right, mid);
                    --right;
                    break;
                }
            }
        }
    }

    public void swap(int[] nums, int a, int b){
        // nums[a] = nums[a] + nums[b];
        // nums[b] = nums[a] - nums[b];
        // nums[a] = nums[a] - nums[b];
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
