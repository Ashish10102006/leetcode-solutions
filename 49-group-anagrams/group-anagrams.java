// import java.util.*;

// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> result = new ArrayList<>();
//         boolean[] visited = new boolean[strs.length];

//         for (int i = 0; i < strs.length; i++) {
//             if (visited[i]) continue;

//             List<String> group = new ArrayList<>();
//             group.add(strs[i]);
//             visited[i] = true;

//             for (int j = i + 1; j < strs.length; j++) {
//                 if (!visited[j] && isAnagram(strs[i], strs[j])) {
//                     group.add(strs[j]);
//                     visited[j] = true;
//                 }
//             }

//             result.add(group);
//         }

//         return result;
//     }

//     private boolean isAnagram(String s1, String s2) {
//         if (s1.length() != s2.length()) return false;

//         char[] a = s1.toCharArray();
//         char[] b = s2.toCharArray();

//         Arrays.sort(a);
//         Arrays.sort(b);

//         return Arrays.equals(a, b);
//     }
// }   
// ................Brute Force..................................

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            // Sort the characters of the word to form the key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // If key doesn't exist, create new list
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}