// The condition is:
// For every subarray of length 3,
// [a, b, c]

// Condition:
// a + c = b / 2
// 2 * (a + c) == b

class Solution {
    public int countSubarrays(int[] nums) {
        int count =0;
        for (int i = 0; i <= nums.length - 3; i++) {
            // Check nums[i], nums[i+1], nums[i+2]
            if(2*(nums[i]+nums[i+2])==nums[i+1]) count++;

        }
        return count;
    }
}