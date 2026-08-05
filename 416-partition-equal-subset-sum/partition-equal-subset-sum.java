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

        // // Take the current element
        // boolean take = solve(nums, index + 1, target - nums[index], dp);

        // // Skip the current element
        // boolean skip = solve(nums, index + 1, target, dp);

        // // Store the answer
        // dp[index][target] = take || skip;

        dp[index][target] = solve(nums, index + 1, target - nums[index], dp) ||
                     solve(nums, index + 1, target, dp);

        return dp[index][target];
    }
}
/*
dp[index][target]
read it as:
"Starting from index, can I make the remaining target?"


Remember this one sentence:
boolean = 2 states (true, false)
Boolean = 3 states (true, false, null)
So every cell can have three values:

Value	Meaning
null	Not solved yet
true	Solved, answer is yes
false	Solved, answer is no

Here's the shortest thinking process you should follow:

Can I choose elements?
Yes.
For each element, what are my choices?
✅ Take it
✅ Skip it
What is my goal?
Make a subset with sum = total / 2.
What information do I need to continue?
Current index
Remaining target

Recursive function

solve(index, target)

Means:

Starting from index, can I make the remaining target?

Base cases

target == 0  → true
index == n || target < 0 → false
Repeated states?
Yes → Use memoization.

DP state

dp[index][target]

Means:

Starting from index, can I make the remaining target?

The pattern to remember

Choice → State → Base Case → Memoize
*/