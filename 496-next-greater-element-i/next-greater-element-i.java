// Memory trick:

// Need Next Greater? → Use a monotonic decreasing stack (pop smaller elements).

// Need Next Smaller? → Use a monotonic increasing stack (pop larger elements).

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int no = -1;

            // Step 1: Find nums1[i] in nums2
            for (int j = 0; j < nums2.length; j++) {

                if (nums2[j] == nums1[i]) {

                    // Step 2: Search only to the right
                    for (int k = j + 1; k < nums2.length; k++) {

                        if (nums2[k] > nums1[i]) {
                            no = nums2[k];
                            break; // First greater element found
                        }
                    }

                    break; // We already found nums1[i] in nums2
                }
            }

            result[i] = no;
        }

        return result;
    }
}