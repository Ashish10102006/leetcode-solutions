class Solution {
    public int rob(int[] money) {
        int n = money.length;

        if (n == 1) return money[0];
        if (n == 2) return Math.max(money[0], money[1]);

        // Case 1: Exclude last house
        int dp[] = new int[n];

        dp[0] = money[0];
        dp[1] = Math.max(money[0], money[1]);

        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }

        int case1 = dp[n - 2];

        // Case 2: Exclude first house
        dp[1] = money[1];
        dp[2] = Math.max(money[1], money[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }

        int case2 = dp[n - 1];

        return Math.max(case1, case2);
    }
}