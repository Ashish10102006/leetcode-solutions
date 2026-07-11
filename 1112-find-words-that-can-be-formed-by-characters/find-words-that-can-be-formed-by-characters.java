/*
class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer> frequency = new HashMap<>();
        for(char c:chars.toCharArray()){
            frequency.put(c,frequency.getOrDefault(c,0)+1);
        }

        int length=0;
        for(String word:words){
            Map<Character, Integer> map = new HashMap<>();

            for (char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            boolean possible = true;

            for (char c : map.keySet()) {
                if (map.get(c) > frequency.getOrDefault(c, 0)) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                length += word.length();
            }
        }
        return length;
    }
}
*/

// 2nd approch optimal solution

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];

        for (char c : chars.toCharArray()) {
            freq[c - 'a']++;
        }

        int ans = 0;

        for (String word : words) {
            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            boolean possible = true;

            for (int i = 0; i < 26; i++) {
                if (count[i] > freq[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                ans += word.length();
            }
        }

        return ans;
    }
}