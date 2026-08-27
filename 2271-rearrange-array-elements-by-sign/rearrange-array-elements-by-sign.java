class Solution {
    public int[] rearrangeArray(int[] nums) {
        int size=nums.length;
        int positive[]=new int[size/2];
        int negative[]=new int[size/2];
        int k=0,l=0;
        for(int i=0;i<size;i++){
            if(nums[i]<0) negative[l++]=nums[i];
            else positive[k++]=nums[i];
        }
        int result[]=new int[size]; 
        int z=0;

        for (int i = 0; i < size / 2; i++) {
            result[z++] = positive[i];
            result[z++] = negative[i];
        }

        return result;
    }
}