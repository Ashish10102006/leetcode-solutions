/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n];
        int maxLength = 1;

          // Every element alone is an increasing subsequence of length 1
        Arrays.fill(dp, 1); 

         for (int i = 1; i < n; i++) {
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
         }
         return maxLength;

    }
}

// Meaning of dp
dp[i] = Length of the Longest Increasing Subsequence ending at index i;
*/

class Solution {
    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (list.isEmpty() || list.get(list.size() - 1) < nums[i]) {
                list.add(nums[i]);
            }
            else {
                int left = 0;
                int right = list.size() - 1;

                while (left < right) {

                    int mid = left + (right - left) / 2;

                    if (list.get(mid) < nums[i]) {
                        left = mid + 1;
                    }
                    else {
                        right = mid;
                    }
                }

                list.set(left, nums[i]);
            }
        }

        return list.size();
    }
}