/*
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(pq.size()<k){
                    pq.add(matrix[i][j]);
                }
                else{
                    if(pq.peek()>matrix[i][j]){
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();

    }
}
*/
// Approach=Binary Search on the Answer
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while(low<high){
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if(count<k)low=mid+1;
            else high=mid;
        }

        return low;
    }
    private int countLessEqual(int[][] matrix, int mid) {
        int n = matrix.length;
        int row = n - 1; // Start from bottom-left
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {

            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}    