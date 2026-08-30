class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        int minElement = nums[0];
        int maxElement = nums[0];

        // Step 1: Find minimum and maximum values
        for (int i = 0; i < n; i++) {
            minElement = Math.min(minElement, nums[i]);
            maxElement = Math.max(maxElement, nums[i]);
        }

        // Step 2: Find their indices
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == minElement) {
                minIndex = i;
            }

            if (nums[i] == maxElement) {
                maxIndex = i;
            }
        }

         // Step 3: Put the two indices in order
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

         // Step 4: Three possible ways
        int fromFront = right + 1;
        int fromBack = n - left;
        int fromBoth = (left + 1) + (n - right);

        // Step 5: Take minimum
        return Math.min(fromFront, Math.min(fromBack, fromBoth));

    }
}