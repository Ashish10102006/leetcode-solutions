//dp approch O(n^2)
// class Solution {
//     public int jump(int[] nums) {
//          int n = nums.length;
//          int[] dp = new int[n];
//           for (int i = 1; i < n; i++) {
//             dp[i] = Integer.MAX_VALUE;
//         }
        
//          for(int i=0;i<n;i++){
//             for(int j=i+1;j<=i+nums[i] && j<n;j++){
//                 dp[j]=Math.min(dp[j], dp[i] + 1);
//             }
//          }
//         return dp[n-1];
//     }
// }


// dp[i]
// ↓
// minimum jumps to reach i

// dp[i] + 1
// ↓
// minimum jumps to reach j through i

//greedy O(n)
class Solution {
     public int jump(int[] nums) {
        int jumps=0;
        int currentend=0;
        int farthest=0;
        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest,nums[i]+i);
            if(i==currentend){
                jumps++;
               currentend=farthest;
            }
        }
        return jumps;
     } 
}