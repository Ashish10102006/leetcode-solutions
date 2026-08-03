/*
class Solution {
    public int change(int amount, int[] coins) {
        return count(0, amount, coins);
    }

    private int count(int index, int amount, int[] coins){

        // Successfully formed the amount
        if(amount==0) return 1;

         // Invalid path
        if (amount < 0)
            return 0;

        // No coins left    
        if (index == coins.length)
            return 0;    

         // Take current coin
        int take = count(index, amount - coins[index], coins);

        // Skip current coin
        int skip = count(index + 1, amount, coins);

        return take + skip;    
    }
}
// Time Limit Exceeded
*/

// 2nd way memoization 

class Solution {
    public int change(int amount, int[] coins) {
         Integer[][] dp = new Integer[coins.length][amount + 1];
        return count(0, amount, coins, dp);
    }
        private int count(int index, int amount, int[] coins, Integer[][] dp) {
            if(amount==0) return 1;
            if(amount<0) return 0;
            if(index==coins.length) return 0;

            // Already computed
            if (dp[index][amount] != null) return dp[index][amount];

            int take = count(index, amount - coins[index], coins, dp);
            int skip = count(index + 1, amount, coins, dp);
            dp[index][amount] = take + skip;
             
             return dp[index][amount];
        }
}



/*
count(index, amount)
Its meaning is:
Number of combinations to make amount using coins starting from index.


count(0,3)
means
How many ways can I make 3 using [1,2,5]?
*/