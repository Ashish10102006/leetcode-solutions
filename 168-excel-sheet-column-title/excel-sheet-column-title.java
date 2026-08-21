class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;

            int remainder = columnNumber % 26;
            char ch=(char) ('A' + remainder);

            result.append(ch);
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }
}
// This is the part that usually feels strange.

// Every time we divide by 26, we're moving to the next Excel column position.

// That new position is again 1-based.