package problems.array;

public class KadaneAlgorithm {    
    /* 
    // Dynamic Programming Approach
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        
        for(int i = 0; i<n; i++){
            maxEndingHere += nums[i];
            maxSoFar = Math.max(maxSoFar, maxEndingHere);    
            if(maxEndingHere < 0) maxEndingHere = 0;
        }
        
        return maxSoFar;
    }
    */

    // Divide and conquer approach
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length-1);
    }

    public int divideAndConquer(int[] nums, int left, int right){
        if(left == right) return nums[left];

        int mid = left + (right-left)/2;
        return Math.max(
            Math.max(
                divideAndConquer(nums, left, mid), 
                divideAndConquer(nums, mid+1, right)
                ), 
            maxMidSum(nums, left, mid, right)
        );
    }

    public int maxMidSum(int[] nums, int left, int mid, int right){
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for(int i = mid; i>=left; --i){
            sum += nums[i];
            if(leftSum < sum) leftSum = sum;
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for(int i = mid+1; i<=right; ++i){
            sum += nums[i];
            if(rightSum < sum) rightSum = sum;
        }
        
        return Math.max(
            leftSum + rightSum, 
            Math.max(leftSum, rightSum)
        );
    }
}
