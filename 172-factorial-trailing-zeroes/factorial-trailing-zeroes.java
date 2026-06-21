// Even or odd doesn’t matter — only how many times 5 appears in numbers up to n.
class Solution {
    public int trailingZeroes(int n) {
       int result=0;
       for(int i=5;i<=n;i*=5){
        result+=n/i;
       }
       return result;
    }
}
// Final formula (built step-by-step)
// trailing zeros=⌊n/5⌋+⌊n/25⌋+⌊n/125⌋+...
// We divide by powers of 5 because:
// each power of 5 shows how many 5s are hidden inside numbers

// until it becomes 0.
// Instead of thinking:

// “factorial is huge multiplication”
// Think:
// “I am just counting how many times 5 appears inside all numbers up to n”

