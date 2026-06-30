class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums, new ArrayList<>(), result);
        return result;
    }
    public void backtrack(int start,int[]nums, List<Integer> temp, 
    List<List<Integer>> result){
        result.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(i + 1, nums, temp, result);
            temp.remove(temp.size() - 1);
        }

    }
}
// nums = [1,2,3]

// the subsets are added in this order:

// Step	    temp when result.add() runs	                   Output so far
// 1	           []	                                        [[]]
// 2	          [1]	                                     [[], [1]]
// 3	         [1,2]	                               [[], [1], [1,2]]
// 4	        [1,2,3]	                             [[], [1], [1,2], [1,2,3]]
// 5	         [1,3]	                           [[], [1], [1,2], [1,2,3], [1,3]]
// 6	          [2]	                         [[], [1], [1,2], [1,2,3], [1,3], [2]]
// 7	         [2,3]	                      [[], [1], [1,2], [1,2,3], [1,3], [2], [2,3]]
// 8	          [3]	                 [[], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]]