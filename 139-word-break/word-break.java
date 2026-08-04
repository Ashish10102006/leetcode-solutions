class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

       //Convert the dictionary into a set for O(1) lookup 
       Set<String> wordSet = new HashSet<>(wordDict);

       // Find the maximum word length in the dictionary. 
       int maxLength=0;
       for(String word:wordDict){
        maxLength=Math.max(maxLength,word.length());
       }

       int n=s.length();
       // dp[i] states if the  substring s[0...i] can be segmented.
       boolean dp[]=new boolean[n+1];

       // Base case:Empty string is valid
       dp[0]=true;


       for(int i=1;i<=n;i++){
          for (int j = i - 1; j >= Math.max(0, i - maxLength); j--) {
            if(dp[j] && wordSet.contains(s.substring(j,i)) ){
                dp[i]=true;
                break;
            }
          }
        }

        return dp[n];
    }
}
//Segmented means split into smaller parts.
// For this problem, it means:
// Split the string into one or more words, where every word exists in wordDict.