import java.util.*;

class Solution {

    // Check if queen placement is safe
    public boolean isSafe(char[][] board, int row, int col, int n) {

        // Check upper column
        int i = row - 1;
        while (i >= 0) {
            if (board[i][col] == 'Q') {
                return false;
            }
            i--;
        }

        // Check upper left diagonal
        i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        // Check upper right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    // Backtracking function
    public void solve(char[][] board, int row, int n,
                      List<List<String>> ans) {

        // Base case
        if (row == n) {

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        // Try every column
        for (int j = 0; j < n; j++) {

            if (isSafe(board, row, j, n)) {

                // Place queen
                board[row][j] = 'Q';

                // Recursive call
                solve(board, row + 1, n, ans);

                // Backtracking
                board[row][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        // Create board
        char[][] board = new char[n][n];

        // Fill with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, n, ans);

        return ans;
    }
}