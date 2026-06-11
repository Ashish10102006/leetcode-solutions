import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = Map.of(
            'I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000
        );

        int total = 0;
        int prevValue = 0;

        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));
            if (currentValue < prevValue) {
                total -= currentValue;  // subtract if smaller than previous
            } else {
                total += currentValue;  // otherwise add
            }
            prevValue = currentValue;
        }

        return total;
    }
}
// Pattern to Remember

// Scan from left to right.

// For each character:

// If current value < next value
//     subtract current value
// Else
//     add current value