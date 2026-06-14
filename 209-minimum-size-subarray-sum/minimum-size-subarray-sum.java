class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int current_sum=0;//current windows sum
        int min_len= Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            current_sum+= nums[right];
            while(current_sum>=target){
                min_len=Math.min(min_len,right-left+1);
                current_sum-=nums[left];
                left++;
            }
        }
        return (min_len == Integer.MAX_VALUE) ? 0 : min_len;
    }
}
// We use >= because:
// We want all valid subarrays, including those whose sum is exactly equal to target, and we also want the smallest one.