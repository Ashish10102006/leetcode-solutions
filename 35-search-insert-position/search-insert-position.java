class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;  // safer way to calculate mid

            if (nums[mid] == target) {
                return mid; // target found
            } else if (nums[mid] < target) {
                l = mid + 1; // search right half
            } else {
                r = mid - 1; // search left half
            }
        }

        // target not found, l is insertion index
        return l;
    }
}
