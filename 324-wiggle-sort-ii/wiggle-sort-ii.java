/*
class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        int left=(n-1)/2;
        int right=n-1;
        int arr[]=nums.clone();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(i%2==0){
                nums[i]=arr[left--];
            }
            else{
                nums[i]=arr[right--];
            }
        }
    }
}
*/
/*
//2nd approch-optimal
Wiggle Sort II – Optimal O(n) Approach (Short Notes)
Algorithm
Find the median using QuickSelect → O(n).

Three-way partition (Dutch National Flag):
> median | = median | < median
Virtual Index Mapping to place elements in wiggle order.

Virtual Index Formula
mappedIndex = (1 + 2 * i) % (n | 1);
Why n | 1?
Makes the modulus always odd.
If n is even → n + 1
If n is odd → n
Examples:
6 | 1 = 7
7 | 1 = 7

Why 2*i + 1?
Generates odd indices:
1, 3, 5, 7, ...

Why modulo (n | 1)?

Wraps the sequence to visit every index exactly once.

For n = 6:
(1 + 2*i) % 7
→ 1, 3, 5, 0, 2, 4
Order:
Odd indices first
Then even indices
Why this order?
Place larger than median elements at odd indices.
Place smaller than median elements at even indices.
Median values naturally fill the remaining positions.

This guarantees:

nums[0] < nums[1] > nums[2] < nums[3] ...
*/
class Solution {

    public void wiggleSort(int[] nums) {

        int n = nums.length;
        int median = quickSelect(nums, 0, n - 1, n / 2);

        int left = 0;
        int i = 0;
        int right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left, n), newIndex(i, n));
                left++;
                i++;
            }
            else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right, n), newIndex(i, n));
                right--;
            }
            else {
                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {

        if (low <= high) {

            int pivotIndex = partition(nums, low, high);

            if (pivotIndex == k)
                return nums[pivotIndex];

            if (pivotIndex > k)
                return quickSelect(nums, low, pivotIndex - 1, k);

            return quickSelect(nums, pivotIndex + 1, high, k);
        }

        return -1;
    }

    private int partition(int[] nums, int low, int high) {

        int pivot = nums[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (i <= high && nums[i] <= pivot)
                i++;

            while (j >= low && nums[j] > pivot)
                j--;

            if (i < j)
                swap(nums, i, j);
        }

        swap(nums, low, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}