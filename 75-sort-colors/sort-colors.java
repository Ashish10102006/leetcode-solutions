// Three pointers approch
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
        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            } else if(nums[mid] == 2) {
                swap(nums, mid, high);
                high--; // do not increase i
            } else { // nums[i] == 1
                mid++;
            }
        }
    }
}

// Memory trick:
// 0 → move left (low++, mid++)
// 1 → stay in middle (mid++)
// 2 → move right (high--, don't move mid)