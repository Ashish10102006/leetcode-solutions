class Solution {
    public void nextPermutation(int[] nums) {

        // 1. Find pivot
        int i = nums.length - 2;//is because we are checking two elements at a time

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. Find the next greater element and swap
        if (i >= 0) {
            int j = nums.length - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 3. Reverse the elements after pivot
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
/*
1. Find i from right where nums[i] < nums[i+1]
2. Find j from right where nums[j] > nums[i]
3. Swap i and j
4. Reverse i+1 to end
*/

/*
Why specifically REVERSE?

Because before the swap, the part after the pivot is in descending order.

Example:

[1 | 5 4 3 2]

After swapping 1 with 2:

[2 | 5 4 3 1]

We want the smallest possible order after 2.

The smallest order is:

1 3 4 5

Since the suffix is arranged in descending order, reversing it gives:

5 4 3 1
↓ ↓ ↓ ↓
1 3 4 5

So:

[2 | 5 4 3 1]

becomes:

[2 | 1 3 4 5]
The whole idea
Find pivot
    ↓
Make pivot slightly bigger
    ↓
Now minimize everything after it
    ↓
Since that part is descending
    ↓
REVERSE it

So the algorithm is basically:

"Increase the number as little as possible, then make everything after it as small as possible."

That's why we swap first and reverse afterward.
*/