class Solution {
    public int maxProduct(int[] nums) {
        int maxprod=nums[0];
        int minprod=nums[0];
        int ans =nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if(n<0){
                int temp=maxprod;
                maxprod=minprod;
                minprod=temp;
            }
            maxprod=Math.max(n,maxprod*n);
            minprod=Math.min(n,minprod*n);
            ans=Math.max(ans,maxprod);
        }
        return ans;
    }
}