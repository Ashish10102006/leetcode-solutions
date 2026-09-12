class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        generate(k, n, result, curr, 1, 0);

        return result;
    }

    public void generate(int k, int n,
                         List<List<Integer>> result,
                         List<Integer> curr,
                         int start,
                         int sum) {

        // Base case
        if (curr.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        // Choices
        for (int i = start; i <= 9; i++) {

            // Choose
            curr.add(i);

            // Explore
            generate(k, n, result, curr, i + 1, sum + i);

            // Undo
            curr.remove(curr.size() - 1);
        }
    }
}