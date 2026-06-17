class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int difference = i - map.get(nums[i]);

                if (difference <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }
}

// Main Logic

// Since we need a nearby duplicate, always remember the latest index of each number because the latest occurrence gives the smallest possible distance to future elements.

// That's why:

// map.put(nums[i], i);

// is the key line in the solution. It keeps the most recent occurrence, which is the best candidate for finding a nearby duplicate.