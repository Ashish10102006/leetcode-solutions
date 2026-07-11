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