// 1st way linear search with k=2
/*
class Solution {
    public int splitArray(int[] nums, int k) {

        int totalSum = 0;

        // Find total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int ans = Integer.MAX_VALUE;

        // Try every possible cut
        for (int cut = 0; cut < nums.length - 1; cut++) {

            leftSum += nums[cut];

            int rightSum = totalSum - leftSum;

            int largest = Math.max(leftSum, rightSum);

            ans = Math.min(ans, largest);
        }

        return ans;
    }
}
*/

// 2nd way=Binary search
class Solution {
    public int splitArray(int[] nums, int k) {

        int n=nums.length;

        int high = 0;
        int low  = 0;

        // Find low = maximum element
        // Find total sum
        for (int num : nums) {
            low=Math.max(low,num);
            high += num;
        }

        while(low<=high){
            int mid=low+(high-low)/2;

            int parts=1;
            int sum=0;

            for(int num:nums){
                if(sum + num <= mid) sum+=num;
                else{
                    parts++;
                    sum=num;
                }
            }

            if(parts<=k)high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}        