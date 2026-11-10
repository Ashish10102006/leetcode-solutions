class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Your code goes here

        Set<String> set = new HashSet<>(wordDict);
        int n= s.length();
        boolean dp[]=new boolean[n+1];
        dp[0]=true;

        int maxLen = 0;
        for (String word : wordDict) 
        {
            maxLen = Math.max(maxLen, word.length());
        }

        for(int i=1;i<dp.length;i++){
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--){
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];     
    }
}