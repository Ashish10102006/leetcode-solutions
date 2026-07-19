class Solution {
    public int minSwaps(String s) {
        int balance =0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--;
                }
            }
        }

        return (balance + 1) / 2;
    }
}

// Logic to remember
// balance = number of unmatched '['.
// ']' decreases balance only if there is an unmatched '[' available.
// One swap fixes 2 unmatched '[', so answer = (balance + 1) / 2.