class Solution {
    public int findDuplicate(int[] nums) {
        // Your code goes here
        int n=nums.length;
        int duplicate[]=new int[n];

        for(int i:nums) duplicate[i]++;

        for(int i=0; i<n;i++){
            if(duplicate[i]>1) return i;
        }
        return -1;
    }
}
// Remember:
// - n = maximum possible value in the array.
// - n + 1 = total number of elements in the array.