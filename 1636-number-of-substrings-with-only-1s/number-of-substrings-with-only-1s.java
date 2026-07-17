class Solution {
    public int numSub(String s) {
        long total = 0;
        long count = 0;
        int MOD = 1000000007;

        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count++;
                total = (total + count) % MOD;
            } else {
                count = 0;
            }
        }

        return (int) total;
    }
}