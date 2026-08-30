
// class Solution {
//     public int minDays(int[] nums, int m, int k) {
//         int n=nums.length;
//         /* Calculate the minimum 
//            number of flowers required*/
//         long val = (long) m * k; 

//         /* Impossible case: not enough 
//            flowers to make m bouquets*/
//         if (val > n) return -1; 

//         int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
//         for (int i = 0; i < n; i++) {
//             mini = Math.min(mini, nums[i]); 
//             maxi = Math.max(maxi, nums[i]); 
//         }
//          for (int i = mini; i <= maxi; i++) {
//             if (possible(nums, i, m, k))
//                 return i;
//         }
        
//         // Return-1 if no such day exists
//         return -1;
//     }
//     private boolean possible(int[] nums, int day, int m, int k) {
//         int n = nums.length; 
        
//         // Count of flowers bloomed
//         int cnt = 0; 
        
//         // Count of bouquets formed
//         int noOfB = 0; 
//         for(int i=0;i<n;i++){
//             if (nums[i] <= day) {
//                 // Increment flower count
//                 cnt++;
//             }
//             else {
//                 /* Calculate number of bouquets
//                 formed with flowers <= day */
//                 noOfB += (cnt / k);
                
//                 // Reset flower count
//                 cnt = 0; 
//             }     
//         }

//         // Add remaining flowers as a bouquet
//         noOfB += (cnt / k); 

//         /* Return true if enough 
//         bouquets can be formed */
//         return noOfB >= m; 
//     }
// }
class Solution {
    public int minDays(int[] nums, int m, int k) {

        int n = nums.length;

        // Total flowers required
        long required = (long) m * k;

        // Impossible
        if (required > n) {
            return -1;
        }

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        // Find minimum and maximum bloom day
        for (int num : nums) {
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }

        int low = mini;
        int high = maxi;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (possible(nums, mid, m, k)) {

                // mid works, try smaller day
                high = mid - 1;

            } else {

                // mid doesn't work, need more days
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possible(int[] nums, int day, int m, int k) {

        int cnt = 0;
        int bouquets = 0;

        for (int num : nums) {

            if (num <= day) {
                cnt++;

                // We got k consecutive flowers
                if (cnt == k) {
                    bouquets++;
                    cnt = 0;
                }

            } else {
                // Broken consecutive sequence
                cnt = 0;
            }

            if (bouquets >= m) {
                return true;
            }
        }

        return false;
    }
}
