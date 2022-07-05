# Sort Colors | [Leetcode](https://leetcode.com/problems/sort-colors/)

Given an array `nums` with `n` objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

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

**Constraints:**

- `1 == nums.length`
- `1 <= n <= 300`
- `nums[i]` is either `0`,`1`, or `2`.

**Follow up:** Could you come up with a one-pass algorithm using only constant extra space?

## JAVA

```java
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
```