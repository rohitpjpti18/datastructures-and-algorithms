# Set Zero Matrix | [Leetcode](https://leetcode.com/problems/set-matrix-zeroes/)

&larr; [Back to Interview Preparation](../../InterviewPreparation.md)

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

&larr; [Back to Interview Preparation](../../InterviewPreparation.md)