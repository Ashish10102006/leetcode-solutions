class Solution {
    public int search(int[] nums, int target) {
        int left =0;int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target) return mid;
    // LEFT half is sorted
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1;  // go left
            } else {
                left = mid + 1;   // go right
            }
        }
        // RIGHT half is sorted
        else {
            if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;   // go right
            } else {
                right = mid - 1;  // go left
            }
             }
         }
         return -1;
    }
}