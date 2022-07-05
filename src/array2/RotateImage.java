package src.array2;

public class RotateImage {

    /* 
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int l, r, temp, bottom, top;
        l = 0; r = n-1;
        
        while(l<r){
            top = l; bottom = r;
            for(int i = 0; i<r-l; ++i){
                temp = matrix[top][l+i];
                matrix[top][l+i] = matrix[bottom-i][l];
                matrix[bottom-i][l] = matrix[bottom][r-i];
                matrix[bottom][r-i] = matrix[top+i][r];
                matrix[top+i][r] = temp;
            }
            ++l; --r;
        }
    }
    */

    public void rotate(int[][] matrix) {
        int temp, n = matrix.length;

        // Transponse of matrix
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }

        // Reverse of matrix
        for(int i = 0; i<n; i++){
            for(int j = 0; j < n/2; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}