class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max_element=arr[0];
        int index=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max_element){
                max_element=arr[i];
                index=i;
            }
        }
        return index;
    }
}