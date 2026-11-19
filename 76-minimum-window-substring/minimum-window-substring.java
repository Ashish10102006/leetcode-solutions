class Solution {
    public String minWindow(String s, String t) {

        if(s.length()< t.length()) return "";

        Map<Character,Integer> map= new HashMap<>();

        for(char c: t.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        
        int left=0;
        int right=0;

        int matched=0;
        int start=-1;
        int minLen = Integer.MAX_VALUE;

        while(right<s.length())
        {
            char c=s.charAt(right);

            if(map.containsKey(c))
            {
                if(map.get(c)>0)matched++;

                map.put(c,map.get(c)-1);
            }
            right++;

            while(matched==t.length())
            {
                if(right-left < minLen)
                {
                    minLen=right-left;
                    start=left;
                }
                char ch = s.charAt(left);

                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) + 1);

                    if(map.get(ch) > 0)matched--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start , start + minLen);
    }
    
}