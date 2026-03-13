class Solution {
    public static void swap(int ar[],int a,int b){
        int temp=ar[a];
        ar[a]=ar[b];
        ar[b]=temp;
    }
        public void sortColors(int[] nums) {
        // int zeros=0,ones=0,second=0;
        // for(int n:nums){
        //     if(n==0) zeros++;
        //     else if(n==1) ones++;
        //     else second++;
        // }
        // int i=0;
        // while(zeros-- > 0) nums[i++]= 0;
        // while(ones-- >0) nums[i++]= 1;
        // while(second-- >0) nums[i++]= 2;
        int low = 0, i = 0, high = nums.length - 1;

        while(i <= high) {
            if(nums[i] == 0) {
                swap(nums, i, low);
                i++;
                low++;
            } else if(nums[i] == 2) {
                swap(nums, i, high);
                high--; // do not increase i
            } else { // nums[i] == 1
                i++;
            }
        }
    }
}