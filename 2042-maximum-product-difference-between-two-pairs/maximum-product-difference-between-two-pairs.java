class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int w=nums[0];
        int x=nums[1];
        int y=nums[n-2];
        int z=nums[n-1];
        return (z*y)-(x*w);
    }
}