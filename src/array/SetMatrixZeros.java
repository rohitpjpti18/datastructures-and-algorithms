package src.array;

public class SetMatrixZeros {
    /* 
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
     */

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

}
