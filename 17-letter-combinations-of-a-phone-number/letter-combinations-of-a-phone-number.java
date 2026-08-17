class Solution {
    public List<String> letterCombinations(String digits) {

        Map<Integer, String> map = new HashMap<>();

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        backtrack(0, "", digits, map, ans);

        return ans;
    }

    public void backtrack(
        int index,
        String current,
        String digits,
        Map<Integer, String> map,
        List<String> ans
    ) {

        // All digits are processed
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        // Get letters for current digit
        int digit = digits.charAt(index) - '0';
        String letters = map.get(digit);

        // Try every letter
        for (char ch : letters.toCharArray()) {

            // Choose the letter and move to next digit
            backtrack(index + 1, current + ch, digits, map, ans);
        }
    }
}