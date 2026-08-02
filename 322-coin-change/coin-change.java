/*
// Gerrdy-method
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int totalCoin=0;
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                totalCoin++;
            }
        }
        if (amount != 0)return -1;
        return totalCoin;
    }
}
// Fail in the test case
*/

//2nd way=optimal way=DP
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        
        // Initialize all amounts as impossible
        Arrays.fill(dp, amount + 1);

        // Base case
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for(int coin:coins){
                if(i>=coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
