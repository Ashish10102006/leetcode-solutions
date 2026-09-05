class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int maximum_upto_index_i[] = new int[n];

        // Prefix maximum
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                maximum_upto_index_i[i] = nums[i];
            } else {
                maximum_upto_index_i[i] =
                    Math.max(nums[i], maximum_upto_index_i[i - 1]);
            }
        }

        int minimum_from_index_i[] = new int[n];

        // Suffix minimum
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                minimum_from_index_i[i] = nums[i];
            } else {
                minimum_from_index_i[i] =
                    Math.min(nums[i], minimum_from_index_i[i + 1]);
            }
        }

        // Find smallest stable index
        for (int i = 0; i < n; i++) {
            if (maximum_upto_index_i[i] -
                minimum_from_index_i[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}