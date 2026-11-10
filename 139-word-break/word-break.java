class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Your code goes here

        Set<String> set = new HashSet<>(wordDict);
        int n= s.length();
        boolean dp[]=new boolean[n+1];
        dp[0]=true;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];     
    }
}