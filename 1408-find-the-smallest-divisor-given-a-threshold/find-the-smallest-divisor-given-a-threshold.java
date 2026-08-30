// 1st way - linear
/*
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        for (int i = 1; i<= maxi; i++) {
            int sum = 0;

            for(int j = 0; j < n; j++){
                sum+=Math.ceil((double) nums[j] / (double)(i));
            }

            if(sum<=threshold) return i;
        }    

        return -1;
    }
}
*/
//ceil(a / b) = (a + b - 1) / b

// 2nd way binary
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;

        int low=1;
        int high=0;

        // Find maximum number
        for (int num : nums) {
            high = Math.max(high, num);
        }


        int ans=high;
        while (low <= high) {

            int mid = low + (high - low) / 2;

            int sum = 0;

            // Calculate sum of ceil(num / mid)
            for (int num : nums) {
                sum += (int) Math.ceil((double) num / mid);
            }

            if (sum <= threshold) {
                ans = mid;
                high = mid - 1;   // Try smaller divisor
            } else {
                low = mid + 1;    // Need larger divisor
            }
        }

        return ans;
    }    
}    