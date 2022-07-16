package src.array3;

public class GridPaths {
    public int recursive(int i, int j, int m, int n, int[][] dp) {
        if(i >= m-1) return 1;
        if(j >= n-1) return 1;
        
        if(dp[i][j] == -1){
            dp[i][j] = recursive(i+1, j, m, n, dp) + recursive(i, j+1, m, n, dp);
        } 
        
        return dp[i][j]; 
    }
    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return recursive(0, 0, m, n, dp);
    }
}
