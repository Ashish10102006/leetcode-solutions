/*
"I'll scan every cell. When I find land that I haven't deal with yet, I'll explore all land connected to it. That gives me one island."
*/
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int islands=0;
        for( int i=0 ;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int row, int col) {

        // Outside the grid
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
            return;
        }

        // Water or already visited land
        if (grid[row][col] == '0') {
            return;
        }

        // Mark as visited
        grid[row][col] = '0';

        // Explore 4 directions
        dfs(grid, row - 1, col); // up
        dfs(grid, row + 1, col); // down
        dfs(grid, row, col - 1); // left
        dfs(grid, row, col + 1); // right
    }
}