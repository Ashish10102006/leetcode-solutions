/*
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;

        if(n == 1) {
            return 0;
        }

        for(int i=0;i<n;i++){
            if(i==n-1){
                if(nums[i]>nums[i-1]) return i; 
            }
            else if(i==0){
                if(nums[i]>nums[i+1]) return i;
            }

            else{
                if(nums[i]>nums[i-1] && nums[i]>nums[i+1] ) return i;
            }
        }
        return -1;
    }
}
*/

//2ND WAY BINARY SEARCH

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

/*
                 Compare mid and mid+1
                          ↓
                ┌─────────┴─────────┐
                ↓                   ↓
          mid > mid+1          mid < mid+1
             going DOWN           going UP
                ↓                   ↓
          peak is LEFT          peak is RIGHT
                ↓                   ↓
            high = mid        low = mid+1

*/            