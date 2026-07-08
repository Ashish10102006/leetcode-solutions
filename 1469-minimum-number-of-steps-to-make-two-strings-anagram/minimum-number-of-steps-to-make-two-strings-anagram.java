//Frequency map → Count shortages → Shortages = Minimum replacements

/*
class Solution {
    public int minSteps(String s, String t) {
        Map<Character,Integer> map1= new HashMap<>();
        Map<Character,Integer> map2= new HashMap<>();

        for(char c:s.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }

        for(char c:t.toCharArray()){
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        int missing=0;
        for(char c:map1.keySet()){
            int need=map1.get(c);
            int have=map2.getOrDefault(c, 0);

            if(need>have) missing+=need-have;
        }
        return missing;

    }
} //problem=taking too much space;
*/
class Solution {
    public int minSteps(String s, String t) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        for (char ch : t.toCharArray())
            freq[ch - 'a']--;

        int ans = 0;

        for (int x : freq) {
            if (x > 0)
                ans += x;
        }

        return ans;
    }
}