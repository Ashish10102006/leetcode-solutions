class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // number → index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // the number we need

            // if we already saw that number, we are done
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // otherwise, store this number for future
            map.put(nums[i], i);
        }

        return new int[] {}; 
    }
}