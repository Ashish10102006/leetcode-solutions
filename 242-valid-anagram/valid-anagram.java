import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        // if (s.length() != t.length())
        //     return false;

        // HashMap<Character, Integer> map = new HashMap<>();

        // for (char c : s.toCharArray()) {
        //     map.put(c, map.getOrDefault(c, 0) + 1);
        // }

        // for (char c : t.toCharArray()) {
        //     if (!map.containsKey(c) || map.get(c) == 0) {
        //         return false;
        //     }
        //     map.put(c, map.get(c) - 1);
        // }

        // return true;

//2nd Way to Solve 
        if (s.length() != t.length())
           return false;
        char a1[]=s.toCharArray();
        char a2[]=t.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1,a2);
    }
}