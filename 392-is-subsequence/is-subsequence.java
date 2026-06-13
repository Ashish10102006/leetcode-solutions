class Solution {
    public boolean isSubsequence(String s, String t) {
        return helper(s,t,0,0);
    }
    public boolean helper(String s, String t,int i,int j){
        if(i==s.length()) return true;
        if(j==t.length()) return false;
        if(s.charAt(i)==t.charAt(j)) return helper(s,t,i+1,j+1);
        return helper(s,t,i,j+1);
    }
}
// What do i and j represent?
// i → string s (what we WANT to find)
// j → string t (where we SEARCH)
// Remember this sentence:

// "If I found everything I wanted (s), return true. If I finished searching (t) before finding everything, return false."

