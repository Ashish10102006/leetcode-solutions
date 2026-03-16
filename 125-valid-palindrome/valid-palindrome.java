class Solution {
    public boolean isPalindrome(String s) {
       StringBuilder filtered = new StringBuilder();

        // 1. Keep only alphanumeric and make lowercase
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                filtered.append(Character.toLowerCase(c));
            }
        }

        // 2. Reverse the filtered string
        String original = filtered.toString();
        String reversed = new StringBuilder(original).reverse().toString();

        // 3. Compare original with reversed
        return original.equals(reversed);
    }
}