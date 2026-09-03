class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        generate(candidates, target, 0, current, result);

        return result;
    }
    public void generate(int[] candidates, int target,int index ,List<Integer> current,List<List<Integer>> result){
        if (target == 0) {
            // valid combination
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index >= candidates.length) {
            // invalid combination
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Can't use this number
            if (candidates[i] > target) {
                continue;
            }

            // Choose
            current.add(candidates[i]);

            // i, NOT i + 1 → same number can be reused
            generate(candidates, target - candidates[i], i,
                     current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}