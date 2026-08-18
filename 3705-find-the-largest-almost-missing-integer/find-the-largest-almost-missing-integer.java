class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;

        if(k>n) return -1;

        ArrayList<ArrayList<Integer>> subarrays = new ArrayList<>();

        // Create all subarrays of size k
        for(int i=0; i<=n-k ;i++){

            ArrayList<Integer> subarray = new ArrayList<Integer>();

            for(int j=i ; j<i+k ;j++){
                subarray.add(nums[j]);
            }

            subarrays.add(subarray); 
        }

        int max=-1;

        // Check every number
        for(int i=0;i<n;i++){
            int count=0;
            for(ArrayList<Integer> row :subarrays ){
                if(row.contains(nums[i])) count++;
                
                if(count>1) break;
            }
            if(count==1){
                max=Math.max(max,nums[i]);
            }
        }

        return max;
    }
}