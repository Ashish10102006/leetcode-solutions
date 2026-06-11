import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = Map.of(
            'I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000
        );

           int result = 0;

        for (int i = 0; i < s.length(); i++) 
        {
            int current = romanMap.get(s.charAt(i));

            if (i < s.length() - 1 &&
                current < romanMap.get(s.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }

    }


// Pattern to Remember

// Scan from left to right.

// For each character:

// If current value < next value
//     subtract current value
// Else
//     add current value