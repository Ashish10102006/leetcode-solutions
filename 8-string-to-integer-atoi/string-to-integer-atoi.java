/*
class Solution {
    public int myAtoi(String s) {
        int i=0;

        // 1. Skip spaces
        while(i<s.length() && s.charAt(i) == ' ')i++;

        // 2. Read sign
        int start = i;

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        // 3. Read digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) i++;  

        // 4. Take the number
        String numString = s.substring(start, i);

        // 5. Convert
        int num = Integer.parseInt(numString);
    }
}
*/

/*
Before number starts:
+ / - → sign

After number starts:
anything that isn't 0–9 → STOP

"   -123abc45"

spaces → ignore
-      → negative
123    → read
a      → STOP

-123
*/
/*
class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        int n=s.length();

        if(s.isEmpty()) return 0;

        int i=0;
        int sign=1;
        long num=0;
        if(s.charAt(i)=='+' || s.charAt(i)=='-' ){
            sign = ( s.charAt(i)=='-') ? -1:1;
            i++;
        }

        while(i<n && Character.isDigit(s.charAt(i))){
            int digit=s.charAt(i) -'0';
            num = num*10+digit;

            if(num*digit < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            if(num*digit > Integer.MAX_VALUE) return Integer.MAX_VALUE;

            i++;
        }

        return (int)num*sign;
    }
}
*/

class Solution {
    public int myAtoi(String s) {
        s = s.trim(); // Remove leading whitespace
        int sign = 1, i = 0;
        long res = 0; // Using long to handle overflow cases

        if (s.length() == 0) return 0;

        // Check for sign
        if (s.charAt(0) == '-') { sign = -1; i++; }
        else if (s.charAt(0) == '+') { i++; }

        // Process numerical characters
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break; // Stop at non-numeric character

            res = res * 10 + (ch - '0'); // Convert char to number
            if (sign * res > Integer.MAX_VALUE) return Integer.MAX_VALUE; // Handle overflow
            if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }
        return (int) (sign * res);
    }
}