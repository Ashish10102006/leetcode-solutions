// class Solution {
//     int max=0,start=0,end=0;
//     public boolean isPalindrome(String s,int i, int j)
//     {
//         while(i<j)
//         {
//             char ch1=s.charAt(i);
//             char ch2=s.charAt(j);
//             if(ch1!=ch2)
//               return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
//     public String longestPalindrome(String s) {
//         int n=s.length();
//         for(int i=0;i<n;i++)
//         {
//            for(int j=i;j<n;j++)
//            {
//               if(isPalindrome(s,i,j)==true)
//               {
//                 if((j-i+1)>max)
//                 {
//                     max=j-i+1;
//                     start=i;
//                     end=j;
//                 }  
//               } 
//            } 
//         }
//        return s.substring(start,end+1); 
//     }
// }
//                  TC-O(n^3)-Brute Force 


class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);     // odd
            int len2 = expand(s, i, i + 1); // even
            int maxLen = Math.max(len1, len2);
            if (maxLen > (end - start)) {
                start = i - (maxLen - 1) / 2;
                end   = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() 
               && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
} 
//                      TC-O(n^2)-Optimal