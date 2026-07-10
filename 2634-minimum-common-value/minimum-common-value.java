class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int min_common=-1;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                min_common=nums1[i];
                break;
            }
            else if(nums1[i] < nums2[j]) i++;
            else j++;
        }
        return min_common;
    }
}