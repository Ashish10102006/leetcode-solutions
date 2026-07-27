class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low=0;
        int high=m*n-1;

        while(low<=high){
            int mid= low + (high - low) / 2;;

            int row=mid/n;
            int col=mid%n;

            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target)  low = mid + 1;
            else high=mid-1;
        }
        return false;
    }
}
// mid represents the index of the middle element in the imaginary flattened 1D sorted array. Since the matrix is physically stored as a 2D array, convert this index into its actual position using:

// row = mid / n (divide by the number of columns)
// col = mid % n (remainder gives the column)

// Then access the element as matrix[row][col] and continue the binary search.