class Solution {

    public boolean canPartition(int[] nums) {

        int total = 0;

        // Calculate total sum
        for (int num : nums) {
            total += num;
        }

        // If total sum is odd, partition is impossible
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        // dp[index][target] = answer for solve(index, target)
        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return solve(nums, 0, target, dp);
    }

    private boolean solve(int[] nums, int index, int target, Boolean[][] dp) {

        // We found a subset whose sum is target
        if (target == 0) {
            return true;
        }

        // No elements left or target became negative
        if (index == nums.length || target < 0) {
            return false;
        }

        // Already solved this state
        if (dp[index][target] != null) {
            return dp[index][target];
        }

        // Take the current element
        boolean take = solve(nums, index + 1, target - nums[index], dp);

        // Skip the current element
        boolean skip = solve(nums, index + 1, target, dp);

        // Store the answer
        dp[index][target] = take || skip;

        return dp[index][target];
    }
}
/*
/dp[s] = Can I make the sum s using the numbers I've processed so far?
boolean[] dp = new boolean[target + 1];
But here's the important part.
The DP array is not checking the total sum.

Think of it like this
Suppose:
nums = [1, 5, 11, 5]
target = 11
After processing only 1, the possible sums are:
0 ✓
1 ✓
2 ✗
3 ✗
...
11 ✗

After processing 5, the possible sums become:
0 ✓
1 ✓
5 ✓
6 ✓
After processing 11:
11 ✓
As soon as dp[11] becomes true, you know:
Yes, there exists a subset whose sum is 11.
Since 11 is half of the total (22), the remaining elements also sum to 11, so the array can be partitioned into two equal subsets.
*/