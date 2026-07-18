/*
class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return c;
            }

            map.put(c, map.get(c) - 1);
        }

        return ' ';
    }
}
*/
// 2nd approch-optimal
class Solution {
    public char findTheDifference(String s, String t) {
        char ans = 0;

        for (char c : s.toCharArray()) {
            ans ^= c;
        }

        for (char c : t.toCharArray()) {
            ans ^= c;
        }

        return ans;
    }
}