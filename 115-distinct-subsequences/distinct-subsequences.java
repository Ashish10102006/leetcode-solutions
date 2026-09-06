class Solution {
    int[][] dp;

    public int numDistinct(String s, String t) {

        dp = new int[s.length()][t.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return find(0, 0, s, t);
    }

    public int find(int i, int j, String s, String t) {

        if (j == t.length())
            return 1;

        if (i == s.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {

            return dp[i][j] =
                find(i + 1, j + 1, s, t)
                + find(i + 1, j, s, t);

        } else {

            return dp[i][j] =
                find(i + 1, j, s, t);
        }
    }
}