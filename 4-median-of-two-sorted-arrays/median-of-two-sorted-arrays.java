class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int newLength = nums1.length + nums2.length;
        int newArray[] = new int[newLength];

        int i=0,j=0,k=0;
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {
                newArray[k++] = nums1[i++];
            } else {
                newArray[k++] = nums2[j++];
            }
        }

        while(i < nums1.length) newArray[k++]=nums1[i++];
        while(j < nums2.length) newArray[k++]=nums2[j++];

        // Find median
        if (newLength % 2 == 0) {
            return (newArray[newLength / 2]
                    + newArray[newLength / 2 - 1]) / 2.0;
        } else {
            return newArray[newLength / 2];
        }
    }
}