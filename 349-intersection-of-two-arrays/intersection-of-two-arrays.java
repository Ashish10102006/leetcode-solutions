class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set=new HashSet<>();
        int len1=nums1.length;
        int len2=nums2.length;

        int i=0,j=0;
        while(i<len1 && j<len2){
            if(nums1[i]<nums2[j])i++;
            else if(nums1[i]>nums2[j])j++;
            else{
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int size=set.size();
        int ans[]=new int[size];
        int k=0;
        for(int no:set){
            ans[k++]=no;
        }
        return ans;
    }
}