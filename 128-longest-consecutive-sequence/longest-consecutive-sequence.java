//Better sol
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int last_smaller = Integer.MIN_VALUE;
        int longest=0;
        int counter=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1==last_smaller){
                counter++;
                last_smaller=nums[i];
            }
            if(nums[i]!=last_smaller){
                counter=1;
                last_smaller=nums[i];
            }
            longest=Math.max(counter,longest);
        }
        return longest;
    }
}