class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int no:nums){
            set.add(no);
        }

        int multiple=1;

        while (true) {
            if (!set.contains(multiple * k)) {
                return multiple * k;
            }
            multiple++;
        }
    }
}