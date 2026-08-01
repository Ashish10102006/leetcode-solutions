/*
Whenever you read a problem, mentally check these five boxes:

□ Maximum / Minimum / Ways?
□ Choice at each step?
□ Current choice affects future?
□ Smaller version of same problem?
□ Repeated work if recursive?

If you tick 4 or 5 boxes, you should seriously consider Dynamic Programming.
*/

class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int dp[]=new int[nums.length];

        dp[0]=nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max( nums[i]+dp[i-2] , dp[i-1] );
        }

        return dp[nums.length-1];
    }
}
/*
step 1: What is the decision at each position?
At every house, you have only two choices:
Rob this house
Skip this house
Whenever a problem asks you to make a choice at every index, that's your first hint that DP might be useful.

Step 2: Does my current choice affect future choices?
Yes.
If you rob house i, you cannot rob house i+1.
So your decision at the current house affects the next one.
This is another strong DP clue.

Step 3: Does the same subproblem repeat?
Suppose you're at house 5.
The best answer from house 0 to house 5 depends on the best answer up to house 3 or house 4.
You'll keep asking:
"What is the maximum money I can collect up to this house?"
That same type of question repeats for every house.

Repeated subproblems + optimal choices = DP.
*/