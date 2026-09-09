class Solution {
    public long countCommas(long n) {
        long count = 0;
        long power = 1000;

        while (power <= n) {
            count += n - power + 1;
            power *= 1000;
        }

        return count;
    }
}