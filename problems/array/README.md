# Set Zero Matrix | [Leetcode](https://leetcode.com/problems/set-matrix-zeroes/)

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

**Example 1**

```
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
```
**Example 2**

```
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
```

**Constraints:**

- `m == matrix.length`
- `n == matrix[0].length`
- `1 <= m, n <= 200`
- `-2` <sup>31</sup> `<= matrix[i][j] <= 2`<sup>31</sup>` - 1`
 

**Follow up:**

-   A straightforward solution using O(mn) space is probably a bad idea.
-   A simple improvement uses O(m + n) space, but still not the best solution.
-   Could you devise a constant space solution?

## JAVA

### Simple Solution

```java
// Simple Solution, Takes O(n) space as well
public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    
    boolean[] rows = new boolean[m];
    boolean[] cols = new boolean[n];
    
    for(int i = 0; i<m; i++){
        for(int j = 0; j<n; j++){
            if(matrix[i][j] == 0){
                rows[i] = true;
                cols[j] = true;
            }
        }
    }
    
    for(int i = 0; i<m; i++){
        for(int j = 0; j<n; j++){
            if(rows[i] || cols[j]){
                matrix[i][j] = 0;
            }
        }
    }
}
```

#### In Place Solution

```java
public static void setZeroes(int[][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;
    Boolean col0 = true;

    for(int i = 0; i<m; i++) {
        if(matrix[i][0] == 0) col0 = false;
        for(int j = 0; j<n; j++) {
            if(matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
        }
    }

    for(int i = m-1; i>=0; i--){
        for(int j = n-1; j>=1; j--){
            if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;        
        }

        if(!col0) matrix[i][0] = 0;
    }
}
```

# Pascal's Triangle | [Leetcode](https://leetcode.com/problems/pascals-triangle/)

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

**Example 1**

```
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```
**Example 2**

```
Input: numRows = 1
Output: [[1]]
```

**Constraints:**

- `1 <= numRows <= 30`

## JAVA

### Generate all the the rows
```java 
public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    temp.add(1);

    int counter = 0;
    result.add(temp);
    
    for(int i = 1; i<numRows; i++){
        List<Integer> newTemp = new ArrayList<>();
        newTemp.add(1);
        for(int a = 0; a<counter; a++){
            newTemp.add(temp.get(a) + temp.get(a+1));
        }
        counter++;
        newTemp.add(1);
        result.add(newTemp);
        temp = newTemp;
    }
    
    return result;
}
```

### Generate only given row
```java 
public List<Integer> getRow(int rowIndex) {
    List<Integer> temp = new ArrayList<>();
    temp.add(1);

    int counter = 0;
    
    for(int i = 1; i<rowIndex; i++){
        List<Integer> newTemp = new ArrayList<>();
        newTemp.add(1);
        for(int a = 0; a<counter; a++){
            newTemp.add(temp.get(a) + temp.get(a+1));
        }
        counter++;
        newTemp.add(1);
        temp = newTemp;
    }
    
    return temp;
}
```

# Next Permutation | [Leetcode](https://leetcode.com/problems/next-permutation/)

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

```
For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
```

The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

- For example, the next permutation of <br>
    `arr = [1,2,3]` is `[1,3,2]`.
- Similarly, the next permutation of <br> `arr = [2,3,1]` is `[3,1,2]`.
- While the next permutation of `arr = [3,2,1]` is `[1,2,3]` because `[3,2,1]` does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of `nums`.

The replacement must be **in place** and use only constant extra memory.

**Example 1**

```
Input: nums = [1,2,3]
Output: [1,3,2]
```
**Example 2**

```
Input: nums = [3,2,1]
Output: [1,2,3]
```
**Example 3**

```
Input: nums = [1,1,5]
Output: [1,5,1]
```

**Constraints:**

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 100`

## JAVA

```java
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
```

# Maximum Subarray Sum | [Leetcode](https://leetcode.com/problems/maximum-subarray/)

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

# Buy and sell stocks | [Leetcode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`<sup>th</sup> day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

**Example 1:**
```
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

**Example 2:**
```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
```

**Constraints:**

- `1 <= prices.length <= 10`<sup>5</sup>
- `0 <= prices[i] <= 10`<sup>4</sup>

## JAVA

```java
public int maxProfit(int[] prices) {
    int n = prices.length;
    int min = prices[0];
    int maxDiff = Integer.MIN_VALUE;
    
    for(int i = 1; i<n; i++){
        maxDiff = Math.max(maxDiff, prices[i] - min);
        min = Math.min(min, prices[i]);
    }
    
    return Math.max(0, maxDiff);
}
```
