// 1st apprpch =HashMap-optimal
// Store the first occurrence of each character in a HashMap; whenever the character repeats, compute the distance using the first occurrence and update the maximum.
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, i); // Store first occurrence
            } else {
                max = Math.max(max, i - map.get(ch) - 1);
            }
        }

        return max;
    }
}