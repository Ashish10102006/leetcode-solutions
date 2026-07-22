/*
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
*/
// 2nd approch
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Increasing part
                left = mid + 1;
            } else {
                // Decreasing part or peak
                right = mid;
            }
        }

        return left;
    }
}
/* 
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 1;
        int high = arr.length - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Peak found
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // We are on the increasing side
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            // We are on the decreasing side
            else {
                high = mid - 1;
            }
        }

        return -1; // This will never execute because the input is guaranteed to be a mountain array.
    }
}
*/
// Approach 2: Since we already checked whether mid is the answer, if the check fails, mid is definitely not the answer. So it is safe to remove mid from the search space (high = mid - 1 or low = mid + 1).