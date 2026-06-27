class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] directions = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},          {0,1},
            {1,-1},  {1,0},  {1,1}
        };
         // Step 1: compute next state using encoding
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int liveNeighbors = countLive(board, i, j, m, n, directions);

                // Rule for live cell
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2; // live -> dead
                    }
                }
                // Rule for dead cell
                else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 3; // dead -> live
                    }
                }
            }
        }
         // Step 2: finalize board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                if (board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
     private int countLive(int[][] board, int r, int c, int m, int n, int[][] directions) {
        int count = 0;
        for(int []d:directions){
             int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                // only original live cells count (1 or 2)
                if (board[nr][nc] == 1 || board[nr][nc] == 2) {
                    count++;
                }
            }
        }
        return count;
    }
}