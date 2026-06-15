class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[]=s.split("\\s+");
        if(words.length != pattern.length()) return false;
        Map<Character,String> map= new HashMap<>();
        Set<String> usedWords = new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char c= pattern.charAt(i);
            String word=words[i];
            if(map.containsKey(c)){
                if(!map.get(c).equals(word)) return false;
            }
            else {
                if (usedWords.contains(word)) {
                    return false;
                }

                map.put(c, word);
                usedWords.add(word);
            }
        }
        return true;
    }
}