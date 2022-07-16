package src.recursion;

import java.util.ArrayList;
import java.util.List;

public class Nqueen {
    public boolean canPutItHere(char[][] board, int row, int col) {
        for(int i = 0; i<board.length; i++){
            if(board[row][i] == 'Q') return false;
            if(board[i][col] == 'Q') return false;
        }
        
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                if(i-j == row-col && board[i][j] == 'Q') return false;
                if(i+j == row+col && board[i][j] == 'Q') return false;
            }
        }
        
        return true;
    }
    
    public void solve(char[][] board, int row, int n, List<List<String>> result) {
        if(row == n) {
            List<String> temp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i<n; i++) {
                sb = new StringBuilder();
                for(int j = 0; j<n; j++) {
                    sb.append(board[i][j]);        
                }
                temp.add(sb.toString());
            }
            
            result.add(temp);
            return;
        }
        
        for(int i = 0; i<n; i++){
            if(canPutItHere(board, row, i)) {
                board[row][i] = 'Q';
                solve(board, row+1, n, result);
                board[row][i] = '.';
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';        
            }
        }
        
        solve(board, 0, n, result);
        
        return result;
    }    
}
