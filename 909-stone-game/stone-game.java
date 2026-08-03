class Solution {
    public boolean stoneGame(int[] piles) {
        // return true;


        Integer dp[][] = new Integer[piles.length][piles.length];
        // dp[i][j] = the maximum score difference that the current player can achieve over the opponent when only piles from index i to j remain.


        // return solve(piles, 0, piles.length-1,dp) >0;
        return true;
    }

    public int solve(int[] nums, int left,int right, Integer[][] dp){

        if(left==right){
            return nums[left];
        }

        if(dp[left][right]!=null){
            return dp[left][right];
        }

        int leftAns = nums[left] - solve(nums, left+1,right, dp );
        int rightAns = nums[right] - solve(nums, left, right-1, dp);

        dp[left][right] = Math.max(leftAns, rightAns);

        return dp[left][right];

    }

}

/*
solve(0,2)
│
├── solve(1,2)
│     │
│     ├── solve(2,2) → 4
│     │
│     └── solve(1,1) → 3
│
└── solve(0,1)
      │
      ├── solve(1,1) → 3
      │
      └── solve(0,0) → 5
*/      
