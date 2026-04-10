class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int starting=-1;
        int ending=-1;

        // find first occurrence
        int l=0;
        int r=nums.length-1;
        while(l<=r){
           int mid = l + (r - l) / 2;
           if (nums[mid]>=target){
                r = mid - 1;
            } else {
                l = mid + 1;
            }

            if (nums[mid] == target) starting = mid;
        }

         // find last occurrence
        l = 0;
        r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

            if (nums[mid] == target) ending = mid;
        }


        return new int[]{starting,ending};
    }
}