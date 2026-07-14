class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i=-1;
        int j=0;
        while(j<nums.length){
            if(nums[j] %2 == 0){
                i++;
                swap(i,j,nums);
            }
            j++;
        }
        return nums;
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        }
}