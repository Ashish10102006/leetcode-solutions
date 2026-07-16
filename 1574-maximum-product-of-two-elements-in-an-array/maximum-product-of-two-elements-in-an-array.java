// Note to remember
// Sorted array → Two pointers may work because the largest/smallest elements are at the ends.
// Unsorted array → Two pointers generally do not work because the required elements can be anywhere. Traverse the array or sort it first.

class Solution {
    public int maxProduct(int[] nums) {
        int max1=0;
        int max2=0;
        for(int no:nums){
            if(no > max1){
                max2 = max1;   // Save the old largest
                max1 = no;     // Update the largest
            }
            else if (no > max2) {
                max2 = no;
            }
        }
        return (max1-1)*(max2-1);
    }
}