class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) ans++;
            else ans=0;
            max=Math.max(ans,max);
        }
        return max;
    }
}