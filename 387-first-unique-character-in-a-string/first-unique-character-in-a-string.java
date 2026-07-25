
/*
class Solution {
    public int firstUniqChar(String s) {
        int index=-1;
        for(char c:s.toCharArray()){
            if(s.indexOf(c)==s.lastIndexOf(c)){
                index=s.indexOf(c);
                break;
            }
        }
        return index;
    }
}
*/
// Time Complexity

// Inside the loop, for every character, you do:

// s.indexOf(c) → scans the string → O(n)
// s.lastIndexOf(c) → scans the string → O(n)

// Since this happens for each character:

// Outer loop → O(n)
// Inner operations → O(n)

// Overall:

// O(n²)

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}