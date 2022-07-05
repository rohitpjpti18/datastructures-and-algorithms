
# Maximum Subarray Sum | [Leetcode](https://leetcode.com/problems/maximum-subarray/)


&larr; [Back to Interview Preparation](../../InterviewPreparation.md)

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

**Example 1**

```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```
**Example 2**

```
Input: nums = [1]
Output: 1
```
**Example 3**

```
Input: nums = [5,4,-1,7,8]
Output: 23
```

**Constraints:**

- `1 <= nums.length <= 10`<sup>5</sup>
- `-10`<sup>4</sup>` <= nums[i] <= 10`<sup>4</sup>

**Follow up:** If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

## JAVA

### Dynamic Programming approch (O(n)) (Kadane's Algorithm)
```java
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
```
### Divide and Conquer approach (O(nlogn))

```java
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
```

&larr; [Back to Interview Preparation](../../InterviewPreparation.md)