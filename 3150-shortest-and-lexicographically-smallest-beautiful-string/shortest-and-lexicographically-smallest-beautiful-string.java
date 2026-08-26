class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        Set<String> set = new HashSet<>();
        int n=s.length();

        for(int i=0;i<n;i++){
            int count =0;//no of ones in current substring
            for(int j=i;j<n;j++){
                if (s.charAt(j) == '1') {
                    count++;
                }
                if(count==k)set.add(s.substring(i,j+1));
                if(count>k) break;
            }
        }

        String ans="";
        for(String str:set){
            if(ans.equals("")) ans=str;
            else if(str.length() < ans.length()) ans=str;
            else if(str.length() == ans.length() && str.compareTo(ans) < 0)ans=str;
        }

        return ans;

    }
}
/*
The question is asking:

Find the shortest substring containing exactly k ones; if multiple substrings have that shortest length, return the lexicographically smallest one.

compareTo() compares characters from left to right.

str.compareTo(ans) < 0  → str is smaller
str.compareTo(ans) == 0 → both are equal
str.compareTo(ans) > 0  → str is larger
*/