/*
class Solution {
    public int[] sortedSquares(int[] nums) {
        int result[]=new int[nums.length];
        for(int i=0;i<result.length;i++){
            result[i]=nums[i]*nums[i];
        }
        Arrays.sort(result);
        return result;
    }
}
*/

//2=ponter approch
// "Since the array is sorted, the largest absolute value is always at one of the two ends. Therefore, I compare the left and right ends, place the larger square at the end of the result array, and move the corresponding pointer. If the array were not sorted, this property would not hold, so the two-pointer approach would not work."
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int index = n - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }

        return result;
    }
}