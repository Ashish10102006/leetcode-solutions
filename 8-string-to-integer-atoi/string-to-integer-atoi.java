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

        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        int i = 0;
        int sign = 1;
        long num = 0;

        // Sign
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Limit depends on sign
        long limit = (sign == 1)
                ? Integer.MAX_VALUE
                : -(long) Integer.MIN_VALUE;

        // Read digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Overflow check
            if (num > (limit - digit) / 10) {
                return sign == 1
                        ? Integer.MAX_VALUE
                        : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return (int) (num * sign);
    }
}