// class Solution {
//     public int characterReplacement(String s, int k) {
//         Map<Character, Integer> map = new HashMap<>();
        
//         int left = 0;
//         int maxFreq = 0;
//         int result = 0;

//         for (int right = 0; right < s.length(); right++) {
//             char ch = s.charAt(right);

//             // update frequency
//             map.put(ch, map.getOrDefault(ch, 0) + 1);

//             // update max frequency
//             maxFreq = Math.max(maxFreq, map.get(ch));

//             // check if window is invalid
//             if ((right - left + 1) - maxFreq > k) {
//                 char leftChar = s.charAt(left);
//                 map.put(leftChar, map.get(leftChar) - 1);
//                 left++;
//             }

//             // update result
//             result = Math.max(result, right - left + 1);
//         }

//         return result;
//     }
// }
//   Sliding Window + HashMap

class Solution {

    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {

            // Update the frequency of the current character
            freq[s.charAt(right) - 'A']++;

            // Update the max frequency
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowLength = right - left + 1;

            // If invalid window, shrink it
            if (windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update window size after possible shrink
            windowLength = right - left + 1;
            maxWindow = Math.max(maxWindow, windowLength);
        }

        return maxWindow;
    }
}
//   Sliding Window + Frequency Array (Greedy Optimization)
