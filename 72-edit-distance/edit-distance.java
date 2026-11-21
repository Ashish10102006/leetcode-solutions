class Solution {
    public int minDistance(String start, String target) {
        int m=start.length();
        int n=target.length();

        int dp[][]=new int[m+1][n+1];

        //To convert a string of length i into an empty string, delete all i characters.
        for(int i=0;i<=m;i++) dp[i][0]=i;

        //To convert an empty string into a string of length j, insert all j characters.
        for(int j=0;j<=n;j++) dp[0][j]=j;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){

                if(start.charAt(i-1)==target.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];    
    }
}
/*
dp[i][j] = minimum operations required to convert the first i characters of start into the first j characters of target.
*/
