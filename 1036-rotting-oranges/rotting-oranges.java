class Solution {
    public int orangesRotting(int[][] grid) {
        int directions[][]={
            { 1,  0 },
            {-1,  0 },
            { 0,  1 },
            { 0, -1 },
        };

        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes=0;

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                  for (int direction[] : directions) 
                  {
                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1)continue;

                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[]{nr, nc});
                }
            }
            minutes++;
        } 

        return fresh==0 ? minutes : -1;
    }
}
/*
Minute 0:
(0,0) and (2,2)   ← process both

Minute 1:
their fresh neighbors become rotten

Minute 2:
those newly rotten oranges spread again
...
*/

/*

1. Find all rotten oranges (2)
2. Put all of them into a Queue
3. BFS in 4 directions
4. Each BFS level = 1 minute
5. Count fresh oranges
6. If fresh oranges remain → return -1
7. Otherwise → return minutes
*/

/*
n this problem, we're talking about row and column positions in a 2D matrix, not a number line.

For a matrix:

       col
        0   1   2
row 0   A   B   C
    1   D   E   F
    2   G   H   I

From E (1,1):

{1,0} → row increases → down
{-1,0} → row decreases → up
{0,1} → column increases → right
{0,-1} → column decreases → left
*/
