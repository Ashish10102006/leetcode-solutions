class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        
        int lastrow = x + k - 1;

        for (int i = 0; i < k / 2; i++) {
            for (int j = y; j < y + k; j++) {  
                
                int temp = grid[x + i][j];
                grid[x + i][j] = grid[lastrow - i][j];
                grid[lastrow - i][j] = temp;
            }
        }

        return grid;
    }
}