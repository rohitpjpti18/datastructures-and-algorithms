package src.array3;

public class Search2DMatrix {

    /* 
    // greedy approach
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int iPtr = 0, jPtr = n-1;
        
        while(jPtr >= 0 && iPtr <m){
            if(matrix[iPtr][jPtr] == target) return true;
            
            if(matrix[iPtr][jPtr] > target) jPtr--;
            else iPtr++;
        }
        
        return false;
    }
    */

    // Binary Search 
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
 
        int left, right, mid;
        left = 0;
        right = m*n-1;

        int i, j;

        while(left<=right) {
            mid = left + ((right-left)/2);
            i = mid/n;
            j = mid%n;
            
            if(matrix[i][j] == target) return true;

            if(matrix[i][j] < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}
