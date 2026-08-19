// Keep adding ( until you have used n, and add ) only when close < open; whenever both reach n, save the string.
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        generate("", 0, 0, n, ans);

        return ans;
    }

    public void generate(String current, int open, int close, int n, List<String> ans) {

        if (open == n && close == n) {
            ans.add(current);
            return;
        }

        // Add '('
        if (open < n) {
            generate(current + "(", open + 1, close, n, ans);
        }

        // Add ')'
        if (close < open) {
            generate(current + ")", open, close + 1, n, ans);
        }
    }
}