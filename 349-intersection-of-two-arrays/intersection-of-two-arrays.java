/*
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
*/
import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        Set<Integer> result = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n)) {
                result.add(n);
            }
        }
        int[] arr = new int[result.size()];
        int i = 0;

        for (int v : result) {
            arr[i] = v;
            i++;
        }
        return arr;
    }
}