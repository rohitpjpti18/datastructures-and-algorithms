package src.array;

public class NextPermutation {
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void reverse(int[] nums, int a, int b){
        while(a < b) swap(nums, a++, b--); 
    }
    
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int a = n-2;
        
        while(a >= 0 && nums[a] >= nums[a+1]) --a;
        
        if(a >= 0){
            int b = n-1;
            while(nums[b] <= nums[a]) --b;
            swap(nums, a, b);
        }
        
        reverse(nums, a+1, n-1);
    }
}
